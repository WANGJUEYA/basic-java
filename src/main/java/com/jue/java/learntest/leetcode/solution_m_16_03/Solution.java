package com.jue.java.learntest.leetcode.solution_m_16_03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author JUE
 * @date 2020/4/12
 * @note 0 error(s), 0 warning(s)
 **/

class Solution {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString((new Solution()).intersection(new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 1}, new int[]{0, -1})));
//        System.out.println(Arrays.toString((new Solution()).intersection(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{2, 1})));
//        System.out.println(Arrays.toString((new Solution()).intersection(new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3})));
        System.out.println(Arrays.toString((new Solution()).intersection(new int[]{0, 0}, new int[]{1, -1}, new int[]{0, 0}, new int[]{-1, 1})));
        System.out.println(Arrays.toString((new Solution()).intersection(new int[]{-25, 67}, new int[]{-67, 24}, new int[]{-52, 48}, new int[]{-45, 43})));
    }

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        Double k1 = k(new double[]{start1[0], start1[1]}, new double[]{end1[0], end1[1]});
        Double k2 = k(new double[]{start2[0], start2[1]}, new double[]{end2[0], end2[1]});
        if ((k1 == null && k2 == null) || (k1 != null && k2 != null && Math.abs(k1 - k2) < 1E-6)) {
            double[][] sort = new double[4][2];
            sort[0] = new double[]{start1[0], start1[1]};
            sort[1] = new double[]{start2[0], start2[1]};
            sort[2] = new double[]{end1[0], end1[1]};
            sort[3] = new double[]{end2[0], end2[1]};
            Arrays.sort(sort, Comparator.comparingDouble(ints -> ints[0] * Math.pow(2, 7) + ints[1]));
            for (double[] ints : sort) {
                if (in(ints[0], ints[1], start1, end1) && in(ints[0], ints[1], start2, end2)) {
                    return ints;
                }
            }
        } else if (k1 == null || k2 == null) {
            int[] start = k1 == null ? start2 : start1;
            double x = k1 == null ? start1[0] : start2[0];
            double y = (k1 == null ? k2 : k1) * (x - start[0]) + start[1];
            if (in(x, y, start1, end1) && in(x, y, start2, end2)) {
                return new double[]{x, y};
            }
        } else {
            double b1 = k1 * (-start1[0]) + start1[1];
            double b2 = k2 * (-start2[0]) + start2[1];
            double x = -(b2 - b1) / (k2 - k1);
            double y = k1 * x + b1;
            if (in(x, y, start1, end1) && in(x, y, start2, end2)) {
                return new double[]{x, y};
            }
        }
        return new double[0];
    }

    private Double k(double[] start, double[] end) {
        return start[0] == end[0] ? null : (end[1] - start[1]) * 1D / (end[0] - start[0]);
    }

    private boolean in(double x, double y, int[] start, int[] end) {
        if ((x == start[0] && y == start[1]) || (x == end[0] && y == end[1])) {
            return true;
        }
        Double k1 = k(new double[]{start[0], start[1]}, new double[]{x, y});
        Double k2 = k(new double[]{x, y}, new double[]{end[0], end[1]});
        boolean result = false;
        if (k1 == null) {
            result = k2 == null;
        } else if (k2 != null) {
            result = Math.abs(k1 - k2) < 1E-6;
        }
        return result && x >= Math.min(start[0], end[0])
                && x <= Math.max(start[0], end[0])
                && y >= Math.min(start[1], end[1])
                && y <= Math.max(start[1], end[1]);
    }
}