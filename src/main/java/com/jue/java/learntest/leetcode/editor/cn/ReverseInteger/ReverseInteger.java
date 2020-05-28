//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1:
//
// 输入: 123
//输出: 321
//
//
// 示例 2:
//
// 输入: -123
//输出: -321
//
//
// 示例 3:
//
// 输入: 120
//输出: 21
//
//
// 注意:
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学


package com.jue.java.learntest.leetcode.editor.cn.ReverseInteger;

/**
 * @author JUE
 * @number 7
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        if (x <= -Math.pow(2, 31) || x > Math.pow(2, 31)) {
            return 0;
        }

        long temp = x > 0 ? x : -1 * x;
        // System.out.println(temp);
        long result = 0;
        do {
            int mod = ((int) temp) % 10;
            if (result * 10 + mod > Math.pow(2, 31)) {
                return 0;
            }
            result = result * 10 + mod;
            temp /= 10;
            // System.out.println(result);

        } while (temp > 0);
        return (int) (x > 0 ? result : -result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

