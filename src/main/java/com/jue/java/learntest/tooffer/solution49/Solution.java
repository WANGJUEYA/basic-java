package com.jue.java.learntest.tooffer.solution49;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        String stat = "right";
        int p = 0, q = 0, loop = 0, x = matrix.length, y = matrix[0].length;
        for (int i = 0, num = x * y; i < num; i++) {
            result.add(matrix[p][q]);
            switch (stat) {
                case "right":
                    if (q + 1 < y - loop) {
                        q++;
                    } else {
                        stat = "down";
                        p++;
                    }
                    break;
                case "down":
                    if (p + 1 < x - loop) {
                        p++;
                    } else {
                        stat = "left";
                        q--;
                    }
                    break;
                case "left":
                    if (q - 1 >= loop) {
                        q--;
                    } else {
                        stat = "up";
                        p--;
                    }
                    break;
                case "up":
                    if (p - 1 > loop) {
                        p--;
                    } else {
                        stat = "right";
                        q++;
                        loop++;
                    }
                    break;
                default:
                    throw new NullPointerException("方向错误");
            }
        }
        return result;
    }
}