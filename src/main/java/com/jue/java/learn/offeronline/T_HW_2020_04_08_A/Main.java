package com.jue.java.learn.offeronline.T_HW_2020_04_08_A;

import java.util.Scanner;

/**
 * @author JUE
 * @date 2020/4/8
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    public static int MOD = (int) (1E9 + 7);

    // N个字符能组成多少个长度不大于L的字符串
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            if (A == 0 && B == 0) {
                break;
            }
            long sum = 0;
            long base = A;
            while (B-- > 0) {
                sum = (sum + base) % MOD;
                base = (base * A) % MOD;
            }
            System.out.println(sum);
        }
    }
}
