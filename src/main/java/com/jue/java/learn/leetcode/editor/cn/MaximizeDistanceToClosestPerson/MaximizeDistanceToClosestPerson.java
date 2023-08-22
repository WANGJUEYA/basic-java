//给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标
//从 0 开始）。
//
// 至少有一个空座位，且至少有一人已经坐在座位上。
//
// 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
//
// 返回他到离他最近的人的最大距离。
//
//
//
// 示例 1：
//
//
//输入：seats = [1,0,0,0,1,0,1]
//输出：2
//解释：
//如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
//如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
//因此，他到离他最近的人的最大距离是 2 。
//
//
// 示例 2：
//
//
//输入：seats = [1,0,0,0]
//输出：3
//解释：
//如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
//这是可能的最大距离，所以答案是 3 。
//
//
// 示例 3：
//
//
//输入：seats = [0,1]
//输出：1
//
//
//
//
// 提示：
//
//
// 2 <= seats.length <= 2 * 10⁴
// seats[i] 为 0 或 1
// 至少有一个 空座位
// 至少有一个 座位上有人
//
//
// Related Topics 数组 👍 223 👎 0


package com.jue.java.learn.leetcode.editor.cn.MaximizeDistanceToClosestPerson;

/**
 * @author JUE
 * @number 849
 */
public class MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1})); // 2
        System.out.println(solution.maxDistToClosest(new int[]{1, 0, 0, 0})); // 3
        System.out.println(solution.maxDistToClosest(new int[]{0, 1})); // 1
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistToClosest(int[] seats) {
        // 找一个最大空格即可, 首位和末尾特殊处理
        int begin = 0;
        int end = 0;
        int max = 0;
        int len = seats.length;
        int lastIndex = 0;
        for (int index = 1; index < len; index++) {
            if (seats[index] == 1) {
                if (seats[lastIndex] == 0) {
                    // 结束计数
                    int count = index - lastIndex;
                    if (lastIndex == 0 && seats[lastIndex] == 0) {
                        begin = count;
                    }
                    max = Math.max(max, count);
                }
                // 移动位置，防止计数失败
                lastIndex = index;
            } else {
                if (seats[lastIndex] == 1) {
                    // 开始计数
                    lastIndex = index;
                }
                if (index == len - 1) {
                    end = len - lastIndex;
                }
                // 正常计数
            }
        }
        return Math.max(Math.max(begin, end), (max + 1) / 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
