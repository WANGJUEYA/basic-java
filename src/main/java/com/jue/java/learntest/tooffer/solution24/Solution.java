package com.jue.java.learntest.tooffer.solution24;

public class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length <= 0) {
            return false;
        }
        int magicNum = 0, len = numbers.length;
        int[] temp = new int[len * 2 + 1];
        boolean begin = false;
        for (int i : numbers) {
            if (begin) {
                if (i <= 0) {
                    magicNum++;
                    continue;
                }
                int station = i - temp[len];
                if (station < -len || station > len) {
                    return false;
                }
                temp[len + station] = i;
            } else if (i <= 0) {
                magicNum++;
            } else {
                temp[len] = i;
                begin = true;
            }
        }
        begin = false;
        int record = 1;
        for (int i : temp) {
            if (begin) {
                if (++record > len) {
                    return true;
                }
                if (i <= 0 && --magicNum < 0) {
                    return false;
                }
            } else if (i > 0) {
                begin = true;
            }
        }
        return true;
    }
}