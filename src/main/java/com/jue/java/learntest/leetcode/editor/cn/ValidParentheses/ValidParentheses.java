//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


package com.jue.java.learntest.leetcode.editor.cn.ValidParentheses;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author JUE
 * @number 20
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        // 一个括号栈
        Stack<Character> stack = new Stack<>();
        List<Character> prefix = Arrays.asList('(', '[', '{');
        List<Character> suffix = Arrays.asList(')', ']', '}');
        for (char item : s.toCharArray()) {
            if (prefix.contains(item)) {
                stack.add(item);
                continue;
            }
            int index = suffix.indexOf(item);
            if (stack.isEmpty()) {
                return false;
            }
            if (!prefix.get(index).equals(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
