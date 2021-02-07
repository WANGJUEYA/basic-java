//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划


package com.jue.java.learn.leetcode.editor.cn.LongestValidParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author JUE
 * @number 32
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
        System.out.println(solution.longestValidParentheses("()(()"));
        System.out.println(solution.longestValidParentheses("()(())"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len <= 1) {
            return 0;
        }
        // 推入每个左括号的索引号
        Stack<Integer> stack = new Stack<>();
        List<int[]> list = new ArrayList<>();
        int max = 0;

        // 我们计算每一组 begin,end
        for (int index = 0; index < len; index++) {
            char item = s.charAt(index);
            if ('(' == item) {
                stack.push(index);
            } else if (!stack.empty()) {
                // 右括号取出最近的一个索引
                int left = stack.pop();
                int[] temp = new int[]{left, index};

                while (list.size() > 0) {
                    int[] last = list.get(0);
                    if (last[1] + 1 == temp[0] || (temp[0] + 1 == last[0] && index - 1 == last[1])) {
                        temp[0] = Math.min(last[0], temp[0]);
                    } else {
                        break;
                    }
                    list.remove(0);
                }
                max = Math.max(max, index - temp[0] + 1);
                list.add(0, temp);
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
