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

                    int materiallist_id = rs.getInt("materiallist_id");
                    int carport_id = rs.getInt("carport_id");
                    int materials_id = rs.getInt("materials_id");
                    double amount = rs.getDouble("amount");
                    int unit_id = rs.getInt("unit_id");
                    materialsListsCarport.add(new MaterialsList(materiallist_id, carport_id, materials_id, amount, unit_id));
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

    public MaterialsList insertMaterialList(MaterialsList materialsList) throws UserException {
        boolean result = false;
        int newId = 0;
        String sql = "insert into materialList (materiallist_id, carport_id, materials_id, amount, unit_id) values (?,?,?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, materialsList.getMaterialList_id());
                ps.setInt(2, materialsList.getCarport_id());
                ps.setInt(3, materialsList.getMaterials_id());
                ps.setDouble(4,materialsList.getAmount());
                ps.setInt(5,materialsList.getUnit_id());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next()) {
                    newId = idResultset.getInt(1);
                    materialsList.setMaterialList_id(newId);
                } else {
                    materialsList = null;
                }
            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }


        return materialsList;
    }

}
