package com.jue.java.learntest.offeronline.T_PDD_2020_04_10_A;

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
            int total = scanner.nextInt();
            int sub = total % 3;
            int sum = 0;
            for (int index = 0; index < total; index++) {
                int temp = scanner.nextInt();
                if (index < sub || (index - sub) % 3 != 0) {
                    sum += temp;
                }
            }
            System.out.println(sum);
        }
    }
}
