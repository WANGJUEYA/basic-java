//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
//
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
// 请你实现这个将字符串进行指定行数变换的函数：
//
// string convert(string s, int numRows);
//
// 示例 1:
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
//
//
// 示例 2:
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G
// Related Topics 字符串


package com.jue.java.learn.leetcode.editor.cn.ZigzagConversion;

/**
 * @author JUE
 * @number 6
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("LEETCODEISHIRING", 3).equals("LCIRETOESIIGEDHN"));
        System.out.println(solution.convert("LEETCODEISHIRING", 4).equals("LDREOEIIECIHNTSG"));
        System.out.println(solution.convert("AB", 1).equals("AB"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        int step = 2 * numRows - 2;
        if (step == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            int index = row;
            while (index < len + step - 1) {
                if (row > 0 && row < numRows - 1 && index > step && index - 2 * row > 0 && index - 2 * row < len) {
                    result.append(s.charAt(index - 2 * row));
                }
                if (index < len) {
                    result.append(s.charAt(index));
                }
                index += step;
            }
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class SolutionNo1 {
    public String convert(String s, int numRows) {
        int len = s.length();
        if (len <= 1 || numRows <= 1) {
            return s;
        }
        int sub = (numRows * 2 - 2);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i < len) {
                result.append(s.charAt(i));
            }
            int mid = sub - i;
            int j = i + sub;
            do {
                if (mid < len && i != 0 && i != numRows - 1) {
                    result.append(s.charAt(mid));
                }
                mid += sub;
                if (j < len) {
                    result.append(s.charAt(j));
                }
                j += sub;
            } while (mid < len);
        }
        return result.toString();
    }
}

