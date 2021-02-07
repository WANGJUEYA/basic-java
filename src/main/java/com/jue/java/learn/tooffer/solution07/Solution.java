package com.jue.java.learn.tooffer.solution07;

public class Solution {
    public void reOrderArray(int[] array) {

        int length = array.length;
        int[] result = array.clone();
        int i = 0, j = length - 1;
        for (int x = 0, y = length - 1; x < length; x++, y--) {
            //奇数在前
            if (result[x] % 2 == 1) {
                array[i++] = result[x];
            }
            if (result[y] % 2 == 0) {
                array[j--] = result[y];
            }
        }
    }
}