package business.services;


import business.entities.Materials;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.MaterialsMapper;

import java.util.List;


public class MaterialFacade {

    MaterialsMapper materialsMapper;

    public MaterialFacade(Database database) {
        materialsMapper = new MaterialsMapper(database);
    }

    public List<Materials> getAllMaterials()throws UserException{
        return materialsMapper.getAllMaterials();
    }

    public void updatePrice(double price, String description, int material_id) throws UserException {
        materialsMapper.updateMaterial(price,description,material_id);
    }

}
