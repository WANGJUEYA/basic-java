package com.jue.java.learn.offeronline.T_AL_2020_03_20_B;

import java.util.Arrays;

/**
 * @author JUE
 * @date 2020/3/20
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    /**
     * 小强最近喜欢弹钢琴，一段旋律中每个音符都可以用一个小写英文字母表示。当组成一段段律的字符ASCII码是非递减的
     * 旋律被称为是高昂的，例如 aaa, bcd。
     * 现在小强已经学会了n段高昂的旋律, 他像利用他们拼接成一个尽可能高昂的旋律，问最长长度是多少
     */
    public static void main(String[] args) {
        String[] array = {"aaa", "abc"};
        String[] array1 = {"aaa", "bcd", "zzz", "bcdef"};
        System.out.println((new Main()).function(array1));
    }

    public int function(String[] param) {
//        System.out.println(Arrays.toString(param));
//        Arrays.sort(param, (a, b) -> {
//            if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
//                return a.charAt(0) - b.charAt(0);
//            } else {
//                return a.charAt(a.length() - 1) - b.charAt(b.length() - 1);
//            }
//        });
        int len = param.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return param[0].length();
        }
        // 初始化为最大单字符串长度
        int max = 0;
        for (String item : param) {
            max = Math.max(max, item.length());
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String[] array = Arrays.copyOf(param, len - 1);
                if (param[i].charAt(param[i].length() - 1) <= param[j].charAt(0)) {
                    array[i] = param[i] + param[j];
                    if (j < len - 1) {
                        array[j] = param[len - 1];
                    }
                    max = Math.max(max, function(array));
                } else if (param[i].charAt(0) >= param[j].charAt(param[j].length() - 1)) {
                    array[i] = param[j] + param[i];
                    if (j < len - 1) {
                        array[j] = param[len - 1];
                    }
                    max = Math.max(max, function(array));
                }
            }
        }
        return max;
    }
}
