//给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。 
//
// 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。 
//
// 
//
// 示例 1： 
//
// 输入：
//line1 = {0, 0}, {1, 0}
//line2 = {1, 1}, {0, -1}
//输出： {0.5, 0}
// 
//
// 示例 2： 
//
// 输入：
//line1 = {0, 0}, {3, 3}
//line2 = {1, 1}, {2, 2}
//输出： {1, 1}
// 
//
// 示例 3： 
//
// 输入：
//line1 = {0, 0}, {1, 1}
//line2 = {1, 0}, {2, 1}
//输出： {}，两条线段没有交点
// 
//
// 
//
// 提示： 
//
// 
// 坐标绝对值不会超过 2^7 
// 输入的坐标均是有效的二维坐标 
// 
// Related Topics 几何 数学


package com.jue.java.learntest.leetcode.editor.cn.IntersectionLcci;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author JUE
 * @number 面试题 16.03
 */
public class IntersectionLcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersection(new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 1}, new int[]{0, -1})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{2, 1})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 2}, new int[]{0, 3})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{0, 0}, new int[]{1, -1}, new int[]{0, 0}, new int[]{-1, 1})));
        System.out.println(Arrays.toString(solution.intersection(new int[]{-25, 67}, new int[]{-67, 24}, new int[]{-52, 48}, new int[]{-45, 43})));

    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

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
//leetcode submit region end(Prohibit modification and deletion)
