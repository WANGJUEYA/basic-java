//「快乐前缀」是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。 
//
// 给你一个字符串 s，请你返回它的 最长快乐前缀。 
//
// 如果不存在满足题意的前缀，则返回一个空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：s = "level"
//输出："l"
//解释：不包括 s 自己，一共有 4 个前缀（"l", "le", "lev", "leve"）和 4 个后缀（"l", "el", "vel", "evel
//"）。最长的既是前缀也是后缀的字符串是 "l" 。
// 
//
// 示例 2： 
//
// 输入：s = "ababab"
//输出："abab"
//解释："abab" 是最长的既是前缀也是后缀的字符串。题目允许前后缀在原字符串中重叠。
// 
//
// 示例 3： 
//
// 输入：s = "leetcodeleet"
//输出："leet"
// 
//
// 示例 4： 
//
// 输入：s = "a"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 只含有小写英文字母 
// 
// Related Topics 字符串


package com.jue.java.learn.leetcode.editor.cn.LongestHappyPrefix;

/**
 * @author JUE
 * @number 1392
 */
public class LongestHappyPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // TODO should be learn
    public String longestPrefix(String s) {
        int[] next = getNext(s);
        int n = next[s.length()];
        return s.substring(0, n);
    }

    int[] getNext(String s) {
        int[] next = new int[s.length() + 1];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < s.length()) {
            if (j == -1 || s.charAt(j) == s.charAt(i))
                // 已有 [0, ..., j - 1] 与 [i - j, ..., i - 1] 匹配, 同时 s[j] == s[i]
                next[++i] = ++j;
                // 匹配长度增加 1, 查看下一个匹配位置
            else
                j = next[j];
            // 不匹配, 说明当前查看的前缀太长, 将 j 跳回到上一个可能的匹配位置
        }
        return next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
