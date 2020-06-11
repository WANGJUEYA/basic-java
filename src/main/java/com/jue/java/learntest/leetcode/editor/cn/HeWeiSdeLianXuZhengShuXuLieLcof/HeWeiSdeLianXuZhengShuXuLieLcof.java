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


package com.jue.java.learntest.leetcode.editor.cn.HeWeiSdeLianXuZhengShuXuLieLcof;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // 先计算每一个n项 n最大不超过 2*target 开方项
        Map<Integer, Integer> mules = new HashMap<>();
        int n = 1;
        do {
            n++;
            mules.put(n * (n - 1), n);
        } while (n * n < target * 2);
        // 等差方程 a1 + 0.5*n*(n-1) = target
        for (int index = 1; index < target; index++) {
            int mul = 2 * (target - index);
            if (mules.containsKey(mul)) {
                int num = mules.get(mul);
                int[] temp = new int[num];
                for (int j = 0, v = index; j < num; j++, v++) {
                    temp[j] = v;
                }
                list.add(temp);
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
