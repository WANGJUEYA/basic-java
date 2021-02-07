//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针


package com.jue.java.learn.leetcode.editor.cn.SortedMergeLcci;

import java.util.Arrays;

/**
 * @author JUE
 * @number 面试题 10.01
 */
public class SortedMergeLcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{1, 2, 3, 0, 0, 0};
        int[] B = new int[]{2, 5, 6};
        solution.merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 时间复杂度 O(m+n) 空间复杂度 O(1)
    public void merge(int[] A, int m, int[] B, int n) {
        // 归并排序法
        int indexA = m - 1;
        int indexB = n - 1;
        int index = m + n - 1;
        while (indexA >= 0 && indexB >= 0) {
            A[index--] = (A[indexA] > B[indexB]) ? (A[indexA--]) : (B[indexB--]);
        }
        while (indexA >= 0) {
            A[index--] = A[indexA--];
        }
        while (indexB >= 0) {
            A[index--] = B[indexB--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
