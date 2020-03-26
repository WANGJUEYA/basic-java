package com.jue.java.learntest.offeronline.T_AL_2020_03_24_A;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JUE
 * @date 2020/3/17
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    /**
     * 小强在玩一个走迷宫的游戏，他操控的人物现在位于迷宫的起点，他的目标是尽快到达终点
     * 每一次他可以选择花费一个时间单位向上或向下或向左或向右走一格，
     * 或者使用自己的对称飞行器花费一个时间单位瞬移到关于当前自己点中心对称的格子
     * 且每一次移动的目的地不能存在障碍物
     * 具体来说，设当前迷宫右n行m列，如果当前小强操控的人物位于点A(x,y), 那么关于点A中心对称的格子B(x1,y1)
     * 满足 x + x1 = n + 1,且 y+y1= m + 1
     * 需要注意的是, 对称飞行器最多使用五次
     * <p>
     * 4 4
     * # S . .
     * E # . .
     * # . . .
     * . . . .
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            String[][] array = new String[row][col];
            int si = 0, sj = 0;
            for (int i = 0; i < row; ) {
                String line = scanner.nextLine();
                if (!"".equals(line)) {
                    array[i] = line.split(" ");
                    for (int j = 0; j < col; j++) {
                        if ("S".equals(array[i][j])) {
                            si = i;
                            sj = j;
                        }
                    }
                    i++;
                }
            }
            System.out.println((new Main()).function(array, si, sj, row, col));
        }
    }

    public int function(String[][] array, int i, int j, int row, int col) {
//        System.out.println("(i,j) => " + i + "," + j);
        if (i < 0 || i >= row || j < 0 || j >= col || "#".equals(array[i][j])) {
            return -1;
        }
//        System.out.println(array[i][j]);
        if ("E".equals(array[i][j])) {
            return 0;
        } else {
            array[i][j] = "#";
            int[] min = new int[5];
            String[][] copy = new String[row][col];
            for (int p = 0; p < row; p++) {
                copy[p] = Arrays.copyOf(array[p], col);
            }
            min[0] = function(copy, i - 1, j, row, col);
            for (int p = 0; p < row; p++) {
                copy[p] = Arrays.copyOf(array[p], col);
            }
            min[1] = function(copy, i + 1, j, row, col);
            for (int p = 0; p < row; p++) {
                copy[p] = Arrays.copyOf(array[p], col);
            }
            min[2] = function(copy, i, j - 1, row, col);
            for (int p = 0; p < row; p++) {
                copy[p] = Arrays.copyOf(array[p], col);
            }
            min[3] = function(copy, i, j + 1, row, col);
            for (int p = 0; p < row; p++) {
                copy[p] = Arrays.copyOf(array[p], col);
            }
            min[4] = function(copy, row - 1 - i, col - 1 - j, row, col);
//            System.out.println(Arrays.toString(min));
            int result = -1;
            for (int m : min) {
                if (m != -1) {
                    if (result == -1) {
                        result = m + 1;
                    } else {
                        result = Math.min(result, m + 1);
                    }
                }
            }
            return result;
        }
    }
}
