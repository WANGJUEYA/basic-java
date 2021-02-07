//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
//


package com.jue.java.learn.leetcode.editor.cn.HeWeiSdeLianXuZhengShuXuLieLcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @number 面试题57 - II
 */
public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = solution.findContinuousSequence(15);
        System.out.println(array);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        if (target <= 2) {
            return new int[0][0];
        }
        // a1*n+[n*(n-1)*d]/2  (a1 + an) * n / 2 = target
        for (int index = 1; index <= target / 2; index++) {
            int sum = index;
            for (int j = index + 1; sum <= target; j++) {
                if (sum == target) {
                    int[] temp = new int[j - index];
                    int i = index;
                    int top = 0;
                    while (i < j) {
                        temp[top++] = i++;
                    }
                    list.add(temp);
                }
                sum += j;
            }
        }
        int[][] result = new int[list.size()][];
        int index = 0;
        for (int[] item : list) {
            result[index++] = item;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
