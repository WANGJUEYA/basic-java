//给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串： 
//
// 
// 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'） 
// 每个元音 'a' 后面都只能跟着 'e' 
// 每个元音 'e' 后面只能跟着 'a' 或者是 'i' 
// 每个元音 'i' 后面 不能 再跟着另一个 'i' 
// 每个元音 'o' 后面只能跟着 'i' 或者是 'u' 
// 每个元音 'u' 后面只能跟着 'a' 
// 
//
// 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 1
//输出：5
//解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
// 
//
// 示例 2： 
//
// 输入：n = 2
//输出：10
//解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
// 
//
// 示例 3： 
//
// 输入：n = 5
//输出：68 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10^4 
// 
// Related Topics 动态规划 👍 119 👎 0


package com.jue.java.learn.leetcode.editor.cn.CountVowelsPermutation;

/**
 * @author JUE
 * @number 1220
 */
public class CountVowelsPermutation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countVowelPermutation(1)); // 5
        System.out.println(solution.countVowelPermutation(2)); // 10
        System.out.println(solution.countVowelPermutation(3)); // 19
        System.out.println(solution.countVowelPermutation(5)); // 68
        System.out.println(solution.countVowelPermutation(144)); // 18208803
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static int MOD = Double.valueOf(Math.pow(10, 9) + 7).intValue();

    public int countVowelPermutation(int n) {
        // 暴力计算法
        long[][] dp = new long[2][6];
        for (int init = 0; init < 5; init++) {
            dp[0][init] = 1;
        }
        dp[0][5] = 5;
        // a-0 e-1 i-2 o-3 u-4
        for (int index = 1; index < n; index++) {
            // a = e + i + u
            dp[1][0] = (dp[0][1] + dp[0][2] + dp[0][4]) % MOD;
            // e = a + i
            dp[1][1] = (dp[0][0] + dp[0][2]) % MOD;
            // i = e + o
            dp[1][2] = (dp[0][1] + dp[0][3]) % MOD;
            // o = i
            dp[1][3] = (dp[0][2]) % MOD;
            // u = i + o
            dp[1][4] = (dp[0][2] + dp[0][3]) % MOD;
            // sum
            long sum = 0;
            for (int add = 0; add < 5; add++) {
                sum = (sum + dp[1][add]) % MOD;
            }
            dp[1][5] = sum;
            System.arraycopy(dp[1], 0, dp[0], 0, 6);
        }
        return Long.valueOf(dp[0][5]).intValue();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
