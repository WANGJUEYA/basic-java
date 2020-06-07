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


package com.jue.java.learntest.leetcode.editor.cn.GrumpyBookstoreOwner;

/**
 * @author JUE
 * @number 1052
 */
public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println(solution.maxSatisfied(customers, grumpy, 3));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 可以采用滑动窗口的方式
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int sum = 0;
        int max = 0;
        for (int index = 0; index < len; index++) {
            // 正常营业
            if (grumpy[index] == 0) {
                sum += customers[index];
            } else {
                int tempMax = customers[index];
                for (int j = index + 1; j < (index + X) && j < len; j++) {
                    if (grumpy[j] == 1) {
                        tempMax += customers[j];
                    }
                }
                max = Math.max(max, tempMax);
            }
        }
        return sum + max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
