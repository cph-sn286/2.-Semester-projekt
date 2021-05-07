package web.commands;

import business.entities.Order;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmationPageCommand extends CommandUnprotectedPage{

    public ConfirmationPageCommand(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        OrderFacade orderFacade = new OrderFacade(database);
        double bredde;
        double længde;

        try {
            bredde = Double.parseDouble( request.getParameter("bredde"));
            længde = Double.parseDouble( request.getParameter("længde"));
        } catch (NumberFormatException e) {
            throw new UserException("Fejl i indtastningen på byg carport siden");
        }
        Order order = new Order(1,1,0,1);
        orderFacade.insertOrder(order);



        return pageToShow;
    }




}
