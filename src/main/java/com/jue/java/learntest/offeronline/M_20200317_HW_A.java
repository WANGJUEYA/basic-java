package com.jue.java.learntest.offeronline;

import java.util.Arrays;

/**
 * @author JUE
 * @date 2020/3/16
 * @note 0 error(s), 0 warning(s)
 **/
public class M_20200317_HW_A {
    /**
     * 小明手头有10000台设备，他想以他的幸运数D(D是浮点数)每台的价格批量卖一些出去，他不在乎能卖出去多少台，只在乎卖出去的每台均价最接近D元，而且他只收整数数额的钱。请计算他应该每次卖出去的台数N，一共售价M。
     * 输入描述：
     * 输入浮点数D（0< D < 10），精确到小数点后14位，表示小明钟情的价格。
     * 输出描述：
     * 输出两个正整数M，N，以空格分割，如果有多种方案均价一样，输出台数最小的那个。
     * 示例：
     * 输入： 3.14159265358979
     * 输出： 355 113
     */

    // 暴力穷举法
    public int[] function(double D) {
        int TOTAL = 10000;
        int M = 0, N = 0;
        double min = Double.MAX_VALUE;
        for (int index = 0; index < TOTAL; index++) { // 一共卖出 index 台
            double money = D * index;
            // ps 钱需要取整数
            int moneyTotal = (int) money;
            double minTemp = Math.abs(moneyTotal * 1e14 / (double) index - D * 1e14);
            if (minTemp < min || (minTemp == min && index <= N)) {
                min = minTemp;
                M = moneyTotal;
                N = index;
            }
            minTemp = Math.abs((moneyTotal + 1) * 1e14 / (double) index - D * 1e14);
            if (minTemp < min || (minTemp == min && index <= N)) {
                min = minTemp;
                M = moneyTotal + 1;
                N = index;
            }
        }
        return new int[]{M, N};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString((new M_20200317_HW_A()).function(3.14159265358979f)));
        System.out.println(Math.abs(31218 / 9937f - 3.14159265358979) < Math.abs(355 / 113f - 3.14159265358979));
        System.out.println(31218 / 9937f);
        System.out.println(31218 / 9937f);
    }
}
