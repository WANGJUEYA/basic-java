//给你两个长度为 n 的字符串 s1 和 s2 ，以及一个字符串 evil 。请你返回 好字符串 的数目。 
//
// 好字符串 的定义为：它的长度为 n ，字典序大于等于 s1 ，字典序小于等于 s2 ，且不包含 evil 为子字符串。 
//
// 由于答案可能很大，请你返回答案对 10^9 + 7 取余的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, s1 = "aa", s2 = "da", evil = "b"
//输出：51 
//解释：总共有 25 个以 'a' 开头的好字符串："aa"，"ac"，"ad"，...，"az"。还有 25 个以 'c' 开头的好字符串："ca"，"cc
//"，"cd"，...，"cz"。最后，还有一个以 'd' 开头的好字符串："da"。
// 
//
// 示例 2： 
//
// 输入：n = 8, s1 = "leetcode", s2 = "leetgoes", evil = "leet"
//输出：0 
//解释：所有字典序大于等于 s1 且小于等于 s2 的字符串都以 evil 字符串 "leet" 开头。所以没有好字符串。
// 
//
// 示例 3： 
//
// 输入：n = 2, s1 = "gx", s2 = "gz", evil = "x"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// s1.length == n 
// s2.length == n 
// s1 <= s2 
// 1 <= n <= 500 
// 1 <= evil.length <= 50 
// 所有字符串都只包含小写英文字母。 
// 
// Related Topics 动态规划


package com.jue.java.learntest.leetcode.editor.cn.FindAllGoodStrings;

/**
 * @author JUE
 * @number 1397
 */
public class FindAllGoodStrings {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findGoodStrings(2, "aa", "da", "b"));
//        System.out.println(solution.findGoodStrings(2, "gx", "gz", "x"));
//        System.out.println(solution.findGoodStrings(8, "leetcode", "leetgood", "leet"));
        System.out.println(solution.findGoodStrings(3, "szc", "zyi", "p")); // 4357
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int MOD = (int) (1E9 + 7);
    int[][][] dp;
    int[][] trans;
    int[] next;
    int N;
    String S1;
    String S2;
    int LEN;
    String EVIL;

    // 先单纯使用暴力搜索的方法 计算有多少字符包含evil
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        N = n;
        S1 = s1;
        S2 = s2;
        EVIL = evil;
        LEN = evil.length();
        // KMP 得到evil 数组最长前缀后缀数组
        next = new int[LEN + 1];
        int next_i = 0, next_j = -1;
        next[0] = -1;
        while (next_i < LEN) {
            if (next_j == -1 || evil.charAt(next_i) == evil.charAt(next_j)) {
                next[++next_i] = ++next_j;
            } else {
                next_j = next[next_j];
            }
        }

        // 数位DP int[pos][stats][bound] = num; pos s1/s2 数组的第pos位; stats 某串的后缀与 evil最长匹配前缀; bound边界状态
        dp = new int[n][LEN][4]; // 00 01 10 11
        trans = new int[LEN][26];
        return dfs(0, 0, 3);
    }

    // 这是计算关于 stats 的转移函数
    // 输入为 stats 和 d
    // 输出为转移的结果 g_s(stats, d)
    private int getTrans(int stats, char ch) {
        int chInt = ch - 'a';
        // 如果之前计算过该转移函数就直接返回结果
        if (trans[stats][chInt] != 0) {
            return trans[stats][chInt];
        }
        // 这是 KMP 算法的一部分
        // 把 evil 看作「模式串」，stats 看作「主串」匹配到的位置
        int s = stats;
        while (s >= 0 && EVIL.charAt(s) != ch) {
            s = next[s];
        }
        // 存储结果并返回
        return trans[stats][chInt] = s + 1;
    }

    // 这是用来进行记忆化搜索的函数
    int dfs(int pos, int stats, int bound) {
        // 如果匹配到了 evil 的末尾
        // 说明字符串不满足要求了
        // 返回 0
        if (stats == LEN) {
            return 0;
        }
        // 如果匹配到了上下界的末尾
        // 说明找到了一个满足要求的字符串
        // 返回 1
        if (pos == N) {
            return 1;
        }
        // 记忆化搜索的关键
        // 如果之前计算过该状态就直接返回结果
        if (dp[pos][stats][bound] != 0) {
            return dp[pos][stats][bound];
        }

        // 将当前状态初始化
        dp[pos][stats][bound] = 0;
        // 计算第 pos 位可枚举的字符下界
        char l = ((bound == 1 || bound == 3) ? S1.charAt(pos) : 'a');
        // 计算第 pos 位可枚举的字符上界
        char r = ((bound == 2 || bound == 3) ? S2.charAt(pos) : 'z');
        for (char ch = l; ch <= r; ch++) {
            int nxt_stats = getTrans(stats, ch);
            // 这里写得较为复杂
            // 本质上就是关于 bound 的转移函数
            // 可以根据自己的理解编写
            // int nxt_bound = (bound & 1 ? ch == s1[pos] : 0) ^ (bound & 2 ? (ch == s2[pos]) << 1 : 0);

            int nxt_bound = 0;
            if (bound == 1 && S1.charAt(pos) == ch) {
                nxt_bound = 1;
            } else if (bound == 2 && S2.charAt(pos) == ch) {
                nxt_bound = 2;
            } else if (bound == 3) {
                if (S1.charAt(pos) == ch && S2.charAt(pos) == ch) {
                    nxt_bound = 3;
                } else if (S1.charAt(pos) == ch) {
                    nxt_bound = 1;
                } else if (S2.charAt(pos) == ch) {
                    nxt_bound = 2;
                }
            }

            dp[pos][stats][bound] += dfs(pos + 1, nxt_stats, nxt_bound);
            dp[pos][stats][bound] %= MOD;
        }
        return dp[pos][stats][bound];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
