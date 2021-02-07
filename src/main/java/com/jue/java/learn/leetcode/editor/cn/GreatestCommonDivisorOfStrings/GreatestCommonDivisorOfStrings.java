//对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。 
//
// 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。 
//
// 
//
// 示例 1： 
//
// 输入：str1 = "ABCABC", str2 = "ABC"
//输出："ABC"
// 
//
// 示例 2： 
//
// 输入：str1 = "ABABAB", str2 = "ABAB"
//输出："AB"
// 
//
// 示例 3： 
//
// 输入：str1 = "LEET", str2 = "CODE"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= str1.length <= 1000 
// 1 <= str2.length <= 1000 
// str1[i] 和 str2[i] 为大写英文字母 
// 
// Related Topics 字符串


package com.jue.java.learn.leetcode.editor.cn.GreatestCommonDivisorOfStrings;

/**
 * @author JUE
 * @number 1071
 */
public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(solution.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(solution.gcdOfStrings("LEET", "CODE"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String sub1 = sub(str1);
        String sub2 = sub(str2);
        if (!sub1.equals(sub2) || sub1.length() == 0) {
            return "";
        }
        // 求两数的公约数
        int count = gcdOfNumber(str1.length() / sub1.length(), str2.length() / sub2.length());
        return sum(sub1, count);
    }

    // 求数字的公约数(辗转相除法)
    public int gcdOfNumber(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        if (max % min == 0) {
            return min;
        }
        return gcdOfNumber(min, max % min);
    }

    // 求字符串的因子
    public String sub(String str) {
        int len = str.length();
        if (len <= 1) {
            return str;
        }
        for (int index = 1; index <= len; index++) {
            if (len % index == 0) {
                String sub = str.substring(0, index);
                if (sum(sub, len / index).equals(str)) {
                    return sub;
                }
            }
        }
        return "";
    }

    // 组合因子
    public String sum(String str, int count) {
        StringBuilder result = new StringBuilder(str);
        while (--count > 0) {
            result.append(str);
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
