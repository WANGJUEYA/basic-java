package com.jue.java.learntest.leetcode.solution1388;

import java.util.Arrays;

class Solution {
    // 打家劫舍环形版
    public int maxSizeSlices(int[] slices) {
        int len = slices.length;
        if (len <= 0) {
            return 0;
        }
        if (len == 1) {
            return slices[0];
        }
        if (len <= 3) {
            int max = 0;
            for (int s : slices) {
                max = Math.max(max, s);
            }
            return max;
        }
        return Math.max(maxSizeSlices(slices, 0, len - 2, len), maxSizeSlices(slices, 1, len - 1, len));
    }

    public int maxSizeSlices(int[] slices, int indexBegin, int indexEnd, int len) {
        int[] preMax = slices;
        int[] currentMax;
        int pmax, cmax = 0;
        for (int i = 1, n = len / 3; i < n; i++) {
            currentMax = new int[len];
            pmax = 0;
            cmax = 0;
            for (int j = indexBegin; j <= indexEnd; j++) {
                cmax = Math.max(cmax, (currentMax[j] = pmax + slices[j]));
                if (j > indexBegin) {
                    pmax = Math.max(pmax, preMax[j - 1]);
                }
            }
//            System.out.println(Arrays.toString(currentMax));
            preMax = currentMax;
        }
        return cmax;
    }
}

class Solution_TimeOut {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] array1 = {8, 9, 8, 6, 1, 1};
        int[] array2 = {4, 1, 2, 5, 8, 3, 1, 9, 7};
        int[] array3 = {3, 1, 2};
        int[] array4 = {3, 5, 4, 4, 6, 6, 3, 4, 4, 7, 10, 5, 7, 2, 2};
        int[] array5 = {9, 5, 1, 7, 8, 4, 4, 5, 5, 8, 7, 7};
//        System.out.println((new Solution()).maxSizeSlices(array));
//        System.out.println((new Solution()).maxSizeSlices(array1));
//        System.out.println((new Solution()).maxSizeSlices(array2));
//        System.out.println((new Solution()).maxSizeSlices(array3));
//        System.out.println((new Solution()).maxSizeSlices(array4));
        System.out.println((new Solution()).maxSizeSlices(array5));
    }

    public int maxSizeSlices(int[] slices) {
        int len = slices.length;
        if (len <= 0) {
            return 0;
        }
        if (len == 1) {
            return slices[0];
        }
        return maxSizeSlices(slices, new boolean[len], len);
    }

    public int maxSizeSlices(int[] slices, boolean[] flag, int len) {
        int max = 0;
        for (int i = 0; i < slices.length; i++) {
            boolean[] temp = Arrays.copyOf(flag, len);
            int j = i;
            int sum = 0;
            do {
                if (temp[j]) {
                    j = (j + 1) % len;
                } else {
                    break;
                }
            } while (j != i);
            boolean tempJ = temp[j];
            if (!temp[j]) {
                sum += slices[j];
                temp[j] = true;
                int p = (j + 1) % len;
                while (p != j) {
                    if (temp[p]) {
                        p = (p + 1) % len;
                    } else {
                        break;
                    }
                }
                temp[p] = true;
                int q = (j - 1 + len) % len;
                while (q != j) {
                    if (temp[q]) {
                        q = (q - 1 + len) % len;
                    } else {
                        break;
                    }
                }
                temp[q] = true;
            }
            int subMax = tempJ ? 0 : maxSizeSlices(slices, temp, len);
            max = Math.max(max, sum + subMax);
        }
        return max;
    }
}