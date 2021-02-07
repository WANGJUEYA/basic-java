package com.jue.java.learn.offeronline.T_HW_2020_04_08_B;

import java.util.Scanner;

/**
 * @author JUE
 * @date 2020/4/8
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {

    // 最大字符串
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            String str = scanner.nextLine();
            while (str == null || str.equals("")) {
                str = scanner.nextLine();
            }
            char[] chars = str.toCharArray();
            int i = 0;
            while (i < n) {
                if (chars[i] == '0' && i < n - 1) {
                    char temp = chars[i + 1];
                    int count = i + 2;
                    int index = 0;
                    while (count < n && chars[count] == '0') {
                        chars[i + index++] = '1';
                        count++;
                    }
                    chars[i + index] = temp == '0' ? '1' : '0';
                    chars[i + index + 1] = temp;
                    i += index + 1;
                } else {
                    i++;
                }
            }
            System.out.println(String.valueOf(chars));
        }
    }
}
