//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 709 👎 0


package com.jue.java.learn.leetcode.editor.cn.PlusOne;

import java.util.Arrays;

/**
 * @author JUE
 * @number 66
 */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{0})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        // 如果最后add仍然为1, 则在最前方追击1
        int add = 1;
        int len = digits.length;
        for (int index = len - 1; index >= 0; index--) {
            if (digits[index] == 9) {
                digits[index] = 0;
            } else {
                digits[index]++;
                add = 0;
                break;
            }
        }
        if (add == 0) {
            return digits;
        } else {
            int[] result = new int[len + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, len);
            return result;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
