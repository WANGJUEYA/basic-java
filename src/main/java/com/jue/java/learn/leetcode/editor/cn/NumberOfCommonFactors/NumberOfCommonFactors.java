//给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。 
//
// 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。 
//
// 
//
// 示例 1： 
//
// 输入：a = 12, b = 6
//输出：4
//解释：12 和 6 的公因子是 1、2、3、6 。
// 
//
// 示例 2： 
//
// 输入：a = 25, b = 30
//输出：2
//解释：25 和 30 的公因子是 1、5 。 
//
// 
//
// 提示： 
//
// 
// 1 <= a, b <= 1000 
// 
//
// Related Topics 数学 枚举 数论 👍 34 👎 0


package com.jue.java.learn.leetcode.editor.cn.NumberOfCommonFactors;

/**
 * @author JUE
 * @number 2427
 */
public class NumberOfCommonFactors {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.commonFactors(12, 6)); // 4
        System.out.println(solution.commonFactors(25, 30)); // 2
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int commonFactors(int a, int b) {
        // 最大公约数
        int gcd = gcd(a, b);

        // 直接枚举法
        int ans = 0;
        for (int x = 1; x * x <= gcd; ++x) {
            if (gcd % x == 0) {
                ++ans;
                if (x * x != gcd) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
