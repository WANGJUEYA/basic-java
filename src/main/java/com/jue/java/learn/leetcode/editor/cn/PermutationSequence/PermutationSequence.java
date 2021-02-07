//给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 说明： 
//
// 
// 给定 n 的范围是 [1, 9]。 
// 给定 k 的范围是[1, n!]。 
// 
//
// 示例 1: 
//
// 输入: n = 3, k = 3
//输出: "213"
// 
//
// 示例 2: 
//
// 输入: n = 4, k = 9
//输出: "2314"
// 
// Related Topics 数学 回溯算法 
// 👍 350 👎 0


package com.jue.java.learn.leetcode.editor.cn.PermutationSequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 60
 */
public class PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 3));
        System.out.println(solution.getPermutation(4, 9));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 存储 (n ,n!)
    private static Map<Integer, Integer> cache = new HashMap<>() {{
        put(1, 1);
        put(2, 2);
        put(3, 6);
        put(4, 24);
        put(5, 120);
        put(6, 720);
        put(7, 5040);
        put(8, 40320);
        put(9, 362880);
    }};

    public String getPermutation(int n, int k) {
        // assert k < n!;
        if (n == 1) {
            // assert k == 1;
            return k + "";
        }
        used = new boolean[10];
        return getPermutationMine(n, k);
    }

    private static boolean[] used;

    public String getPermutationMine(int n, int k) {
        if (n == 0) {
            return "";
        }
        int firstIndex = 0;
        while (used[firstIndex]) {
            firstIndex++;
        }
        if (n == 1) {
            return (firstIndex + 1) + "";
        }
        // 当前位的内容
        int cri = cache.get(n - 1);
        while (k > cri) {
            k -= cri;
            // arrayOutException
            firstIndex++;
            while (used[firstIndex]) {
                firstIndex++;
            }
        }
        used[firstIndex] = true;
        String end = getPermutationMine(n - 1, k);
        return (firstIndex + 1) + end;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
