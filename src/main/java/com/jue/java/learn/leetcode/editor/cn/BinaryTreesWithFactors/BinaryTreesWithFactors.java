//给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。 
//
// 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。 
//
// 满足条件的二叉树一共有多少个？答案可能很大，返回 对 10⁹ + 7 取余 的结果。 
//
// 
//
// 示例 1: 
//
// 
//输入: arr = [2, 4]
//输出: 3
//解释: 可以得到这些二叉树: [2], [4], [4, 2, 2] 
//
// 示例 2: 
//
// 
//输入: arr = [2, 4, 5, 10]
//输出: 7
//解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]. 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 2 <= arr[i] <= 10⁹ 
// arr 中的所有值 互不相同 
// 
//
// Related Topics 数组 哈希表 动态规划 排序 👍 196 👎 0


package com.jue.java.learn.leetcode.editor.cn.BinaryTreesWithFactors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 823
 */
public class BinaryTreesWithFactors {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numFactoredBinaryTrees(new int[]{2, 4})); // 3
        System.out.println(solution.numFactoredBinaryTrees(new int[]{2, 4, 5, 10})); // 7
        System.out.println(solution.numFactoredBinaryTrees(new int[]{18, 3, 6, 2})); // 12
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final Integer MOD = (int) (1E9 + 7);

    public int numFactoredBinaryTrees(int[] arr) {
        // 数据排序
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();
        long result = 0;
        for (int a : arr) {
            long sum = 1;
            for (int l : dp.keySet()) {
                if (a % l == 0) {
                    int r = a / l;
                    if (dp.containsKey(r)) {
                        sum = (sum + dp.get(l) * dp.get(r)) % MOD;
                    }
                }
            }
            dp.put(a, sum);
            result = (result + sum) % MOD;
        }
        return (int) result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
