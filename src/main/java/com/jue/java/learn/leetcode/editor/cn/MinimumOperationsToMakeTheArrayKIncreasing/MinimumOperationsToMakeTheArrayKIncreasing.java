//给你一个下标从 0 开始包含 n 个正整数的数组 arr ，和一个正整数 k 。 
//
// 如果对于每个满足 k <= i <= n-1 的下标 i ，都有 arr[i-k] <= arr[i] ，那么我们称 arr 是 K 递增 的。 
//
// 
// 比方说，arr = [4, 1, 5, 2, 6, 2] 对于 k = 2 是 K 递增的，因为：
//
// 
// arr[0] <= arr[2] (4 <= 5) 
// arr[1] <= arr[3] (1 <= 2) 
// arr[2] <= arr[4] (5 <= 6) 
// arr[3] <= arr[5] (2 <= 2) 
// 
// 
// 但是，相同的数组 arr 对于 k = 1 不是 K 递增的（因为 arr[0] > arr[1]），对于 k = 3 也不是 K 递增的（因为 arr[
//0] > arr[3] ）。 
// 
//
// 每一次 操作 中，你可以选择一个下标 i 并将 arr[i] 改成任意 正整数。 
//
// 请你返回对于给定的 k ，使数组变成 K 递增的 最少操作次数 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [5,4,3,2,1], k = 1
//输出：4
//解释：
//对于 k = 1 ，数组最终必须变成非递减的。
//可行的 K 递增结果数组为 [5,6,7,8,9]，[1,1,1,1,1]，[2,2,3,4,4] 。它们都需要 4 次操作。
//次优解是将数组变成比方说 [6,7,8,9,10] ，因为需要 5 次操作。
//显然我们无法使用少于 4 次操作将数组变成 K 递增的。
// 
//
// 示例 2： 
//
// 输入：arr = [4,1,5,2,6,2], k = 2
//输出：0
//解释：
//这是题目描述中的例子。
//对于每个满足 2 <= i <= 5 的下标 i ，有 arr[i-2] <= arr[i] 。
//由于给定数组已经是 K 递增的，我们不需要进行任何操作。 
//
// 示例 3： 
//
// 输入：arr = [4,1,5,2,6,2], k = 3
//输出：2
//解释：
//下标 3 和 5 是仅有的 3 <= i <= 5 且不满足 arr[i-3] <= arr[i] 的下标。
//将数组变成 K 递增的方法之一是将 arr[3] 变为 4 ，且将 arr[5] 变成 5 。
//数组变为 [4,1,5,4,6,5] 。
//可能有其他方法将数组变为 K 递增的，但没有任何一种方法需要的操作次数小于 2 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁵ 
// 1 <= arr[i], k <= arr.length 
// 
// 👍 3 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumOperationsToMakeTheArrayKIncreasing;

/**
 * @author JUE
 * @number 5959
 */
public class MinimumOperationsToMakeTheArrayKIncreasing {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kIncreasing(new int[]{5, 4, 3, 2, 1}, 1)); // 4
        System.out.println(solution.kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 2)); // 0
        System.out.println(solution.kIncreasing(new int[]{4, 1, 5, 2, 6, 2}, 3)); // 2
        System.out.println(solution.kIncreasing(new int[]{12, 6, 12, 6, 14, 2, 13, 17, 3, 8, 11, 7, 4, 11, 18, 8, 8, 3}, 1)); // 12
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kIncreasing(int[] arr, int k) {
        // 问题简化成把一个数组改成递增数据最小的操作次数
        // 同时简化成最长递增列表(动态规划!) - 计算最长的递归长度
        int len = arr.length;
        int[][] d = new int[k][len / k + 2];
        int[] maxLen = new int[k];
        int result = len;
        for (int index = 0; index < len; index++) {
            int countIndex = index % k;
            // 如果比数组最后一个大, 直接放入末尾
            if (arr[index] >= d[countIndex][maxLen[countIndex]]) {
                result--;
                d[countIndex][++maxLen[countIndex]] = arr[index];
            } else {
                // 二分查找对应的数字
                int low = 1, high = maxLen[countIndex] - 1, pos = 0, mid;
                while (low <= high) {
                    mid = (low + high) >> 1;
                    if (d[countIndex][mid] <= arr[index]) {
                        pos = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                d[countIndex][pos + 1] = arr[index];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class SolutionTimeout {
    public int kIncreasing(int[] arr, int k) {
        // 问题简化成把一个数组改成递增数据最小的操作次数
        // 同时简化成最长递增列表(动态规划!) - 计算最长的递归长度
        int len = arr.length;
        int[] dp = new int[len];
        int[] maxCount = new int[k];
        int result = len;
        for (int index = 0; index < len; index++) {
            int countIndex = index % k;
            int maxLen = 1;
            // fixme 超出时间限制; 参考 300. 最长上升子序列的长度;673. 最长递增子序列的个数(记录最长递归数组)
            for (int j = index - k; j >= 0; j -= k) {
                if (arr[j] <= arr[index]) {
                    maxLen = Math.max(maxLen, dp[j] + 1);
                }
            }
            dp[index] = maxLen;
            if (maxLen > maxCount[countIndex]) {
                result -= (maxLen - maxCount[countIndex]);
                maxCount[countIndex] = maxLen;
            }
        }
        return result;
    }
}


