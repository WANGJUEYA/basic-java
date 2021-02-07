package com.jue.java.learn.tooffer.solution61;

public class Solution {
    public int JumpFloorII(int target) {
        int sum = 0;
        if (target < 0) {
            return 0;
        }
        if (target == 0 || target == 1) {
            return 1;
        }

        for (int c = 1; c <= target; c++) {
            sum = sum + JumpFloorII(target - c);
        }

        return sum;
    }
}