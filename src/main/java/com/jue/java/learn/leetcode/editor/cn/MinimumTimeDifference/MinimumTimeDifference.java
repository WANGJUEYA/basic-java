//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints.length <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 数组 数学 字符串 排序 👍 172 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumTimeDifference;

import org.python.google.common.collect.Lists;

import java.util.List;

/**
 * @author JUE
 * @number 539
 */
public class MinimumTimeDifference {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinDifference(Lists.newArrayList("23:59", "00:00"))); // 1
        System.out.println(solution.findMinDifference(Lists.newArrayList("00:00", "23:59", "00:00"))); // 0
        System.out.println(solution.findMinDifference(Lists.newArrayList("00:00", "04:00", "22:00"))); // 120
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    Integer minMinute;

    public int findMinDifference(List<String> timePoints) {
        minMinute = Integer.MAX_VALUE;
        // 按照时间从小到大排序 同时计算两个时间的相差
        timePoints.sort(this::diff);
        // 再追加比较第一个和最后一个
        diff(timePoints.get(0), timePoints.get(timePoints.size() - 1));
        return minMinute;
    }

    private int diff(String a, String b) {
        int diff = minute(a) - minute(b);
        int count = Math.abs(diff);
        int result = Math.min(count, 1440 - count);
        minMinute = Math.min(minMinute, result);
        // System.out.println("a:" + a + ",b:" + b + ",diff=" + result);
        return diff;
    }

    private int minute(String time) {
        String[] times = time.split(":");
        return 60 * Integer.parseInt(times[0]) + Integer.parseInt(times[1]);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
