package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ManageRequestCommand extends CommandProtectedPage{
    public ManageRequestCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        OrderFacade orderFacade = new OrderFacade(database);
        HttpSession session = request.getSession();
        List<Order> orderList = orderFacade.getAllOrdersRequest();
        session.setAttribute("orderlist",orderList);



        return pageToShow;
    }
}
