package com.jue.java.learntest.offeronline.T_PDD_2020_04_10_B;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author JUE
 * @date 2020/4/10
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int len = scanner.nextInt();
            int MOD = scanner.nextInt();
            int[] temp = new int[len];
            int count = 0;
            for (int index = 1; index <= len; index++) {
                int current = scanner.nextInt();
                for (int i = 0; i < index; i++) {
                    temp[i] += current;
                    if (temp[i] % MOD == 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
