package business.persistence;

import business.entities.Carport;
import business.exceptions.UserException;

import java.sql.*;

public class CarportMapper {

    private Database database;

    public CarportMapper(Database database) {

        this.database = database;

    }


    public Carport getCarportsById(int carport_Id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM carport WHERE carport_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, carport_Id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    int carport_id = rs.getInt("carport_id");
                    double length = rs.getDouble("length");
                    double width = rs.getDouble("width");
                    String rooftype = rs.getString("rooftype");
                    int shed_id = rs.getInt("shed_id");
                    double sum = rs.getDouble("sum");
                    return new Carport(carport_Id, length, width, rooftype, shed_id, sum);
                }
                throw new UserException("Carporten findes ikke for carport_id = " + carport_Id);

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public Carport insertCarport(Carport carport) throws UserException {
        boolean result = false;
        int newId = 0;
        String sql = "insert into carport (carport_id, length, width, rooftype, shed_id, sum) values (?,?,?,?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, carport.getCarport_id());
                ps.setDouble(2, carport.getLength());
                ps.setDouble(3, carport.getWidth());
                ps.setString(4, carport.getRooftype());
                ps.setInt(5,carport.getShed_id());
                ps.setDouble(6,carport.getSum());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next()) {
                    newId = idResultset.getInt(1);
                    carport.setCarport_id(newId);
                } else {
                    carport = null;
                }
            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }


        return carport;
    }





}
