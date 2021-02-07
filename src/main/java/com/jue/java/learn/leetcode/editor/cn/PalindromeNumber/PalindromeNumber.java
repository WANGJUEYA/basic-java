//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1:
//
// 输入: 121
//输出: true
//
//
// 示例 2:
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3:
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 进阶:
//
// 你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学


package com.jue.java.learn.leetcode.editor.cn.PalindromeNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @number 9
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(485));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        // 1.判断正负
        if (x < 0) {
            return false;
        }
        // 判断整数是否为回文
        // 2.分解数字
        List<Integer> bit = new ArrayList<>();
        while (x > 0) {
            int lowBit = x % 10;
            // System.out.println("lowBit: " + lowBit);
            bit.add(lowBit);
            // x = x / 10;
            x /= 10;
        }

        // 3.判断回文
        int heightIndex = bit.size() - 1, lowIndex = 0;
        while (heightIndex > lowIndex) {
            if (!bit.get(heightIndex).equals(bit.get(lowIndex))) {
                return false;
            }
            heightIndex--;
            lowIndex++;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

