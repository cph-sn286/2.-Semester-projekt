package business.services;

import business.entities.BillOfMaterials;
import business.entities.CarportItems;
import business.entities.Materials;
import business.entities.Result;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.MaterialsMapper;
import web.FrontController;

public class CarportCalc {
    BillOfMaterials billOfMaterials = new BillOfMaterials();
    Result result = new Result();
    MaterialFacade materialFacade;
    Materials materials = null;

    public CarportCalc(Database database) {
        materialFacade = new MaterialFacade(database);
    }


    public BillOfMaterials calcCarport(double length, double width) throws UserException {
        String name;
        CarportItems carportItems = null;

       // ------
        name = "post";

        carportItems = new CarportItems (name,calcPost(length,width).getLength(), calcPost(length,width).getAmount(),calcPost(length,width).getPrice());
        billOfMaterials.addToBillOfMaterials(carportItems);

        // ------

        name = "raft";

        carportItems = new CarportItems(name,calcRaft(length,width).getLength(),calcRaft(length,width).getAmount(),calcRaft(length, width).getPrice()  );
        billOfMaterials.addToBillOfMaterials(carportItems);

        // ------

        name = "beam";

        carportItems = new CarportItems(name,calcBeam(length,width).getLength(),calcBeam(length,width).getAmount(),calcRaft(length, width).getPrice());
        billOfMaterials.addToBillOfMaterials(carportItems);


        return billOfMaterials;
    }

    protected Result calcPost(double length, double width) throws UserException {

        materials = materialFacade.getMaterialsById(26);

        double postHeight = materials.getLength();

        double price = materials.getPrice();

        int postAmount = 4;

        if (length > 300) {

            while (length > 300) {

                length = length - 300;
                postAmount = postAmount + 2;

            }

            price = postAmount * price;
            result = new Result(300, postAmount,price);

        }

        if (length < 300 || length == 300) {
            price = postAmount * price;
            return new Result(300, postAmount,price);
        }

        return result;
    }

    protected Result calcRaft(double length, double width) throws UserException {

        materials = materialFacade.getMaterialsById(25);
        double price = materials.getPrice();

        // sp??r er 600cm, 55cm. mellemrum mellem sp??r

        int rafterAmount = calcRaftLength(length).getAmount();

        if (width > 600) {

            rafterAmount = rafterAmount * 2;

            price = rafterAmount * price;
            return new Result(600, rafterAmount, price);

        }

        if (width <= 600) {

            price = rafterAmount * price;
            return new Result(600, rafterAmount, price);

        }


        return result;

    }

    private Result calcRaftLength(double length) {

        // sp??r er 600cm, 55cm. mellemrum mellem sp??r

        int rafterAmount = 5;

        if (length > 240) {

            while (length >= 240) {
                length = length - 55;
                rafterAmount = rafterAmount + 1;
            }

            return new Result(600, rafterAmount);

        }

        if (length <= 240) {

            return new Result(600, rafterAmount);

        }


        return result;

    }

    public Result calcBeam(double length, double width) throws UserException {

        materials = materialFacade.getMaterialsById(17);
        double price = materials.getPrice();

        int beamAmount;
        beamAmount = calcBeamLength(length).getAmount() + calcBeamWidth(width).getAmount();
        price = beamAmount * price;

        return new Result(500, beamAmount, price);
    }

    private Result calcBeamLength(double length) {
        // bj??lke er 500cm i l??ngde
        int beamAmount = 2;

        if (length > 500) {
            while (length > 500) {

                length = length - 500;
                beamAmount = beamAmount + 2;

            }

            result = new Result(600, beamAmount);


        }


        if (length <= 500) {
            return new Result(600, beamAmount);
        }

        return result;
    }

    private Result calcBeamWidth(double width) {
        // bj??lke er 500cm i l??ngde
        int beamAmount = 2;

        if (width > 500) {
            while (width > 500) {

                width = width - 500;
                beamAmount = beamAmount + 2;

            }

            result = new Result(600, beamAmount);


        }

        if (width <= 500) {
            return new Result(600, beamAmount);
        }


        return result;
    }




}
