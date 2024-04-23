//今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分
//钟结束后离开。
//
// 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一
//分钟的顾客就会不满意，不生气则他们是满意的。
//
// 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
//
// 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
//
//
// 示例：
//
// 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
//输出：16
//解释：
//书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
//
//
//
//
// 提示：
//
//
// 1 <= X <= customers.length == grumpy.length <= 20000
// 0 <= customers[i] <= 1000
// 0 <= grumpy[i] <= 1
//
// Related Topics 数组 Sliding Window


package com.jue.java.learn.leetcode.editor.cn.GrumpyBookstoreOwner;

/**
 * @author JUE
 * @number 1052
 */
public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(solution.maxSatisfied(customers, grumpy, 3)); // 16
        System.out.println(solution.maxSatisfied(new int[]{2, 6, 6, 9}, new int[]{0, 0, 1, 1}, 1)); // 17
        System.out.println(solution.maxSatisfied(new int[]{9, 10, 4, 5}, new int[]{1, 0, 1, 1}, 1)); // 19
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 直接采用滑动窗口识别最大的增加数量
        int base = 0;
        int max = 0;
        int plus = 0;
        for (int i = 0, len = grumpy.length; i < len; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
            // 当前单元格默认为控制冷静的最后一分钟
            if (grumpy[i] == 1) {
                plus += customers[i];
            }
            // 减去之前的记录
            int subIndex = i - X;
            if (subIndex >= 0) {
                if (grumpy[subIndex] == 1) {
                    plus -= customers[subIndex];
                }
            }
            max = Math.max(max, plus);
        }
        return base + max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
