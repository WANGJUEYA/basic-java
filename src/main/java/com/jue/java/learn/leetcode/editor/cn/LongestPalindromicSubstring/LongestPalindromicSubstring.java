//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


package com.jue.java.learn.leetcode.editor.cn.LongestPalindromicSubstring;

/**
 * @author JUE
 * @number 5
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        Solution solution = new Solution();
        SolutionDp solution = new SolutionDp();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("ac"));
        System.out.println(solution.longestPalindrome("aaabaaaa"));
        System.out.println(solution.longestPalindrome("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 方法1: 首尾依次遍历 空间复杂度 O(1) 时间复杂度 O(n^3?) ! 超时警告->是否第一个找到的即为最长的数据?
    public String longestPalindrome(String s) {
        String result = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int j = len - 1;
            while (j >= i) {
                if (s.charAt(i) == s.charAt(j)) {
                    int p = i, q = j;
                    while (p < q && s.charAt(p) == s.charAt(q)) {
                        p++;
                        q--;
                    }
                    if (p >= q) {
                        String sub = s.substring(i, j + 1);
                        if (sub.length() > len / 2D) {
                            return sub;
                        }
                        if (sub.length() > result.length()) {
                            result = sub;
                        }
                    }
                }
                j--;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 动态规划的解法
class SolutionDp {
    public String longestPalindrome(String s) {
        // dp[i][j] = (s[i] == s[j]) && (2 + dp[i-1][j-1])
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int begin = 0;
        int end = 0;
        int subLen = 1;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = (j - i < 3) || dp[i + 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    if (j - i + 1 > subLen) {
                        subLen = j - i + 1;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin, end + 1);
    }
}