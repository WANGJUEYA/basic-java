package com.jue.java.learntest.offeronline.T_AL_2020_03_25_A;

import java.util.Scanner;

/**
 * @author JUE
 * @date 2020/3/17
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    /**
     * 小强有一个3 X n 的矩阵a, 他得a中每列得三个数字中取出一个按顺序组成一个长度为n的数组b,
     * 即bi 可以是 a1i,a2i,a3i其中任意一个。
     * 问: sum(i=1->n-1) |bi - bi+1| 的最小值是多少
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int len = scanner.nextInt();
            int[][] array = new int[3][len];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < len; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
            System.out.println((new Main()).function(array, len));
        }
    }

    /**
     * DP完成
     */
    public int function(int[][] array, int len) {
        int[] pre = new int[3];
        int[] current;
        int result = 0;
        for (int index = 1; index < len; index++) { // 列
            current = new int[3];
            result = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) { // 行
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < 3; j++) { // 前一列第几行
//                    System.out.println("----------------------");
//                    System.out.println(array[i][index]);
//                    System.out.println(array[j][index - 1]);
//                    System.out.println(pre[j]);
                    int temp = Math.abs(array[i][index] - array[j][index - 1]);
                    min = Math.min(min, pre[j] + temp);
//                    System.out.println(min);
                }
                result = Math.min(result, (current[i] = min));

//                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
//                System.out.println(result);
            }
            pre = current;
        }
        return result;
    }
}
