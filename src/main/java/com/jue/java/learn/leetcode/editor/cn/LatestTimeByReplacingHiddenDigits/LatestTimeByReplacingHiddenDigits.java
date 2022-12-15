//给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
//
// 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
//
// 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
//
//
//
// 示例 1：
//
//
//输入：time = "2?:?0"
//输出："23:50"
//解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
//
//
// 示例 2：
//
//
//输入：time = "0?:3?"
//输出："09:39"
//
//
// 示例 3：
//
//
//输入：time = "1?:22"
//输出："19:22"
//
//
//
//
// 提示：
//
//
// time 的格式为 hh:mm
// 题目数据保证你可以由输入的字符串生成有效的时间
//
//
// Related Topics 贪心 字符串 👍 63 👎 0


package com.jue.java.learn.leetcode.editor.cn.LatestTimeByReplacingHiddenDigits;

/**
 * @author JUE
 * @number 1736
 */
public class LatestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumTime("2?:?0")); // 23:50
        System.out.println(solution.maximumTime("?4:03")); // 14:03
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String maximumTime(String time) {
        char[] t = new char[]{time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4)};
        char questionMark = '?';
        if (t[0] == questionMark) {
            t[0] = (t[1] == questionMark || t[1] < '4') ? '2' : '1';
        }
        if (t[1] == questionMark) {
            t[1] = t[0] == '2' ? '3' : '9';
        }
        if (t[2] == questionMark) {
            t[2] = '5';
        }
        if (t[3] == questionMark) {
            t[3] = '9';
        }
        return t[0] + "" + t[1] + ":" + t[2] + "" + t[3];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
