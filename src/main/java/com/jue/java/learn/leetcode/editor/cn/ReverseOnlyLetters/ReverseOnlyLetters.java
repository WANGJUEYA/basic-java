//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 👍 123 👎 0


package com.jue.java.learn.leetcode.editor.cn.ReverseOnlyLetters;

/**
 * @author JUE
 * @number 917
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("dc-ba".equals(solution.reverseOnlyLetters("ab-cd")));
        System.out.println("j-Ih-gfE-dCba".equals(solution.reverseOnlyLetters("a-bC-dEf-ghIj")));
        System.out.println("Qedo1ct-eeLg=ntse-T!".equals(solution.reverseOnlyLetters("Test1ng-Leet=code-Q!")));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String s) {
        int len = s.length();
        int pointBegin = 0, pointEnd = len;
        StringBuilder result = new StringBuilder();
        while (pointBegin < len) {
            char item = s.charAt(pointBegin);
            // 如果当前元素为字母, 从反序取一个字母; 否则取当前符号
            if (isWord(item)) {
                while (--pointEnd >= 0 && !isWord(s.charAt(pointEnd))) {
                }
                result.append(s.charAt(pointEnd));
            } else {
                result.append(s.charAt(pointBegin));
            }
            pointBegin++;
        }
        return result.toString();
    }

    private boolean isWord(char item) {
        return (item >= 'a' && item <= 'z') || (item >= 'A' && item <= 'Z');
    }

}
//leetcode submit region end(Prohibit modification and deletion)
