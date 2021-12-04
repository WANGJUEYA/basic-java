//小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，画板不能转动。画板上有 `n * n` 的网格。绘画规则为，小扣
//可以选择任意多行以及任意多列的格子涂成黑色（选择的整行、整列均需涂成黑色），所选行数、列数均可为 0。
//
//小扣希望最终的成品上需要有 `k` 个黑色格子，请返回小扣共有多少种涂色方案。
//
//注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。
//
//**示例 1：**
//>输入：`n = 2, k = 2`
//>
//>输出：`4`
//> 
//>解释：一共有四种不同的方案：
//>第一种方案：涂第一列；
//>第二种方案：涂第二列；
//>第三种方案：涂第一行；
//>第四种方案：涂第二行。
//
//**示例 2：**
//>输入：`n = 2, k = 1`
//> 
//>输出：`0`
//> 
//>解释：不可行，因为第一次涂色至少会涂两个黑格。
//
//**示例 3：**
//>输入：`n = 2, k = 4`
//> 
//>输出：`1`
//>
//>解释：共有 2*2=4 个格子，仅有一种涂色方案。
//
//**限制：**
//- `1 <= n <= 6`
//- `0 <= k <= n * n`
//
//
// Related Topics 数学 👍 59 👎 0


package com.jue.java.learn.leetcode.editor.cn.Ccw6C7;

/**
 * @author JUE
 * @number LCP 22
 */
public class Ccw6C7 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.paintingPlan(2, 2));
        System.out.println(solution.paintingPlan(2, 1));
        System.out.println(solution.paintingPlan(2, 4));
        System.out.println(solution.paintingPlan(3, 8));
        System.out.println(solution.paintingPlan(4, 12));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int C(int m, int n) {
        // 求出组合数(是否有公式?)
        int molecule = 1;
        int denominator = 1;
        for (int index = 0; index < n; index++) {
            molecule *= (m - index);
            denominator *= (1 + index);
        }
        /// System.out.println("C(" + m + "," + n + ")=" + (molecule / denominator));
        return molecule / denominator;
    }

    public int paintingPlan(int n, int k) {
        if (k == 0) {
            return 1;
        }
        // 枚举遍历法
        int max;
        if (k < n || k > (max = n * n)) {
            return 0;
        }
        if (k == max) {
            return 1;
        }
        // 如果能整除; 计算排列组合 FIXME 改情况即后面 取值0的数据 [但是此方法更优秀]
        int result = 0;
        if (k % n == 0) {
            result += (2 * C(n, k / n));
        }
        // 如果不能整除; 开始计算该色块能不能涂出
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                /// System.out.println("k(" + row + "," + col + ")=" + (n * (row + col) - row * col));
                if (k == n * (row + col) - row * col) {
                    result += C(n, row) * C(n, col);
                }
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

