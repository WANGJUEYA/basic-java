//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


package com.jue.java.learntest.leetcode.editor.cn.LongestCommonPrefix;

/**
 * @author JUE
 * @number 14
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        int count = 0;
        boolean flag = true;
        StringBuilder result = new StringBuilder();
        while (flag) {
            Character temp = null;
            for (String s : strs) {
                if (count >= s.length() || (temp != null && temp != s.charAt(count))) {
                    flag = false;
                    break;
                }
                temp = s.charAt(count);
            }
            count++;
            if (flag) {
                result.append(temp);
            }
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
