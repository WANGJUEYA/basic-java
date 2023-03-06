//给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。 
//
// 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' 
//，此时认为 s 是 平衡 的。 
//
// 请你返回使 s 平衡 的 最少 删除次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aababbab"
//输出：2
//解释：你可以选择以下任意一种方案：
//下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
//下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
// 
//
// 示例 2： 
//
// 
//输入：s = "bbaaaaabb"
//输出：2
//解释：唯一的最优解是删除最前面两个字符。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 要么是 'a' 要么是 'b' 。 
// 
//
// Related Topics 栈 字符串 动态规划 👍 146 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumDeletionsToMakeStringBalanced;

/**
 * @author JUE
 * @number 1653
 */
public class MinimumDeletionsToMakeStringBalanced {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDeletions("aababbab"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDeletions(String s) {
        int len = s.length();
        // 左边b的个数及右边a的个数
        int[][] count = new int[2][len + 1];
        int result = Integer.MAX_VALUE;
        for (int left = 0; left <= len; left++) {
            int right = len - left;
            if (left > 0) {
                count[1][left] = count[1][left - 1] + (s.charAt(left - 1) == 'b' ? 1 : 0);
            }
            if (right < len) {
                count[0][right] = count[0][right + 1] + (s.charAt(right) == 'a' ? 1 : 0);
            }
        }
        for (int index = 0; index <= len; index++) {
            result = Math.min(result, count[0][index] + count[1][index]);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
