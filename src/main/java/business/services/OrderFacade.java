package business.services;

import business.entities.Order;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;
import business.persistence.UserMapper;

import java.util.List;

public class OrderFacade
{
    OrderMapper orderMapper;

    public OrderFacade(Database database)
    {
        orderMapper = new OrderMapper(database);
    }

    public void insertOrder(Order order) throws UserException {
        orderMapper.insertOrder(order);

    }

    public Order getOrderById(int order_id) throws UserException {

        return orderMapper.getOrderById(order_id);

    }

    public List<Order> getAllOrders()throws UserException{
        return orderMapper.getAllOrders();
    }
    public List<Order> getAllOrdersRequest()throws UserException{
        return orderMapper.getAllOrdersRequest();
    }


}
