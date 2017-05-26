package com.example.digdig.projectgridview.model;

/**
 * Created by digdig on 17-05-18.
 */

public class Operation {
    private String number;
    private String operator;
    private String number2;
    private String simbolEqual;
    private String userResult;
    private String result="";

    private int color;

    public Operation(String number, String operator, String number2, String simbolEqual, String userResult, String result, int color) {
        this.number = number;
        this.operator = operator;
        this.number2 = number2;
        this.simbolEqual = simbolEqual;
        this.userResult = userResult;
        this.result = result;
        this.color = color;
    }
    public Operation(String number, String operator, String number2, String simbolEqual, String userResult, String result) {
        this.number = number;
        this.operator = operator;
        this.number2 = number2;
        this.simbolEqual = simbolEqual;
        this.userResult = userResult;
        this.result = result;

    }
    public Operation(String userResult) {

        this.userResult = userResult;

    }
    public Operation() {



    }
    public Operation(String number, String operator, String number2, String simbolEqual, String userResult) {
        this.number = number;
        this.operator = operator;
        this.number2 = number2;
        this.simbolEqual = simbolEqual;
        this.userResult = userResult;


    }

    public  boolean checkResult(String userResult)
    {
       int resultInt=0;
        switch (operator)
        {
            case "+":
                resultInt = Integer.valueOf(number)+Integer.valueOf(number2);


                break;
            case "-":
                resultInt = Integer.valueOf(number)-Integer.valueOf(number2);

                break;

        }
        return Integer.parseInt(userResult)==resultInt;
    }

   /* public String goodResul(String number, String operator, String number2 )
    {
        String resulte="";
        switch (operator)
        {
            case "+":
             resultInt = Integer.valueOf(number)+Integer.valueOf(number2);
              resulte=String.valueOf(resultInt);

             break;
            case "-":
                resultInt = Integer.valueOf(number)-Integer.valueOf(number2);
                resulte=String.valueOf(resultInt);
           break;

        }
        return resulte;
    }*/
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getSimbolEqual() {
        return simbolEqual;
    }

    public void setSimbolEqual(String simbolEqual) {
        this.simbolEqual = simbolEqual;
    }

    public String getUserResult() {
        return userResult;
    }

    public void setUserResult(String userResult) {
        this.userResult = userResult;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return getUserResult();
    }
}
