package business.services;

import business.entities.Result;

public class CarportCalc {
    Result result = new Result();

    public void calcCarport(Double length, Double width){

        calcPost();
        calcRaft()
        calcBeam();



    }


    public Result calcPost(double length, double width) {

        int postAmount = 4;

        if (length > 300) {

            while (length > 300) {

                length = length - 300;
                postAmount = postAmount + 2;

            }

            result = new Result(300, postAmount);

        }

        if (length < 300 || length == 300) {

            return new Result(300, postAmount);
        }

        return result;
    }

    public Result calcRaft(double length, double width) {

        // spær er 600cm, 55cm. mellemrum mellem spær

        int rafterAmount = calcRaftLength(length).getAmount();

        if (width > 600) {

            rafterAmount = rafterAmount * 2;

            return new Result(600, rafterAmount);

        }

        if (width <= 600) {

            return new Result(600, rafterAmount);

        }


        return result;

    }

    private Result calcRaftLength(double length) {

        // spær er 600cm, 55cm. mellemrum mellem spær

        int rafterAmount = 5;

        if (length > 240) {

            while (length >= 240) {
                length = length - 55;
                rafterAmount = rafterAmount + 1;
            }

            return new Result(600, rafterAmount);

        }

        if (length == 240) {

            return new Result(600, rafterAmount);

        }


        return result;

    }

    public Result calcBeam(double length, double width) {

        int beamAmount;
        beamAmount = calcBeamLength(length).getAmount() + calcBeamWidth(width).getAmount();

        return new Result(500, beamAmount);
    }

    private Result calcBeamLength(double length) {
        // bjælke er 500cm i længde
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
        // bjælke er 500cm i længde
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
