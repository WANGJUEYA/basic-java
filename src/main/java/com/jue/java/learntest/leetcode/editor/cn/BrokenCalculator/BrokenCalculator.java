//在显示着数字的坏计算器上，我们可以执行以下两种操作： 
//
// 
// 双倍（Double）：将显示屏上的数字乘 2； 
// 递减（Decrement）：将显示屏上的数字减 1 。 
// 
//
// 最初，计算器显示数字 X。 
//
// 返回显示数字 Y 所需的最小操作数。 
//
// 
//
// 示例 1： 
//
// 输入：X = 2, Y = 3
//输出：2
//解释：先进行双倍运算，然后再进行递减运算 {2 -> 4 -> 3}.
// 
//
// 示例 2： 
//
// 输入：X = 5, Y = 8
//输出：2
//解释：先递减，再双倍 {5 -> 4 -> 8}.
// 
//
// 示例 3： 
//
// 输入：X = 3, Y = 10
//输出：3
//解释：先双倍，然后递减，再双倍 {3 -> 6 -> 5 -> 10}.
// 
//
// 示例 4： 
//
// 输入：X = 1024, Y = 1
//输出：1023
//解释：执行递减运算 1023 次
// 
//
// 
//
// 提示： 
//
// 
// 1 <= X <= 10^9 
// 1 <= Y <= 10^9 
// 
// Related Topics 贪心算法 数学


package com.jue.java.learntest.leetcode.editor.cn.BrokenCalculator;

/**
 * @author JUE
 * @number 991
 */
public class BrokenCalculator {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.brokenCalc(3, 10));
//        System.out.println(solution.brokenCalc(1, 1000000000));
        System.out.println(solution.brokenCalc(1, 10));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 为什么这道题采用逆向思维更优？ 正向思维：在X<Y时要实现操作数最小，
     * 要将X逼近Y的1/2值或1/4值或1/8值或...再进行*2操作，难点在于要判断要逼近的是1/2值还是1/4值还是其他值，逻辑复杂
     * 逆向思维：在Y>X时Y只管/2，到了Y<X时在+1逼近 说白了就是，正向思维采用的是先小跨度的-1操作，再大跨度的*2操作；
     * 逆向思维采用的是先大跨度的/2操作，再小跨度的-1操作 然而事实上往往是先大后小的解决问题思维在实现起来会比较简单
     */
    public int brokenCalc(int X, int Y) {
        int count = 0;
        while (X < Y) {
            count++;
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y++;
            }
        }
        return count + X - Y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
