package business.services;

import business.entities.Result;

public class CarportCalc {


    public Result calcPost(double length, double width) {
        Result result = new Result();

        int postAmount = 4;

        if (length > 300) {

            while (length > 300) {

                length = length - 300;
                postAmount = postAmount + 2;

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
