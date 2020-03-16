package com.jue.java.learntest.tooffer.solution17;

public class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).Add(54, 67));
    }

    /**
     * 两个数异或：相当于每一位相加，而不考虑进位；
     * 两个数相与，并左移一位：相当于求得进位；
     * 将上述两步的结果相加
     */
    public int Add(int num1, int num2) {
        int result = num1 ^ num2;
        int plus = (num1 & num2) << 1;
        while (plus != 0) {
            num1 = result;
            num2 = plus;
            result = num1 ^ num2;
            plus = (num1 & num2) << 1;
        }
        return result;
    }
}