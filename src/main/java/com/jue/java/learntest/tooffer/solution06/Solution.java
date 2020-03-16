package com.jue.java.learntest.tooffer.solution06;

public class Solution {
    public double Power(double base, int exponent) {
        int length = exponent;
        double temp = base;
        double result = 1D;
        //精确度丢失???
        if (exponent < 0) {
            length = -length;
            temp = 1 / temp;
        }
        for (int i = 0; i < length; i++) {
            result *= temp;
        }
        return result;
    }
}