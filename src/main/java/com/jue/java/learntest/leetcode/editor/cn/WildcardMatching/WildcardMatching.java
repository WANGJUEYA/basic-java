//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心算法 字符串 动态规划 回溯算法


package com.jue.java.learntest.leetcode.editor.cn.WildcardMatching;

/**
 * @author JUE
 * @number 44
 */
public class WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // true
        System.out.println(solution.isMatch("aa", "aa"));
        // false
        System.out.println(solution.isMatch("aa", "a"));
        // true
        System.out.println(solution.isMatch("c", "**?**"));
        // true
        System.out.println(solution.isMatch("aa", "*"));
        // true
        System.out.println(solution.isMatch("acdeb", "*a*b"));
        // false
        System.out.println(solution.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"));
        // false
        System.out.println(solution.isMatch("mississippi", "m??*ss*?i*pi"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        int len_s = s.length(), len_p = p.length();
        if (len_p == 0 && len_s != 0) {
            return false;
        }
        if (len_s == 0) {
            int index = -1;
            while (++index < len_p) {
                if ('*' != p.charAt(index)) {
                    return false;
                }
            }
            return true;
        }
        // ps 两行dp数据即可
        boolean[] last = new boolean[len_s + 1];
        last[0] = true;
        boolean[] temp;
        for (int j = 0; j < len_p; j++) {
            temp = new boolean[len_s + 1];
            char item = p.charAt(j);
            if ('*' == item) {
                int i = 0;
                while (i <= len_s) {
                    if (last[i]) {
                        break;
                    }
                    i++;
                }
                if (i > len_s) {
                    return false;
                }
                for (; i <= len_s; i++) {
                    temp[i] = true;
                }
            } else {
                for (int i = 0; i < len_s; i++) {
                    temp[i + 1] = (item == '?' || item == s.charAt(i)) && last[i];
                }
            }
            last = temp;
        }
        return last[len_s];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_TimeOut {
    public boolean isMatch(String s, String p) {
        int len_s = s.length(), len_p = p.length();
        if (len_s == 0) {
            int index = -1;
            while (++index < len_p) {
                if ('*' != p.charAt(index)) {
                    return false;
                }
            }
            return true;
        }
        int i_s = 0;
        for (int i_p = 0; i_p < len_p; i_p++) {
            char item = p.charAt(i_p);
            if (i_s >= len_s) {
                return isMatch("", p.substring(i_p));
            }
            if ('*' != item && '?' != item && s.charAt(i_s) != item) {
                return false;
            }
            if ('*' == item) {
                char next = ' ';
                while (++i_p < len_p) {
                    next = p.charAt(i_p);
                    if ('?' == next) {
                        i_s++;
                    } else if ('*' != next) {
                        break;
                    }
                }
                if (i_p == len_p && i_s <= len_s) {
                    return true;
                }
                while (i_s < len_s) {
                    if ('*' == next || '?' == next || s.charAt(i_s) == next) {
                        boolean result = isMatch(s.substring(i_s), p.substring(i_p));
                        if (result) {
                            return true;
                        }
                    }
                    i_s++;
                }
                return false;
            } else {
                i_s++;
            }
        }
        return i_s == len_s;
    }
}
