//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//


package com.jue.java.learntest.leetcode.editor.cn.ShuZuZhongDeNiXuDuiLcof;

import java.util.Arrays;

/**
 * @author JUE
 * @number 面试题51
 */
public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 归并排序 时间复杂度为 O(nlogn) 空间复杂度的O(n)->临时数组长度
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        return reversePairs(nums, 0, len - 1);
    }

    public int reversePairs(int[] nums, int indexBegin, int indexEnd) {
        if (indexBegin == indexEnd) {
            return 0;
        } else if (indexBegin + 1 == indexEnd) {
            if (nums[indexBegin] > nums[indexEnd]) {
                int temp = nums[indexBegin];
                nums[indexBegin] = nums[indexEnd];
                nums[indexEnd] = temp;
                return 1;
            } else {
                return 0;
            }
        } else {
            // 归并排序
            int mid = (indexEnd - indexBegin) / 2;
            int split = indexBegin + mid;
            int left = reversePairs(nums, indexBegin, split);
            int right = reversePairs(nums, split + 1, indexEnd);
            // 注意: 产生较大的空间开销!
            int[] arrayLeft = Arrays.copyOfRange(nums, indexBegin, split + 1);
            int[] arrayRight = Arrays.copyOfRange(nums, split + 1, indexEnd + 1);

            // 注意: 如果已经有序了
            int count = 0;
            int indexLeft = 0, indexRight = 0;
            int index = indexBegin;
            while (indexLeft < arrayLeft.length && indexRight < arrayRight.length) {
                if (arrayLeft[indexLeft] <= arrayRight[indexRight]) {
                    nums[index++] = arrayLeft[indexLeft];
                    indexLeft++;
                } else {
                    count += (arrayLeft.length - indexLeft);
                    nums[index++] = arrayRight[indexRight];
                    indexRight++;
                }
            }
            while (indexLeft < arrayLeft.length) {
                nums[index++] = arrayLeft[indexLeft++];
            }
            while (indexRight < arrayRight.length) {
                nums[index++] = arrayRight[indexRight++];
            }
            return left + right + count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Solution_TimeOut {
    // 暴力解法, 时间复杂度 O(n^2) 空间复杂度 O(1)
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
