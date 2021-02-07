//给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [5,5,4], k = 1
//输出：1
//解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
// 
//
// 示例 2： 
//
// 输入：arr = [4,3,1,1,3,3,2], k = 3
//输出：2
//解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// 1 <= arr[i] <= 10^9 
// 0 <= k <= arr.length 
// 
// Related Topics 排序 数组


package com.jue.java.learn.leetcode.editor.cn.LeastNumberOfUniqueIntegersAfterKRemovals;

import java.util.*;

/**
 * @author JUE
 * @number 5437
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int len = arr.length;
        if (len == 0 || k >= len) {
            return 0;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr) {
            if (count.containsKey(a)) {
                count.put(a, count.get(a) + 1);
            } else {
                count.put(a, 1);
            }
        }
        List<Integer> c = new ArrayList<>(count.values());
        Collections.sort(c);
        int index = 0;
        while (k > 0) {
            int temp = c.get(index);
            if (temp > k) {
                break;
            } else {
                k -= temp;
                index++;
            }
        }
        return c.size() - index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
