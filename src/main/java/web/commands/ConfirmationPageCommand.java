package web.commands;

import business.entities.Carport;
import business.entities.Order;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmationPageCommand extends CommandProtectedPage{


    public ConfirmationPageCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        OrderFacade orderFacade = new OrderFacade(database);
        CarportFacade carportFacade = new CarportFacade(database);
        double bredde;
        double længde;

        try {
            bredde = Double.parseDouble( request.getParameter("bredde"));
            længde = Double.parseDouble( request.getParameter("længde"));
        } catch (NumberFormatException e) {
            throw new UserException("Fejl i indtastningen på byg carport siden");
        }
        Carport carport = new Carport(længde, bredde, "tom",1,0.0);
        carportFacade.insertCarport(carport);
        carport.getCarport_id();
        Order order = new Order(1,carport.getCarport_id(),0,1);
        orderFacade.insertOrder(order);

        return pageToShow;
    }




}
