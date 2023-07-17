//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
//
//
//
// 示例 1：
//
//
//输入：num1 = "11", num2 = "123"
//输出："134"
//
//
// 示例 2：
//
//
//输入：num1 = "456", num2 = "77"
//输出："533"
//
//
// 示例 3：
//
//
//输入：num1 = "0", num2 = "0"
//输出："0"
//
//
//
//
//
//
// 提示：
//
//
// 1 <= num1.length, num2.length <= 10⁴
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
//
//
// Related Topics 数学 字符串 模拟 👍 751 👎 0


package com.jue.java.learn.leetcode.editor.cn.AddStrings;

/**
 * @author JUE
 * @number 415
 */
public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        // 进位数字
        int carry = 0;
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        while (carry > 0 || idx1 >= 0 || idx2 >= 0) {
            int tmp1 = idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int tmp2 = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            int sum = tmp1 + tmp2 + carry;
            result.insert(0, sum % 10);
            carry = sum / 10;
            idx1--;
            idx2--;
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
