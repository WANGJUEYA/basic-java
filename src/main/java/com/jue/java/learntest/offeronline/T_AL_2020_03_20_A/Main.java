package com.jue.java.learntest.offeronline.T_AL_2020_03_20_A;

import java.util.Arrays;

/**
 * @author JUE
 * @date 2020/3/20
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    /**
     * 今天小强从一副扑克牌中拿出来一叠，其中包括A,2,3,4,5,6,7,8,9,10各四张，其中A代表1.
     * 他从这一叠中抽出一巡航牌给小明，并告诉小明可以按照下列方式打出一张牌
     * 单数: 一张牌，例如3
     * 对子: 数字相同的两张牌, 例如77
     * 顺子: 数字连续的五张牌, 例如A2345
     * 现在小强像知道最少打出多少次牌可以打光手中的牌
     */

    public static void main(String[] args) {
        int[] array = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] array0 = {1, 1, 1, 2, 2, 2, 2, 2, 1, 1};
        int[] array1 = {1, 4, 1, 2, 2, 2, 2, 2, 1, 1};
        int[] array2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] array3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 3};
        int[] array4 = {1, 1, 1, 1, 1, 2, 0, 0, 0, 0};
//        System.out.println((new T_AL_2020_03_20_A()).function(array));
        System.out.println((new Main()).function(array0));
        System.out.println((new Main()).function(array1));
        System.out.println((new Main()).function(array2));
        System.out.println((new Main()).function(array3));
        System.out.println((new Main()).function(array4));
    }

    // 解题关键 找出所有的顺子
    public int function(int[] param) {
        int min = 0;
        for (int item : param) {
            if (item == 1 || item == 2) {
                min += 1;
            }
            if (item == 3 || item == 4) {
                min += 2;
            }
        }
        for (int index = 0; index < 6; index++) {
            int[] temp = Arrays.copyOf(param, param.length);
            if (temp[index] > 0 && temp[index + 1] > 0 && temp[index + 2] > 0 && temp[index + 3] > 0 && temp[index + 4] > 0) {
                temp[index]--;
                temp[index + 1]--;
                temp[index + 2]--;
                temp[index + 3]--;
                temp[index + 4]--;
                int sum = function(temp) + 1;
                min = Math.min(min, sum);
            }
        }
        return min;
    }
}
