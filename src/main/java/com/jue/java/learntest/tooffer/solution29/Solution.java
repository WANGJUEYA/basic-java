package com.jue.java.learntest.tooffer.solution29;

public class Solution {
    public static void main(String[] args) {
        int[] test = {2, 8, 1, 5, 9};
        int[] test1 = {-1,-6,-3};
        int[] test2 = {6,-3,-2,7,-15,1,2,2};
        System.out.println((new Solution()).FindGreatestSumOfSubArray(test));
        System.out.println((new SolutionPerfect()).FindGreatestSumOfSubArray(test));
        System.out.println((new SolutionPerfect()).FindGreatestSumOfSubArray(test1));
        System.out.println((new SolutionPerfect()).FindGreatestSumOfSubArray(test2));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        //存储目前为止的最大值
        int result = Integer.MIN_VALUE;
        //存储当前计算的值
        int temp = 0;
        for (int i = 0, len = array.length; i < len; i++) {
            //当为正数时目前计算值增加
            if (array[i] > 0) {
                temp += array[i];
            } else {
                //当不为正数，计算能够承担损失
                result = Math.max(result, temp);
                for (; i < len && array[i] < 0; i++) {
                    temp += array[i];
                }
                //内层多用的数字
                i--;
                //没有承受住->重来
                temp = Math.max(temp, 0);
            }
        }
        result = Math.max(result, temp);
        //如果结果为负数
        if (result == 0) {
            boolean begin = true;
            for (int a : array) {
                if (begin) {
                    begin = false;
                    temp = a;
                } else {
                    temp = Math.max(temp, a);
                }
            }
            if (temp < 0) {
                result = temp;
            }
        }
        return result;
    }
}

class SolutionPerfect {
    public int FindGreatestSumOfSubArray(int[] array) {
        //记录当前所有子数组的和的最大值
        int res = array[0];
        //包含array[i]的连续数组最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}