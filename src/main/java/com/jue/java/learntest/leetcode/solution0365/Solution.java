package com.jue.java.learntest.leetcode.solution0365;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).canMeasureWater(3, 5, 0));
        System.out.println((new Solution()).canMeasureWater(3, 5, 1));
        System.out.println((new Solution()).canMeasureWater(3, 5, 2));
        System.out.println((new Solution()).canMeasureWater(3, 5, 3));
        System.out.println((new Solution()).canMeasureWater(3, 5, 4));
        System.out.println((new Solution()).canMeasureWater(3, 5, 5));
        System.out.println((new Solution()).canMeasureWater(3, 5, 6));
        System.out.println((new Solution()).canMeasureWater(3, 5, 7));
        System.out.println((new Solution()).canMeasureWater(3, 5, 8));
        System.out.println((new Solution()).canMeasureWater(2, 6, 5));
    }

    public boolean canMeasureWater_outTime(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || (x + y < z) || (x % 2 == 0 && y % 2 == 0 && z % 2 == 1)) {
            return false;
        }
        boolean[] flag = new boolean[x + y + 1];
        flag[0] = true;
        flag[x + y] = true;
        flag[x] = true;
        flag[y] = true;
        boolean circle = true; // 遍历进行
        int len = x + y + 1;
        while (circle) {
            circle = false;
            for (int i = 0; i < len; i++) {
                if (flag[i]) {
                    for (int j = 0; j < len; j++) {
                        if (flag[j]) {
                            int sum = i + j;
                            if (sum < len && !flag[sum]) {
                                circle = true;
                                flag[sum] = true;
                            }
                            int sub = Math.abs(i - j);
                            if (!flag[sub]) {
                                circle = true;
                                flag[sub] = true;
                            }
                        }
                    }
                }
            }
        }
        return flag[z];
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || (x + y < z) || (x % 2 == 0 && y % 2 == 0 && z % 2 == 1)) {
            return false;
        }
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        while (max % min != 0) {
            int temp = (max % min);
            max = Math.max(temp, min);
            min = Math.min(temp, min);
        }
        return y % min == 0;
    }
}