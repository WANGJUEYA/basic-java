//给你一个下标从 0 开始的字符串 num ，表示一个非负整数。 
//
// 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。 
//
// 返回最少需要多少次操作可以使 num 变成特殊数字。 
//
// 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：num = "2245047"
//输出：2
//解释：删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 2 位数字。 
//
// 示例 2： 
//
// 
//输入：num = "2908305"
//输出：3
//解释：删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 3 位数字。 
//
// 示例 3： 
//
// 
//输入：num = "10"
//输出：1
//解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 1 位数字。
// 
//
// 
//
// 提示 
//
// 
// 1 <= num.length <= 100 
// num 仅由数字 '0' 到 '9' 组成 
// num 不含任何前导零 
// 
//
// Related Topics 贪心 数学 字符串 枚举 👍 23 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumOperationsToMakeASpecialNumber;

/**
 * @author JUE
 * @number 2844
 */
public class MinimumOperationsToMakeASpecialNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperations(String num) {
        // 能被25整除数的特征为结尾是 00, 25, 50, 75; 那就匹配到这个数字，感觉有什么很快的算法哎
        int len = num.length();
        int r0 = 0, r5 = 0;
        boolean f0 = false, f5 = false;
        boolean has0 = false;
        for (int i = len - 1; i >= 0; i--) {
            boolean end = false;
            char c = num.charAt(i);
            if (c == '0') {
                has0 = true;
            }
            if (!f0) {
                if (c == '0') {
                    f0 = true;
                } else {
                    r0++;
                }
            } else {
                if (c == '0' || c == '5') {
                    end = true;
                } else {
                    r0++;
                }
            }
            if (!f5) {
                if (c == '5') {
                    f5 = true;
                } else {
                    r5++;
                }
            } else {
                if (c == '2' || c == '7') {
                    end = true;
                } else {
                    r5++;
                }
            }
            if (end) {
                return Math.min(r0, r5);
            }
        }
        return len - (has0 ? 1 : 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
