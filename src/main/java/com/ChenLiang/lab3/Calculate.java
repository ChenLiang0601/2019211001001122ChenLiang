package com.ChenLiang.lab3;

public class Calculate {
    private double firstNum;
    private double secondNum;
    Calculate(double a,double b) {
        this.firstNum=a;
        this.secondNum=b;
    }
    public String add() {
        return ""+(firstNum+secondNum);
    }
    public String subtract() {
        return ""+(firstNum-secondNum);
    }
    public String multiply() {
        return ""+(firstNum*secondNum);
    }
    public String divide() {
        if(secondNum==0) {
            return "Can't divde by 0";
        }
        return ""+firstNum/secondNum;
    }
}
