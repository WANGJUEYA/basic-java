//n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。 
//
// 每 3 个士兵可以组成一个作战单位，分组规则如下： 
//
// 
// 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k] 
// 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[
//k] ，其中 0 <= i < j < k < n 
// 
//
// 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。 
//
// 
//
// 示例 1： 
//
// 输入：rating = [2,5,3,4,1]
//输出：3
//解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
// 
//
// 示例 2： 
//
// 输入：rating = [2,1,3]
//输出：0
//解释：根据题目条件，我们无法组建作战单位。
// 
//
// 示例 3： 
//
// 输入：rating = [1,2,3,4]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// n == rating.length 
// 1 <= n <= 200 
// 1 <= rating[i] <= 10^5 
// 
// Related Topics 数组


package com.jue.java.learntest.leetcode.editor.cn.CountNumberOfTeams;

/**
 * @author JUE
 * @number 1395
 */
public class CountNumberOfTeams {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTeams(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.numTeams(new int[]{2, 5, 3, 4, 1}));
        System.out.println(solution.numTeams(new int[]{3, 6, 7, 5, 1}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTeams(int[] rating) {
        int len = rating.length;
        if (len <= 2) {
            return 0;
        }
        int sum = 0;
        // 计算比几个数大或者小
        int[][] dp = new int[2][len];
        for (int i = 0; i < len; i++) {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < i; j++) {
                // 递增
                if (rating[i] > rating[j]) {
                    count1++;
                    sum += dp[0][j];
                }

                // 递减
                if (rating[i] < rating[j]) {
                    count2++;
                    sum += dp[1][j];
                }
            }
            dp[0][i] = count1;
            dp[1][i] = count2;

//            System.out.println(Arrays.toString(dp[1]));
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
