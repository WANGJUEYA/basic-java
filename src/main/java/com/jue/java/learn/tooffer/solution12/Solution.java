package com.jue.java.learn.tooffer.solution12;

public class Solution {
    public int NumberOf1(int n) {
        //引用! 循环次数为i的个数!!!!
        int result = 0;
        while (n != 0) {
            result++;
            n = n & (n - 1);
        }
        return result;
    }
}