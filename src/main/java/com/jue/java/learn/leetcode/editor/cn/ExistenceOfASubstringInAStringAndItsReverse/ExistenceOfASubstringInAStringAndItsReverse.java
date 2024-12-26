//给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。 
//
// 如果存在这样的子字符串，返回 true；如果不存在，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "leetcode" 
// 
//
// 输出：true 
//
// 解释：子字符串 "ee" 的长度为 2，它也出现在 reverse(s) == "edocteel" 中。 
//
// 示例 2： 
//
// 
// 输入：s = "abcba" 
// 
//
// 输出：true 
//
// 解释：所有长度为 2 的子字符串 "ab"、"bc"、"cb"、"ba" 也都出现在 reverse(s) == "abcba" 中。 
//
// 示例 3： 
//
// 
// 输入：s = "abcd" 
// 
//
// 输出：false 
//
// 解释：字符串 s 中不存在满足「在其反转后的字符串中也出现」且长度为 2 的子字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// 字符串 s 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 👍 14 👎 0


package com.jue.java.learn.leetcode.editor.cn.ExistenceOfASubstringInAStringAndItsReverse;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JUE
 * @number 3083
 */
public class ExistenceOfASubstringInAStringAndItsReverse {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubstringPresent("abcba")); // true
        System.out.println(solution.isSubstringPresent("edocteel")); // true
        System.out.println(solution.isSubstringPresent("abcd")); // false
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubstringPresent(String s) {
        Set<String> exist = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            exist.add(s.substring(i, i + 2));
        }
        for (int i = 1; i < len; i++) {
            if (exist.contains(s.charAt(i) + "" + s.charAt(i - 1))) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
