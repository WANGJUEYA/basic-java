//Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。 
//
// 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，
//返回 false 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
//输出：true
//解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。 
//
// 示例 2： 
//
// 
//输入：hand = [1,2,3,4,5], groupSize = 4
//输出：false
//解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。 
//
// 
//
// 提示： 
//
// 
// 1 <= hand.length <= 10⁴ 
// 0 <= hand[i] <= 10⁹ 
// 1 <= groupSize <= hand.length 
// 
//
// 
//
// 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-
//consecutive-numbers/ 
// Related Topics 贪心 数组 哈希表 排序 👍 195 👎 0


package com.jue.java.learn.leetcode.editor.cn.HandOfStraights;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 846
 */
public class HandOfStraights {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3)); // true
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4)); // false
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 1) {
            return true;
        }
        // 存储存储所有计数
        Map<Integer, Integer> count = new HashMap<>();
        for (int h : hand) {
            count.put(h, count.getOrDefault(h, 0) + 1);
        }
        // 当前需要的个数
        int need = 0;
        // 下一个需要减负的个数
        Map<Integer, Integer> sub = new HashMap<>();
        Integer[] number = count.keySet().toArray(new Integer[0]);
        Arrays.sort(number);
        for (int num : number) {
            int exist = count.getOrDefault(num, 0);
            if (exist < need) {
                return false;
            }
            if (exist > need) {
                sub.put(num + groupSize - 1, exist - need);
                need = exist;
            }
            if (sub.containsKey(num)) {
                need -= sub.get(num);
                sub.remove(num);
            }
            if (need < 0) {
                return false;
            }
        }
        return need == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


