package org.example;

public class Calculator {
    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public double division(int a, int b){
        if (b == 0){
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return (double) a / b;
    }

    public boolean isPrime(int num){
        for (int i=2; i<num; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
