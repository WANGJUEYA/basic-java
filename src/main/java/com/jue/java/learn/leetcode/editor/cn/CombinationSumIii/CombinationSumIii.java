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
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 7));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(0, 1, k, n);
    }

    public List<List<Integer>> combinationSum3(int last, int len, int k, int n) {
//        System.out.println("(last,len,k,n) => " + last + "," + len + "," + k + "," + n);
        List<List<Integer>> result = new ArrayList<>();
        if (len > k) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        if (len == k && last < n && n >= 1 && n <= 9) {
            temp.add(n);
            result.add(temp);
            return result;
        }
        for (int index = last + 1; index < 10 && index <= n; index++) {
            List<List<Integer>> sub = combinationSum3(index, len + 1, k, n - index);
//            System.out.println(sub);
            for (List<Integer> s : sub) {
                s.add(index);
                result.add(s);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
