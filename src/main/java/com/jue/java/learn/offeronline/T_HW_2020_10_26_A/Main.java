package com.jue.java.learn.offeronline.T_HW_2020_10_26_A;

import java.util.Scanner;

/**
 * @author JUE
 * @date 2020/10/26
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    public static void main(String[] args) {
        // 考虑使用滑动窗口
        Scanner in = new Scanner(System.in);
        // FIXME 不是!怀疑是大数据量下的换行问题
//        StringBuilder lines = new StringBuilder();
//        int sum = 0;
//        while (in.hasNextLine()) {
//            String temp = in.nextLine();
//            if (in.hasNextLine()) {
//                lines.append(temp);
//            } else {
//                sum = Integer.parseInt(in.nextLine());
//            }
//        }
//
//        String[] array = lines.toString().split(",");
//        System.out.println(lenOfSubArrayEqualSum(array, sum));

        // 空指针异常?
        String[] array = in.nextLine().split(",");
        int sum = Integer.parseInt(in.nextLine());
        System.out.println(lenOfSubArrayEqualSum(array, sum));
    }

    public static int lenOfSubArrayEqualSum(String[] array, int sum) {
        if (sum <= 0) {
            return -1;
        }
        int result = -1;
        // 空间换时间, 是否存储转换结果?
        int count = Integer.parseInt(array[0]);
        int begin = 0, end = 0;
        int len = array.length;
        while (true) {
            if (count <= sum) {
                if (count == sum) {
                    result = Math.max(result, end - begin + 1);
                }
                end++;
                if (end >= len) {
                    break;
                }
                count += Integer.parseInt(array[end]);
            } else {
                begin--;
                if (begin < 0) {
                    break;
                }
                count -= Integer.parseInt(array[begin]);
            }
        }
        return result;
    }
}
