package business.services;

import business.entities.Result;

public class carportCalc {


    protected Result calcPost(double length, double width) {
        Result result = new Result();

        length = 600;
        width = 780;

        int postAmount = 4;

        if (length > 300) {

            while (length > 300) {

                length = -300;
                postAmount = +2;


            }

            result = new Result(300, postAmount);


        }

        if (length < 300 || length == 300) {

            result = new Result(300, postAmount);
            return result;
        }


        return result;
    }


}
