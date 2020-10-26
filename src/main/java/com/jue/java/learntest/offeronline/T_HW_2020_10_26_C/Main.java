package com.jue.java.learntest.offeronline.T_HW_2020_10_26_C;

import java.util.Scanner;

/**
 * @author JUE
 * @date 2020/10/26
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] company = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                company[i][j] = in.nextInt();
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (company[i][j] == 1) {
                    max = Math.max(max, count(company, i, j, n, m));
                }
            }
        }
        System.out.println(max);
    }

    public static final int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int count(int[][] company, int i, int j, int n, int m) {
        // 包含扩展规则
        if (i >= 0 && i < n && j >= 0 && j < m && company[i][j] == 1) {
            company[i][j] = 0;
            int result = 1;
            for (int[] item : next) {
                result += count(company, i + item[0], j + item[1], n, m);
            }
            return result;
        }
        return 0;
    }
}
