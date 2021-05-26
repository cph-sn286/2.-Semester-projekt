package business.services;

import business.entities.BillOfMaterials;
import business.entities.Carport;
import business.entities.Result;
import business.exceptions.UserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarportCalcTest {
    CarportCalc carportCalc = new CarportCalc(null);


    @Test
    void calcPostLessThan300() throws UserException {
        Result result = carportCalc.calcPost(240, 500);

        assertEquals(4, result.getAmount());


    }

    @Test
    void calcPostMoreThan300() throws UserException {
        Result result = carportCalc.calcPost(680, 500);

        assertEquals(8, result.getAmount());


    }

    @Test
    void calcPostExactly300() throws UserException {
        Result result = carportCalc.calcPost(300, 500);

        assertEquals(4, result.getAmount());


    }

    @Test

    void calcRaftExactly240()throws UserException{
        Result result = carportCalc.calcRaft(240, 500);

        assertEquals(5,result.getAmount());


    }

    @Test

    void calcRaftLength390()throws UserException{
        Result result = carportCalc.calcRaft(390, 500);

        assertEquals(8,result.getAmount());


    }

    @Test

    void calcRaftWidthOver600()throws UserException{
        Result result = carportCalc.calcRaft(240,780);

        assertEquals(10,result.getAmount());


    }

    @Test

    void calcRaftWidthExactly600()throws UserException{
        Result result = carportCalc.calcRaft(240,600);

        assertEquals(5,result.getAmount());


    }

    @Test

    void calcBeam()throws UserException{
        Result result = carportCalc.calcBeam(240,240);

        assertEquals(4,result.getAmount());


    }

    @Test
    void calcBeamWidth780()throws UserException{
        Result result = carportCalc.calcBeam(240,780);

        assertEquals(6,result.getAmount());


    }

    @Test

    void calcCarport()throws UserException{
        BillOfMaterials billOfMaterials = carportCalc.calcCarport(240,780);

        System.out.println(billOfMaterials.getBillOfMaterialsItemList().toString());
        assertEquals(3,billOfMaterials.getBillOfMaterialsItemList().size());



    }


}