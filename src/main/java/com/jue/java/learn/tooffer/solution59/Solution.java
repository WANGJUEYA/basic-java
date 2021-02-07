package com.jue.java.learn.tooffer.solution59;

public class Solution {
    public int Fibonacci(int n) {
        if(n<=0||n>39){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        else{
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
}