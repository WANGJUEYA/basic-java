//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 示例 1: 
//
// 输入: "aacecaaa"
//输出: "aaacecaaa"
// 
//
// 示例 2: 
//
// 输入: "abcd"
//输出: "dcbabcd" 
// Related Topics 字符串


package com.jue.java.learntest.leetcode.editor.cn.ShortestPalindrome;

/**
 * @author JUE
 * @number 214
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.shortestPalindrome("abc"));
        System.out.println(solution.shortestPalindrome("aaaaa"));
        System.out.println(solution.shortestPalindrome("aabba"));
        System.out.println(solution.shortestPalindrome("aaaabbaa"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String shortestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        String str = s + reverse;
        len = str.length();
        int[] next = new int[len + 1];
        next[0] = -1;
        int j = -1, i = 0;
        // 找出最长前后缀
        while (i < len) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        if (next[len] == len - 1) {
            return s;
        } else if (next[len] > len / 2) {
            return reverse.substring(0, (len - next[len]) / 2 + 1) + s;
        } else {
            return reverse.substring(0, len / 2 - next[len]) + s;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
