package business.persistence;

import business.entities.Carport;
import business.entities.Materials;
import business.entities.Sizes;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialsMapper {

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

    public int deleteMaterial(int material_id) throws UserException {
        int rowaAffected = 0;
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM materials " +
                    "WHERE materials_id = ?";

            while (rowaAffected == 0) {
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, material_id);
                    rowaAffected = ps.executeUpdate();

                    if (rowaAffected == 0) {
                        rowaAffected = 1;
                    }
                } catch (SQLException ex) {
                    throw new UserException(ex.getMessage());
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowaAffected;
    }

    public int updateMaterial(Double price, String description, int materials_id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "UPDATE materials SET price = ?, description = ? WHERE materials_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setDouble(1, price);
                ps.setString(2, description);
                ps.setInt(3,materials_id);
                int rowsInserted = ps.executeUpdate();
                return rowsInserted;

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }

    public Materials insertMaterial(Materials materials) throws UserException {
        boolean result = false;
        int newId = 0;
        String sql = "insert into materials (materials_id, name, sizes_id, description, price) values (?,?,?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, materials.getMaterials_id());
                ps.setString(2, materials.getName());
                ps.setInt(3, materials.getSizes_id());
                ps.setString(4, materials.getDescription());
                ps.setDouble(5,materials.getPrice());


                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next()) {
                    newId = idResultset.getInt(1);
                    materials.setMaterials_id(newId);
                } else {
                    materials = null;
                }
            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }


        return materials;
    }

    public int deleteSizes(int sizes_id) throws UserException {
        int rowaAffected = 0;
        try (Connection connection = database.connect()) {
            String sql = "DELETE FROM sizes " +
                    "WHERE sizes_id = ?";

            while (rowaAffected == 0) {
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, sizes_id);
                    rowaAffected = ps.executeUpdate();

                    if (rowaAffected == 0) {
                        rowaAffected = 1;
                    }
                } catch (SQLException ex) {
                    throw new UserException(ex.getMessage());
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowaAffected;
    }

    public Sizes insertSizes(Sizes sizes) throws UserException {
        boolean result = false;
        int newId = 0;
        String sql = "insert into sizes (sizes_id, height, length, width) values (?,?,?,?)";
        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, sizes.getSizes_id());
                ps.setDouble(2, sizes.getHeigth());
                ps.setDouble(3, sizes.getLength());
                ps.setDouble(4, sizes.getWidth());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                }
                ResultSet idResultset = ps.getGeneratedKeys();
                if (idResultset.next()) {
                    newId = idResultset.getInt(1);
                    sizes.setSizes_id(newId);
                } else {
                    sizes = null;
                }
            } catch (SQLException ex) {

                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("connection to database could not be established");
        }


        return sizes;
    }

    public Sizes getSizesById(int sizes_id) throws UserException {
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM sizes WHERE sizes_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, sizes_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    double height = rs.getDouble("heigth");
                    double length = rs.getDouble("length");
                    double width = rs.getDouble("width");
                    return new Sizes(sizes_id, height, length, width);
                }
                throw new UserException("Størrelsen findes ikke for sizes_id = " + sizes_id);

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }




}