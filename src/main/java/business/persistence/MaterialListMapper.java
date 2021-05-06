package business.persistence;

import business.entities.MaterialsList;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialListMapper {

    //todo insertmateriallist
    Database database;
    public List<MaterialsList> getMaterialListByCarportId(int carportId) throws UserException {
        List<MaterialsList> materialsListsCarport = new ArrayList<>();
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders WHERE user_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, carportId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    int materialList_id = rs.getInt("materialList_id");
                    int carport_id = rs.getInt("carport_id");
                    int materials_id = rs.getInt("materials_id");
                    double amount = rs.getDouble("amount");
                    int unit_id = rs.getInt("unit_id");
                    materialsListsCarport.add(new MaterialsList(materialList_id, carport_id, materials_id, amount, unit_id));
                }
                return materialsListsCarport;

            } catch (SQLException ex) {
                throw new UserException("der findes ingen material liste for carport = " + carportId);
//                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }


}
