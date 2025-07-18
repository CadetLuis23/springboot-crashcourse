package org.example;

public class Calculator {
    private boolean isOn;

    public Calculator() {
        this.isOn = false;
    }

    float add(float num1, float num2){
        return num1 + num2;
    }
    
    float subtract(float num1, float num2){
        return num1 - num2;
    }
    
    float multiply(float num1, float num2){
        return num1 * num2;
    }
    
    float divide(float dividend, float divisor) throws ArithmeticException{
        return dividend / divisor;
    }

    int add(int num1, int num2){
        return num1 + num2;
    }

    int subtract(int num1, int num2){
        return num1 - num2;
    }

    int multiply(int num1, int num2){
        return num1 * num2;
    }

    int divide(int dividend, int divisor) throws ArithmeticException{
        return dividend / divisor;
    }

    public boolean isOn(){
        return this.isOn;
    }

    public boolean isOff(){
        return !isOn;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }
}
