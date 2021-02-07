//给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。 
//
// 返回使 A 中的每个值都是唯一的最少操作次数。 
//
// 示例 1: 
//
// 输入：[1,2,2]
//输出：1
//解释：经过一次 move 操作，数组将变为 [1, 2, 3]。 
//
// 示例 2: 
//
// 输入：[3,2,1,2,1,7]
//输出：6
//解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
//可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 40000 
// 0 <= A[i] < 40000 
// 
// Related Topics 数组


package com.jue.java.learn.leetcode.editor.cn.MinimumIncrementToMakeArrayUnique;

import java.util.Arrays;

/**
 * @author JUE
 * @number 945
 */
public class MinimumIncrementToMakeArrayUnique {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 2};
        int[] array1 = {3, 2, 1, 2, 1, 7};
        System.out.println(solution.minIncrementForUnique(array1));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minIncrementForUnique(int[] A) {
        int len = A.length;
        if (len <= 1) {
            return 0;
        }
        // 算出所 e有数据的和
        Arrays.sort(A);
        int sumBegin = A[0];
        int sumEnd = A[0];
        int posCount = 0;
        for (int i = 1; i < len; i++) {
            sumBegin += A[i];
            if (A[i] == A[i - 1]) {
                posCount++;
            } else {
                sumEnd += A[i];
                int temp = A[i - 1];
                while (++temp < A[i] && posCount > 0) {
                    posCount--;
                    sumEnd += temp;
                }
            }
        }
        int temp = A[len - 1];
        while (posCount > 0) {
            posCount--;
            sumEnd += (++temp);
        }
        return sumEnd - sumBegin;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
