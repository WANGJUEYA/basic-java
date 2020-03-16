package com.jue.java.learntest.tooffer.solution34;

public class Solution {
    //引用
    private int min(int... param) {
        int result = param[0];
        for (int p : param) {
            result = Math.min(result, p);
        }
        return result;
    }

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] agly = new int[index];
        agly[0] = 1;
        int i = 0, i2 = 0, i3 = 0, i5 = 0;
        while (i < index - 1) {
            agly[++i] = min(agly[i2] * 2, agly[i3] * 3, agly[i5] * 5);
            if (agly[i] == agly[i2] * 2) {
                i2++;
            }
            if (agly[i] == agly[i3] * 3) {
                i3++;
            }
            if (agly[i] == agly[i5] * 5) {
                i5++;
            }
        }
        return agly[index - 1];
    }
}