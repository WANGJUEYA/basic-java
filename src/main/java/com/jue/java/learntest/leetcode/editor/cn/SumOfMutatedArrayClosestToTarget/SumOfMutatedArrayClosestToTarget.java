//给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和
//最接近 target （最接近表示两者之差的绝对值最小）。 
//
// 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。 
//
// 请注意，答案不一定是 arr 中的数字。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,9,3], target = 10
//输出：3
//解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
// 
//
// 示例 2： 
//
// 输入：arr = [2,3,5], target = 10
//输出：5
// 
//
// 示例 3： 
//
// 输入：arr = [60864,25176,27249,21296,20204], target = 56803
//输出：11361
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 1 <= arr[i], target <= 10^5 
// 
// Related Topics 数组 二分查找


package com.jue.java.learntest.leetcode.editor.cn.SumOfMutatedArrayClosestToTarget;

import java.util.Arrays;

/**
 * @author JUE
 * @number 1300
 */
public class SumOfMutatedArrayClosestToTarget {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findBestValue(new int[]{1}, 10));
        System.out.println(solution.findBestValue(new int[]{4, 9, 3}, 10));
        System.out.println(solution.findBestValue(new int[]{2, 3, 5}, 10));
        System.out.println(solution.findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findBestValue(int[] arr, int target) {
        // 先从小到大排序
        Arrays.sort(arr);
        int len = arr.length;
        int first = target / len;
        if (first < arr[0]) {
            int sub1 = Math.abs(first * len - target);
            int sub2 = Math.abs((first + 1) * len - target);
            if (sub1 <= sub2) {
                return first;
            } else {
                return first + 1;
            }
        }
        // 计算出每一个的和
        int sum = 0, value = Integer.MAX_VALUE, sub = Integer.MAX_VALUE, tempValue, tempSub;
        for (int index = 0, num = len - 1; index < len; index++, num--) {
            sum += arr[index];
            tempValue = num == 0 ? arr[index] : (target - sum) / num;
            if ((index == len - 1) || (tempValue >= arr[index] && tempValue < arr[index + 1])) {
                for (int i = tempValue; i <= tempValue + 1; i++) {
                    tempSub = Math.abs((i * num + sum) - target);
                    if (tempSub < sub) {
                        sub = tempSub;
                        value = i;
                    }
                    if (tempSub == sub && i < value) {
                        value = i;
                    }
                }
            }
        }
        return value;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
