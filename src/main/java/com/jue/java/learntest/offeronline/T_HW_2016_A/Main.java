package com.jue.java.learntest.offeronline.T_HW_2016_A;

import java.util.Scanner;

/**
 * @author JUE
 * @date 2020/3/17
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {

    /**
     * 输入包括多组测试数据。
     * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
     * 学生ID编号从1编到N。
     * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
     * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
     * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
     */
    private int[] students;

    public void init(int len, int... score) {
        students = new int[len];
        int index = 0;
        for (int s : score) {
            students[index++] = s;
        }
    }

    public void init(int len, String[] score) {
        students = new int[len];
        int index = 0;
        for (String s : score) {
            students[index++] = Integer.parseInt(s);
        }
    }

    public int query(int A, int B) {
        int a = Math.min(A, B);
        int b = Math.max(A, B);
        int max = Integer.MIN_VALUE;
        for (int index = a - 1; index < b; index++) {
            max = Math.max(max, students[index]);
        }
        return max;
    }

    public void update(int A, int B) {
        students[A - 1] = B;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int len = scanner.nextInt();
            int ops = scanner.nextInt();
            Main main = new Main();
            main.init(len);
            for (int index = 1; index <= len; index++) {
                main.update(index, scanner.nextInt());
            }
            for (int index = 0; index < ops; index++) {
                String op = scanner.next();
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                if ("Q".equals(op)) {
                    int max = main.query(A, B);
                    System.out.println(max);
                } else if ("U".equals(op)) {
                    main.update(A, B);
                } else {
                    throw new IllegalArgumentException("wrong op!");
                }
            }
        }
    }
}
