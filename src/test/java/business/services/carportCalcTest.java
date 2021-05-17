package business.services;

import business.entities.Carport;
import business.entities.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarportCalcTest {
    CarportCalc carportCalc = new CarportCalc();


    @Test
    void calcPostLessThan300() {
        Result result = carportCalc.calcPost(240, 500);

        assertEquals(4, result.getAmount());


    }

    @Test
    void calcPostMoreThan300() {
        Result result = carportCalc.calcPost(680, 500);

        assertEquals(8, result.getAmount());


    }

    @Test
    void calcPostExactly300() {
        Result result = carportCalc.calcPost(300, 500);

        assertEquals(4, result.getAmount());


    }

}