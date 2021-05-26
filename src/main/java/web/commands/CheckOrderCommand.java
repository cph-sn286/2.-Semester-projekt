package web.commands;

import business.entities.BillOfMaterials;
import business.entities.Carport;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.persistence.OrderMapper;
import business.services.CarportCalc;
import business.services.CarportFacade;
import business.services.OrderFacade;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckOrderCommand extends CommandProtectedPage {
    public CheckOrderCommand(String pageToShow, String role) {
        super(pageToShow, role);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        CarportFacade carportFacade = new CarportFacade(database);
        OrderFacade orderFacade = new OrderFacade(database);
        CarportCalc carportCalc = new CarportCalc();

        Carport carport = null;
        int order_id;
        int carport_id;
        double totalPrice;


        HttpSession session = request.getSession();

        try {
            order_id = Integer.parseInt(request.getParameter("order_id"));
        } catch (NumberFormatException ex) {

            throw new UserException("fejl");
        }

        session.setAttribute("order_id", order_id);


        carport = carportFacade.getCarportById(orderFacade.getOrderById(order_id).getCarport_id());


        BillOfMaterials billOfMaterials = carportCalc.calcCarport(carport.getLength(), carport.getWidth());

        session.getServletContext().setAttribute("billOfMaterials",billOfMaterials);

        totalPrice = billOfMaterials.totalPrice();

        session.getServletContext().setAttribute("totalPrice",totalPrice);


        return pageToShow;
    }
}
