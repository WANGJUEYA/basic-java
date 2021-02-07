//有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请
//编写代码计算叠罗汉最多能叠几个人。 
//
// 示例： 
//
// 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
//输出：6
//解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190) 
//
//
// 提示： 
//
// 
// height.length == weight.length <= 10000 
// 
// Related Topics 排序 二分查找 动态规划


package com.jue.java.learn.leetcode.editor.cn.CircusTowerLcci;

import java.util.Arrays;

/**
 * @author JUE
 * @number 面试题 17.08
 */
public class CircusTowerLcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] h = {8378, 8535, 8998, 3766, 648, 6184, 5506, 5648, 3907, 6773};
        int[] w = {9644, 849, 3232, 3259, 5229, 314, 5593, 9600, 6695, 4340};
        int[] h1 = {2868, 5485, 1356, 1306, 6017, 8941, 7535, 4941, 6331, 6181};
        int[] w1 = {5042, 3995, 7985, 1651, 5991, 7036, 9391, 428, 7561, 8594};
        System.out.println(solution.bestSeqAtIndex(h1, w1));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        if (len <= 0) {
            return 0;
        }
        int[][] person = new int[len][2];
        for (int i = 0; i < len; i++) {
            person[i][0] = height[i];
            person[i][1] = weight[i];
        }
        Arrays.sort(person, (a, b) -> (a[0] - b[0]) * 10000 + (b[1] - a[1]));
        int max = 0;
        int[] dp = new int[len + 1]; // 盛放最优的最长增序列
        for (int index = 0; index < len; index++) {
            int i = 0, j = max, mid = (i + j) / 2;
            int that = person[index][1];
            // 二分查找法
            while (i < j) {
                if (dp[mid] < that) {
                    i = mid + 1;
                } else if (dp[mid] > that) {
                    j = mid - 1;
                } else {
                    i = mid;
                    j = mid;
                }
                mid = (i + j) / 2;
            }
            if (dp[mid] < that) {
                if (mid + 1 > max) {
                    max = mid + 1;
                    dp[max] = that;
                } else {
                    dp[mid + 1] = Math.min(dp[mid + 1], that);
                }
            } else if (dp[mid] > that) {
                dp[mid] = Math.min(dp[mid], that);
            }
//            System.out.println(Arrays.toString(dp));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
