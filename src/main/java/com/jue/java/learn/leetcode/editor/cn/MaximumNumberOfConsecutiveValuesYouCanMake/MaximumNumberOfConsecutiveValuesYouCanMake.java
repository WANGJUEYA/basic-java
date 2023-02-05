//给你一个长度为 n 的整数数组 coins ，它代表你拥有的 n 个硬币。第 i 个硬币的值为 coins[i] 。如果你从这些硬币中选出一部分硬币，它们的
//和为 x ，那么称，你可以 构造 出 x 。 
//
// 请返回从 0 开始（包括 0 ），你最多能 构造 出多少个连续整数。 
//
// 你可能有多个相同值的硬币。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1,3]
//输出：2
//解释：你可以得到以下这些值：
//- 0：什么都不取 []
//- 1：取 [1]
//从 0 开始，你可以构造出 2 个连续整数。 
//
// 示例 2： 
//
// 
//输入：coins = [1,1,1,4]
//输出：8
//解释：你可以得到以下这些值：
//- 0：什么都不取 []
//- 1：取 [1]
//- 2：取 [1,1]
//- 3：取 [1,1,1]
//- 4：取 [4]
//- 5：取 [4,1]
//- 6：取 [4,1,1]
//- 7：取 [4,1,1,1]
//从 0 开始，你可以构造出 8 个连续整数。 
//
// 示例 3： 
//
// 
//输入：nums = [1,4,10,3,1]
//输出：20 
//
// 
//
// 提示： 
//
// 
// coins.length == n 
// 1 <= n <= 4 * 10⁴ 
// 1 <= coins[i] <= 4 * 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 181 👎 0


package com.jue.java.learn.leetcode.editor.cn.MaximumNumberOfConsecutiveValuesYouCanMake;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 1798
 */
public class MaximumNumberOfConsecutiveValuesYouCanMake {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaximumConsecutive(new int[]{1, 3})); // 2
        System.out.println(solution.getMaximumConsecutive(new int[]{1, 1, 1, 4})); // 8
        System.out.println(solution.getMaximumConsecutive(new int[]{1, 4, 10, 3, 1})); // 20
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int getMaximumConsecutive(int[] coins) {
        // 方法超时
        // return getMaximumConsecutiveTimeOut(coins);
        // 使用贪心算法: 数学逻辑, 已经构成了 [0, x]的整数序列, 新加入的y 可以构成 [y, x+y]整数序列, 如果y<=x+1, 则扩展成 [0, x+y]连续序列
        int result = 1; // x+1, [0,0]是起始值
        // 排序, 从较小的计算, 排序提供新思路
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > result) {
                break;
            }
            result += coin;
        }
        return result;
    }

    public int getMaximumConsecutiveTimeOut(int[] coins) {
        Map<Integer, Integer> countOfCoins = new HashMap<>();
        for (int coin : coins) {
            countOfCoins.put(coin, countOfCoins.getOrDefault(coin, 0) + 1);
        }
        // 肯定有上限, 硬币的数量
        int count = 1;
        while (true) {
            if (find(countOfCoins, count)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }


    public boolean find(Map<Integer, Integer> countOfCoins, int number) {
        if (countOfCoins.getOrDefault(number, 0) > 0) {
            return true;
        }
        for (int index = 1; index < (number / 2) + 1; index++) {
            if (countOfCoins.getOrDefault(index, 0) > 0) {
                Map<Integer, Integer> copy = new HashMap<>(countOfCoins);
                copy.put(index, copy.get(index) - 1);
                if (find(copy, number - index)) {
                    return true;
                }
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
