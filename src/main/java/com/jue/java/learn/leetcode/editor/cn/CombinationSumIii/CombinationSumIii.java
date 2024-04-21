//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法


package com.jue.java.learn.leetcode.editor.cn.CombinationSumIii;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @number 216
 */
public class CombinationSumIii {
    public static void main(String[] args) {
        // 用二进制子集枚举
        // 如果用组合枚举，相关path可以每次单独清空，不需要新建数组
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 7)); // [[1,2,4]]
        System.out.println(solution.combinationSum3(3, 9)); // [[1,2,6], [1,3,5], [2,3,4]]
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(result, new ArrayList<>(), k, n);
        return result;
    }

    protected void combinationSum3(List<List<Integer>> result, List<Integer> before, int k, int n) {
        if (k == 1) {
            if (n > before.get(0) && n <= 9) {
                before.add(0, n);
                result.add(before);
            }
            return;
        }
        for (int i = (before.isEmpty() ? 0 : before.get(0)) + 1; i < n; i++) {
            List<Integer> newPath = new ArrayList<>(before);
            newPath.add(0, i);
            combinationSum3(result, newPath, k - 1, n - i);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
