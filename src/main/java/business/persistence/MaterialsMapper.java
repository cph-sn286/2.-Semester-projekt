package business.persistence;

import business.entities.Materials;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialsMapper {
    // todo material mapper + sizes mapper i denne klasse.

    Database database;

    public Materials getMaterialById(int materials_id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM materials WHERE materials_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, materials_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    String name = rs.getString("name");
                    int sizes_id = rs.getInt("sizes_id");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    return new Materials(materials_id, name, sizes_id, description, price);
                }
                throw new UserException("Materialet findes ikke for materiale_id = " + materials_id);

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public List<Materials> getAllMaterials() throws UserException {

        List<Materials> materialsList = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM materials";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int materials_id = rs.getInt("materials_id");
                    String name = rs.getString("name");
                    int sizes_id = rs.getInt("sizes_id");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    materialsList.add(new Materials(materials_id, name, sizes_id, description, price));

                }
                return materialsList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }



}
