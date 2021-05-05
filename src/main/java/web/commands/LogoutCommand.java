package web.commands;

import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand extends CommandUnprotectedPage {

    public LogoutCommand(String pageToShow)
    {
        super(pageToShow);
       // Here you can insert code to run before logout
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return REDIRECT_INDICATOR + request.getContextPath();
    }
}
