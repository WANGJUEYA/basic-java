//你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
//
//
// difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
// worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
//
//
// 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
//
//
// 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
//
//
// 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
//
//
//
// 示例 1：
//
//
//输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
//输出: 100
//解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
//
// 示例 2:
//
//
//输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
//输出: 0
//
//
//
// 提示:
//
//
// n == difficulty.length
// n == profit.length
// m == worker.length
// 1 <= n, m <= 10⁴
// 1 <= difficulty[i], profit[i], worker[i] <= 10⁵
//
//
// Related Topics 贪心 数组 双指针 二分查找 排序 👍 141 👎 0


package com.jue.java.learn.leetcode.editor.cn.MostProfitAssigningWork;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 826
 */
public class MostProfitAssigningWork {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7})); // 100
//        System.out.println(solution.maxProfitAssignment(new int[]{85, 47, 57}, new int[]{24, 66, 99}, new int[]{40, 25, 25})); // 0
        System.out.println(solution.maxProfitAssignment(new int[]{68, 35, 52, 47, 86}, new int[]{67, 17, 1, 81, 3}, new int[]{92, 10, 85, 84, 82})); // 324
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int len = difficulty.length;
        Map<Integer, Integer> store = new HashMap<>(len);
        store.put(0, 0);
        for (int i = 0; i < len; i++) {
            store.put(difficulty[i], Math.max(store.getOrDefault(difficulty[i], 0), profit[i]));
        }
        Integer[] difficultyKeys = store.keySet().stream().sorted().toArray(Integer[]::new);
        len = difficultyKeys.length;
        for (int i = 1; i < len; i++) {
            store.put(difficultyKeys[i], Math.max(store.get(difficultyKeys[i]), store.get(difficultyKeys[i - 1])));
        }

        int result = 0;
        for (int w : worker) {
            if (!store.containsKey(w)) {
                // 通过二分查找找到小于当前能力的最大收入
                int low = 0, high = len - 1;
                while (low < high) {
                    int mid = (low + high + 1) / 2;
                    if (difficultyKeys[mid] <= w) {
                        low = mid;
                        if (difficultyKeys[mid] == w) {
                            break;
                        }
                    } else {
                        high = mid - 1;
                    }
                }
                store.put(w, store.get(difficultyKeys[low]));
            }
            result += store.get(w);
        }
        return result;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
//leetcode submit region end(Prohibit modification and deletion)
