//给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。 
//
//
// 如果有多个目标子集，返回其中任何一个均可。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2] (当然, [1,3] 也正确)
// 
//
// 示例 2: 
//
// 输入: [1,2,4,8]
//输出: [1,2,4,8]
// 
// Related Topics 数学 动态规划


package com.jue.java.learntest.leetcode.editor.cn.LargestDivisibleSubset;

import java.util.*;

/**
 * @author JUE
 * @number 368
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 3};
        int[] array1 = {4, 8, 10, 240};
        System.out.println(solution.largestDivisibleSubset(array1));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        int[] count = new int[len];
        int maxCountIndex = 0;
        List<Integer> temp;
        for (int i = 0; i < len; i++) {
            temp = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && map.get(nums[j]).size() > temp.size()) {
                    temp = new ArrayList<>(map.get(nums[j]));
                }
            }
            temp.add(nums[i]);
            if ((count[i] = temp.size()) > count[maxCountIndex]) {
                maxCountIndex = i;
            }
            map.put(nums[i], temp);
        }
        return map.get(nums[maxCountIndex]);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
