//给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数的个数。 
//
// 
//
// 示例 1： 
//
// 输入：20
//输出：1
//解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
// 
//
// 示例 2： 
//
// 输入：100
//输出：10
//解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
// 
//
// 示例 3： 
//
// 输入：1000
//输出：262
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 
// Related Topics 数学 动态规划


package com.jue.java.learn.leetcode.editor.cn.NumbersWithRepeatedDigits;

/**
 * @author JUE
 * @number 1012
 */
public class NumbersWithRepeatedDigits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDupDigitsAtMostN(12));
        System.out.println(solution.numDupDigitsAtMostN(11));
        System.out.println(solution.numDupDigitsAtMostN(20));
        System.out.println(solution.numDupDigitsAtMostN(100));
        System.out.println(solution.numDupDigitsAtMostN(1000));
        System.out.println(solution.numDupDigitsAtMostN(120));
        System.out.println(solution.numDupDigitsAtMostN(110));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 推荐思路 数位DP?
    public int numDupDigitsAtMostN(int N) {
        if (N < 10) {
            return 0;
        }

        // 1. 找到所有不重复的数字
        int pos = (int) Math.log10(N);
        int[] bound = new int[pos + 1];
        for (int temp = N, index = pos; index >= 0; index--, temp /= 10) {
            bound[index] = temp % 10;
        }

        int sum = 0;
        int bit = 0;
        int count = 1;
        boolean[] temp = new boolean[10];
        boolean self = true;
        while (bit <= pos) {
            if (bit == 0) {
                count *= 9;
            } else {
                count *= 10 - bit;
            }
            if (bit < pos) {
                sum += count;
            }
            if (bit == 0) {
                sum += (bound[bit] - 1) * A(pos - bit, 9 - bit);
            } else if (self) {
                int index = -1;
                int prefix = 0;
                while (++index < bound[bit]) {
                    if (!temp[index]) {
                        prefix++;
                    }
                }
                sum += prefix * A(pos - bit, 9 - bit);
            }
            if (temp[bound[bit]]) {
                self = false;
            }
            temp[bound[bit]] = true;
            bit++;
        }
        if (self) {
            sum++;
        }
        return N - sum;
    }

    private int A(int a, int b) {
        if (a <= 0) {
            return 1;
        } else if (a == 1) {
            return b;
        } else {
            return b * A(a - 1, b - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
