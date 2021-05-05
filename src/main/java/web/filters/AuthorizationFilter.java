package web.filters;

import web.FrontController;
import web.commands.Command;
import web.commands.CommandProtectedPage;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = {"FrontController"})
public class AuthorizationFilter implements Filter
{
    private enum FailingStrategy
    {
        REDIRECT_TO_LOGIN,
        HARD_ERROR
    }

    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain filterChain)
            throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String servletPath = req.getServletPath();
        if (servletPath != null && servletPath.equals("/fc"))
        {
            Command command = Command.fromPath(req, FrontController.database);
            HttpSession session = req.getSession(false);
            if (command instanceof CommandProtectedPage)
            {
                String roleFromCommand = ((CommandProtectedPage) command).getRole();
                if (session == null || session.getAttribute("user") == null)
                {
                    handleIllegalAccess(
                            req,
                            res,
                            FailingStrategy.HARD_ERROR,
                            "You are not authenticated. Please login first",
                            401);
                    return;
                } else
                {
                    String role = (String) session.getAttribute("role");
                    if (role == null || !role.equals(roleFromCommand))
                    {
                        handleIllegalAccess(
                                req,
                                res,
                                FailingStrategy.REDIRECT_TO_LOGIN,
                                "Attempt to call a resource you are not authorized to view ",
                                403);
                        return;
                    }
                }
            }
        }

        //Prevents users, who has logged out, to use the back-button and see pages they could see, while logged in
//        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//        res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//        res.setDateHeader("Expires", 0); // Proxies.

        filterChain.doFilter(request, response);
    }

    private void handleIllegalAccess(
            HttpServletRequest req,
            HttpServletResponse res,
            FailingStrategy fs,
            String msg, int errCode)
            throws IOException, ServletException
    {
        if (fs == FailingStrategy.REDIRECT_TO_LOGIN)
        {
            req.setAttribute("error", msg);
            req.getRequestDispatcher("/WEB-INF/loginpage.jsp").forward(req, res);
        } else
        {
            res.sendError(errCode);
        }
    }

    public void destroy()
    {
    }
}
