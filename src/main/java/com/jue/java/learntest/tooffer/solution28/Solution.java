package com.jue.java.learntest.tooffer.solution28;

public class Solution {

    public boolean Find(int target, int[][] array) {
        int i = 0;
        int j = 0;
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        for (i = 0; (i < array.length) && (target >= array[i][j]); i++) {
            for (j = 0; (j < array[0].length) && (target >= array[i][j]); j++) {
                if (target == array[i][j]) {
                    return true;
                }
            }
            j = 0;
        }
        return false;
    }
}