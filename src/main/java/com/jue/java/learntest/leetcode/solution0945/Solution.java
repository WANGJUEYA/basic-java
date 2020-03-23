package com.jue.java.learntest.leetcode.solution0945;

import java.util.Arrays;

class Solution {
    public int minIncrementForUnique(int[] A) {
        int len = A.length;
        if (len <= 1) {
            return 0;
        }
        // 算出所 e有数据的和
        Arrays.sort(A);
        int sumBegin = A[0];
        int sumEnd = A[0];
        int posCount = 0;
        for (int i = 1; i < len; i++) {
            sumBegin += A[i];
            if (A[i] == A[i - 1]) {
                posCount++;
            } else {
                sumEnd += A[i];
                int temp = A[i - 1];
                while (++temp < A[i] && posCount > 0) {
                    posCount--;
                    sumEnd += temp;
                }
            }
        }
        int temp = A[len - 1];
        while (posCount > 0) {
            posCount--;
            sumEnd += (++temp);
        }
        return sumEnd - sumBegin;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2};
        int[] array1 = {3, 2, 1, 2, 1, 7};
        System.out.println((new Solution()).minIncrementForUnique(array1));
    }
}