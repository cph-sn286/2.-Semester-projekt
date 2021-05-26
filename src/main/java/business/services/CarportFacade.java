package business.services;

import business.entities.Carport;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.CarportMapper;
import business.persistence.Database;
import business.persistence.OrderMapper;

public class CarportFacade
{

    CarportMapper carportMapper;

    public CarportFacade(Database database)
    {
        carportMapper = new CarportMapper(database);
    }

    public Carport insertCarport(Carport carport) throws UserException {
        carportMapper.insertCarport(carport);
        return carport;
    }

    public Carport getCarportById(int carport_id) throws UserException {
        return carportMapper.getCarportsById(carport_id);
    }

}
