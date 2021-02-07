//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
// Related Topics 位运算 数组 分治算法


package com.jue.java.learn.leetcode.editor.cn.MajorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 169
 */
public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxKey = 0;
        int maxValue = -1;
        for (int item : nums) {
            int tempValue = 1;
            if (map.containsKey(item)) {
                tempValue = map.get(item) + 1;
            }
            if (tempValue > nums.length / 2) {
                return item;
            }
            if (tempValue > maxValue) {
                maxKey = item;
                maxValue = tempValue;
            }
            map.put(item, tempValue);
        }
        return maxValue > nums.length / 2 ? maxKey : -1; // -1表示不存在多数元素
    }

}
//leetcode submit region end(Prohibit modification and deletion)

