package com.jue.java.learntest.leetcode.solution1387;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).getKth(1, 1, 1));
        System.out.println((new Solution()).getKth(7, 11, 4));
        System.out.println((new Solution()).getKth(10, 20, 5));
        System.out.println((new Solution()).getKth(1, 1000, 777));
    }

    public int getKth(int lo, int hi, int k) {
        int len = hi - lo + 1;
        Integer[] array = new Integer[len];
        int begin = lo;
        while (begin <= hi) {
            array[begin - lo] = begin;
            begin++;
        }
        Arrays.sort(array, (a, b) -> {
            int powerA = power(a);
            int powerB = power(b);
            if (powerA != powerB) {
                return (powerA - powerB) * len;
            } else {
                return a - b;
            }
        });
//        System.out.println(Arrays.toString(array));
//        for (int a : array) {
//            System.out.println(power(a));
//        }
        return array[k - 1];
    }

    private int power(int a) {
        int count = 0;
        while (a != 1) {
            a = a % 2 == 0 ? a / 2 : 3 * a + 1;
            count++;
        }
        return count;
    }
}