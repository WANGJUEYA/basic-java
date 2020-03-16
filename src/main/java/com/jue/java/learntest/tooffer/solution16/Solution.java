package com.jue.java.learntest.tooffer.solution16;

import java.util.ArrayList;

public class Solution {
    public int Sum_Solution(int n) {
        //不能用if!
        if(n < 1){
            return 0;
        }
        return n + Sum_Solution(n-1);
    }
}

class SolutionPerfect {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}