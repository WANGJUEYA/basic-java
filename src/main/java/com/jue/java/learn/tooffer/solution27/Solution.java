package com.jue.java.learn.tooffer.solution27;

public class Solution {
    public int[] multiply(int[] A) {
        int len;
        //边界条件
        if ((len = A.length) <= 1) {
            return A;
        }
        int[] B = new int[len];
        //不能用除法用最笨的循环
        int index = 0;
        while (index < len) {
            int num = 1;
            for (int i = 0; i < len; i++) {
                if (index != i) {
                    num *= A[i];
                }
            }
            B[index++] = num;
        }
        return B;
    }
}