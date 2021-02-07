//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针


package com.jue.java.learn.leetcode.editor.cn.TrappingRainWater;

/**
 * @author JUE
 * @number 42
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 本例相关例题->接雨水2 可采用相同思路，一遍一遍遍历到等高
    // 但作为一维数组，优秀解法，先找到最高的柱子再向两边扩展[参考]
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 0) {
            return len;
        }
        int indexHighest = 0;
        for (int index = 1; index < len; index++) {
            if (height[index] > height[indexHighest]) {
                indexHighest = index;
            }
        }

        int count = 0;
        for (int index = 1; index < indexHighest; index++) {
            if (height[index] < height[index - 1]) {
                count += height[index - 1] - height[index];
                height[index] = height[index - 1];
            }
        }
        for (int index = len - 2; index > indexHighest; index--) {
            if (height[index] < height[index + 1]) {
                count += height[index + 1] - height[index];
                height[index] = height[index + 1];
            }
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
