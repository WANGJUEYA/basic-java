package com.jue.java.learn.offeronline.T_AL_2020_03_25_B;

import java.util.Scanner;

/**
 * @author JUE
 * @date 2020/3/17
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    /**
     * 给出一个二维矩阵，这个矩阵的每一行和每一列都是一个独立的等差数列，但是其中的一些数字被隐藏住了
     * 现在需要你进行推理将哪些被隐藏但是可以被唯一确定的数字填上，然后来回答对某个位置上数字的询问
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int op = scanner.nextInt();
            main.array = new int[row][col];
            main.flagRow = new boolean[row];
            main.flagCol = new boolean[col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    main.array[i][j] = scanner.nextInt();
                }
            }
            main.init(row, col);
            while ((op--) > 0) {
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                main.get(i - 1, j - 1);
            }
        }
    }

    private int[][] array;
    private boolean[] flagRow;
    private boolean[] flagCol;

    private void init(int row, int col) {
        boolean end = true;
        int[][] step = {{1, 0}, {0, 1}};

        for (int index = 0; index < 2; index++) {
            boolean[] flagTemp = index == 0 ? flagRow : flagCol;
            int add = 1 - index;
            if (index > 0 && end) {
                break;
            }
            for (int i = 0, j = 0; i < row && j < col; i += step[index][0], j += step[index][1]) {
                if (!flagTemp[i + j]) {
                    int i1 = i, j1 = j;
                    while (i1 < row && j1 < col && array[i1][j1] == 0) {
                        i1 += step[add][0];
                        j1 += step[add][1];
                    }
                    int i2 = i1 + step[add][0];
                    int j2 = j1 + step[add][1];
                    while (i2 < row && j2 < col && array[i2][j2] == 0) {
                        i2 += step[add][0];
                        j2 += step[add][1];
                    }
                    if (i1 < row && i2 < row && j1 < col && j2 < col) {
                        flagTemp[i + j] = true;
                        end = false;
                        int sub = (array[i2][j2] - array[i1][j1]) / Math.abs(i2 + j2 - i1 - j1);
                        for (int p = i, q = j; p < row && q < col; p += step[add][0], q += step[add][1]) {
                            array[p][q] = sub * Math.abs(p + q - i1 - j1) + array[i1][j1];
                        }
                    }
                }
            }
        }
    }

    private void get(int i, int j) {
        if (flagRow[i] || flagCol[j]) {
            System.out.println(array[i][j]);
        } else {
            System.out.println("Unknown");
        }
    }
}
