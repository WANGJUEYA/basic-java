//有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。 
//
// 跳蚤跳跃的规则如下： 
//
// 
// 它可以 往前 跳恰好 a 个位置（即往右跳）。 
// 它可以 往后 跳恰好 b 个位置（即往左跳）。 
// 它不能 连续 往后跳 2 次。 
// 它不能跳到任何 forbidden 数组中的位置。 
// 
//
// 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。 
//
// 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃
//次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
//输出：3
//解释：往前跳 3 次（0 -> 3 -> 6 -> 9），跳蚤就到家了。
// 
//
// 示例 2： 
//
// 
//输入：forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
//输出：2
//解释：往前跳一次（0 -> 16），然后往回跳一次（16 -> 7），跳蚤就到家了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= forbidden.length <= 1000 
// 1 <= a, b, forbidden[i] <= 2000 
// 0 <= x <= 2000 
// forbidden 中所有位置互不相同。 
// 位置 x 不在 forbidden 中。 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 188 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumJumpsToReachHome;

import java.util.*;

/**
 * @author JUE
 * @number 1654
 */
public class MinimumJumpsToReachHome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumJumps(new int[]{1998}, 1999, 2000, 2000));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // 0 表示 未处理，1表示已到达，-1表示不可到达
        int lower = 0;
        Set<Integer> forbiddenSet = new HashSet<>();
        // 计算最大数据的逻辑没有看懂
        int upper = Math.max(Arrays.stream(forbidden).peek(forbiddenSet::add).max().getAsInt() + a, x) + b;
        // 问题在于正向来的方向和逆向来的方向路程不同
        Set<Integer> cross = new HashSet<>();

        // 不能用栈，必须用队列
        Queue<int[]> queue = new ArrayDeque<>();
        // 1 上一个方向是正向；后面一个是当前的位置；最后一位是当前跳跃的次数
        queue.add(new int[]{1, 0, 0});
        // 二叉树广度遍历，每一个左边来的节点都没有右子树
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (x == current[1]) {
                return current[2];
            }
            // 向右跳
            int right = current[1] + a;
            if (right <= upper && !forbiddenSet.contains(right) && !cross.contains(right)) {
                queue.add(new int[]{1, right, current[2] + 1});
                cross.add(right);
            }
            // 不能连续两次倒退
            int left = current[1] - b;
            if (current[0] == 1 && left >= 0 && !forbiddenSet.contains(left) && !cross.contains(-1 * left)) {
                queue.add(new int[]{0, left, current[2] + 1});
                cross.add(-1 * left);
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
