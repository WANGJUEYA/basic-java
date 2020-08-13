//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 431 👎 0


package com.jue.java.learntest.leetcode.editor.cn.MultiplyStrings;

/**
 * @author JUE
 * @number 43
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("2", "3"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len = num2.length();
        assert len > 0;
        String pre = num2.substring(0, len - 1);
        int one = num2.charAt(len - 1) - '0';

        String current = multiply(num1, one);

        if (pre.length() > 0) {
            pre = multiply(num1, pre) + "0";
            current = add(pre, current);
        }

        return current;
    }

    private String multiply(String num1, int one) {
        switch (one) {
            case 0:
                return "0";
            case 1:
                return num1;
            case 2:
                return add(num1, num1);
            default:
                int sub = one % 2;
                String next = multiply(num1, one / 2);
                String result = add(next, next);
                if (sub == 1) {
                    result = add(result, num1);
                }
                return result;
        }
    }

    private String add(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int add = 0;
        StringBuilder result = new StringBuilder();
        while (len1 >= 0 || len2 >= 0 || add > 0) {
            int temp = add;
            if (len1 >= 0) {
                temp += (num1.charAt(len1) - '0');
                len1--;
            }
            if (len2 >= 0) {
                temp += (num2.charAt(len2) - '0');
                len2--;
            }
            add = temp / 10;
            result.insert(0, (temp % 10));
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
