package com.jue.java.learntest.leetcode.solution1386;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int[][] array = {{2, 1}, {1, 8}, {2, 6}};
        int[][] array1 = {{4, 3}, {1, 4}, {4, 6}, {1, 7}};
        int[][] array2 = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        System.out.println((new Solution()).maxNumberOfFamilies(2, array));
        System.out.println((new Solution()).maxNumberOfFamilies(4, array1));
        System.out.println((new Solution()).maxNumberOfFamilies(3, array2));
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int count = 2 * n;
        Arrays.sort(reservedSeats, Comparator.comparingInt(a -> a[0]));
        Set<Integer> col;

        int i = 0, len = reservedSeats.length;
        while (i < len) {
            int row = reservedSeats[i][0];
            col = new HashSet<>();
            do {
                col.add(reservedSeats[i][1]);
            } while ((++i) < len && reservedSeats[i][0] == row);
            boolean flagA = false, flagB = false;
            if (col.contains(2) || col.contains(3) || col.contains(4) || col.contains(5)) {
                count--;
                flagA = true;
            }
            if (col.contains(8) || col.contains(9) || col.contains(6) || col.contains(7)) {
                count--;
                flagB = true;
            }
            if (flagA && flagB && !col.contains(4) && !col.contains(5) && !col.contains(6) && !col.contains(7)) {
                count++;
            }
        }
        return count;
    }

    public int maxNumberOfFamilies_outInner(int n, int[][] reservedSeats) {
        int count = 0;
        boolean[][] flag = new boolean[n][10];
        for (int[] item : reservedSeats) {
            flag[item[0] - 1][item[1] - 1] = true;
        }
        for (int index = 0; index < n; index++) {
            boolean[] temp = flag[index];
            if (!temp[1] && !temp[2] && !temp[3] && !temp[4]) {
                count++;
                temp[1] = temp[2] = temp[3] = temp[4] = true;
            }
            if (!temp[5] && !temp[6] && !temp[7] && !temp[8]) {
                count++;
                temp[5] = temp[6] = temp[7] = temp[8] = true;
            }
            if (!temp[3] && !temp[4] && !temp[5] && !temp[6]) {
                count++;
                temp[3] = temp[4] = temp[5] = temp[6] = true;
            }
        }
        return count;
    }
}