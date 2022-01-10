//累加数 是一个字符串，组成它的数字可以形成累加序列。 
//
// 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。 
//
// 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。 
//
// 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 
//
// 示例 1： 
//
// 
//输入："112358"
//输出：true 
//解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2： 
//
// 
//输入："199100199"
//输出：true 
//解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 35 
// num 仅由数字（0 - 9）组成 
// 
//
// 
//
// 进阶：你计划如何处理由过大的整数输入导致的溢出? 
// Related Topics 字符串 回溯 👍 288 👎 0


package com.jue.java.learn.leetcode.editor.cn.AdditiveNumber;

/**
 * @author JUE
 * @number 306
 */
public class AdditiveNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAdditiveNumber("112358")); // true
        System.out.println(solution.isAdditiveNumber("199100199")); // true
        System.out.println(solution.isAdditiveNumber("123")); // true
        System.out.println(solution.isAdditiveNumber("10")); // false
        System.out.println(solution.isAdditiveNumber("199111992")); // true
        System.out.println(solution.isAdditiveNumber("199001200")); // false
        System.out.println(solution.isAdditiveNumber("101")); // true
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isAdditiveNumber(String num) {
        // 开始遍历计算所有的可能(按位增加)
        // 不能单独直接加 按照长度为 n位的方案, one 的长度为 1 <-> n-1
        for (int total = 2, len = num.length(); total < len; total++) {
            for (int index = 1; index < total; index++) {
                if (isAdditiveNumber(num, index, total - index)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(String num, int oneSize, int twoSize) {
        int len = num.length();
        int oneBegin = 0, mid = oneBegin + oneSize, twoEnd = mid + twoSize;
        if (twoEnd > len) {
            return false;
        }
        while (true) {
            String num1 = num.substring(oneBegin, mid);
            String num2 = num.substring(mid, twoEnd);
            if ((num1.length() > 1 && num1.startsWith("0")) ||
                    (num2.length() > 1 && num2.startsWith("0"))) {
                return false;
            }

            String result = add(num1, num2);

//            System.out.println(num1 + " + " + num2 + " = " + result);

            if (twoEnd + result.length() <= len && result.equals(num.substring(twoEnd, twoEnd + result.length()))) {

//                System.out.println(num.substring(twoEnd, twoEnd + result.length()));

                oneBegin = mid;
                mid = twoEnd;
                twoEnd = mid + result.length();
                if (twoEnd == len) {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    private String add(String num1, String num2) {
        int index1 = num1.length() - 1, index2 = num2.length() - 1, count = 0;
        StringBuilder result = new StringBuilder();
        while (index1 >= 0 || index2 >= 0 || count > 0) {
            int add1 = index1 >= 0 ? (num1.charAt(index1--) - '0') : 0;
            int add2 = index2 >= 0 ? (num2.charAt(index2--) - '0') : 0;
            int sum = add1 + add2 + count;
            result.insert(0, sum % 10);
            count = sum / 10;
        }
        return result.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)
