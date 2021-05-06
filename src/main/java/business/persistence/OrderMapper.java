package business.persistence;

import business.entities.Order;
import business.entities.Status;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    // todo order + status mapper i denne klasse

    private Database database;

    public OrderMapper(Database database) {

        this.database = database;

    }

    public List<Order> getAllOrders() throws UserException {

        List<Order> orderList = new ArrayList<>();

        String sql = "select * from orders";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    int carport_id = rs.getInt("carport_id");
                    double price = rs.getDouble("price");
                    String date = rs.getString("date");
                    int status = rs.getInt("status");

                    orderList.add(new Order(order_id, user_id, carport_id, price, date, status));

                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }
        return orderList;

    }

    public Order insertOrder(Order order) throws UserException {
        boolean result = false;
        int newId = 0;
        String sql = "insert into orders (order_id, user_id, carport_id, price, date, status) values (?,?,?,?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, order.getOrder_id());
                ps.setInt(2, order.getUser_id());
                ps.setInt(3, order.getCarport_id());
                ps.setDouble(4, order.getPrice());
                ps.setString(5, order.getDate());
                ps.setInt(6, order.getStatus());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next()) {
                    newId = idResultset.getInt(1);
                    order.setOrder_id(newId);
                } else {
                    order = null;
                }
            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }


        return order;
    }

    public Order getOrderById(int orderId) throws UserException {
        Order order = null;
        String sql = "select * from orders where order_id = ?";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    int carport_id = rs.getInt("carport_id");
                    double price = rs.getDouble("price");
                    String date = rs.getString("date");
                    int status = rs.getInt("status");

                    order = new Order(order_id, user_id, carport_id, price, date, status);

                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }


        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }

        return order;
    }

    public Order getOrderByUserId(int userId) throws UserException {
        Order order = null;
        String sql = "select * from orders where user_id = ?";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, userId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    int carport_id = rs.getInt("carport_id");
                    double price = rs.getDouble("price");
                    String date = rs.getString("date");
                    int status = rs.getInt("status");

                    order = new Order(order_id, user_id, carport_id, price, date, status);
                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }

        return order;
    }

    public boolean updateOrderStatus(int orderId, int newStatus) throws UserException {
        Boolean result = false;

        String sql = "UPDATE orders SET orders.status = ? WHERE order_id = ?";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, newStatus);
                ps.setInt(2, orderId);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return result;
    }

    public Status getStatusById(int statusId) throws UserException {

        Status status = null;
        String sql = "select * from fogdb.status where status_id = ?";

        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, statusId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int status_id = rs.getInt("status_id");
                    String statusText = rs.getString("status");

                    status = new Status(status_id, statusText);
                }

            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }

        return status;
    }


}
