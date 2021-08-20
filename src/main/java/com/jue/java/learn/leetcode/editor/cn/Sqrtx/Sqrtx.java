//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 702 👎 0


package com.jue.java.learn.leetcode.editor.cn.Sqrtx;

/**
 * @author JUE
 * @number 69
 */
public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        // 1. 袖珍计算器 利用指数和对数代替平方根
        // 2. 二分查找的解
        // 3.
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class SolutionTimeOut {
    public int mySqrt(int x) {
        // 1. 直接用平方函数
        // 2. 由于是去尾, 遍历到最后一个
        if (x == 0 || x == 1) {
            return x;
        }
        for (int index = 1; index <= x; index++) {
            int item = index * index;
            if (item == x) {
                return index;
            } else if (item > x) {
                return index - 1;
            }
        }
        return 0;
    }
}
