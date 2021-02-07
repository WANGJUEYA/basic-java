//你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。 
//
// 给定一个数字 n，找出可形成完整阶梯行的总行数。 
//
// n 是一个非负整数，并且在32位有符号整型的范围内。 
//
// 示例 1: 
//
// 
//n = 5
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤
//
//因为第三行不完整，所以返回2.
// 
//
// 示例 2: 
//
// 
//n = 8
//
//硬币可排列成以下几行:
//¤
//¤ ¤
//¤ ¤ ¤
//¤ ¤
//
//因为第四行不完整，所以返回3.
// 
// Related Topics 数学 二分查找 
// 👍 80 👎 0


package com.jue.java.learn.leetcode.editor.cn.ArrangingCoins;

/**
 * @author JUE
 * @number 441
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.arrangeCoins(0));
//        System.out.println(solution.arrangeCoins(1));
//        System.out.println(solution.arrangeCoins(8));
//        System.out.println(solution.arrangeCoins(3));
//        System.out.println(solution.arrangeCoins(5));
        System.out.println(solution.arrangeCoins(1804289383));
        System.out.println(solution.arrangeCoins(2147483647));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrangeCoins(int n) {
        if (n <= 1) {
            return n;
        }
        // sum = (1 + n) * n / 2
        double i = Math.sqrt(n * 2.0);
        int max = (int) Math.ceil(i);
        boolean flag = max % 2 == 0;
        double sum = flag ? (1 + max) * (max / 2.0) : (1 + max) / 2.0 * max;
        while (sum > n) {
            max--;
            flag = !flag;
            sum = flag ? (1 + max) * (max / 2.0) : (1 + max) / 2.0 * max;
        }
        return max;
    }

    /*
    public int arrangeCoins(int n) {
        // sum = (1 + n) * n / 2
        boolean flag = true;
        for (int i = 0; i <= n; i++) {
            long sum = flag ? (1 + i) * (i / 2) : (1 + i) / 2 * i;
            flag = !flag;
            if (sum == n) {
                return i;
            } else if (sum > n) {
                return i - 1;
            }
        }
        return 0;
    }
    */
}
//leetcode submit region end(Prohibit modification and deletion)
