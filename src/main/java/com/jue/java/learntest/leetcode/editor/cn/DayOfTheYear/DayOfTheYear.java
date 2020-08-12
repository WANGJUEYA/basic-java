//给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。 
//
// 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。 
//
// 
//
// 示例 1： 
//
// 输入：date = "2019-01-09"
//输出：9
// 
//
// 示例 2： 
//
// 输入：date = "2019-02-10"
//输出：41
// 
//
// 示例 3： 
//
// 输入：date = "2003-03-01"
//输出：60
// 
//
// 示例 4： 
//
// 输入：date = "2004-03-01"
//输出：61 
//
// 
//
// 提示： 
//
// 
// date.length == 10 
// date[4] == date[7] == '-'，其他的 date[i] 都是数字。 
// date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。 
// 
// Related Topics 数学 
// 👍 25 👎 0


package com.jue.java.learntest.leetcode.editor.cn.DayOfTheYear;

/**
 * @author JUE
 * @number 1154
 */
public class DayOfTheYear {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfYear("2020-01-01"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));

        int count = Integer.parseInt(date.substring(8, 10));
        for (int i = 1; i < month; i++) {
            count += getDay(year, i);
        }
        return count;
    }

    private int getDay(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return year % 4 == 0 && (year % 400 == 0 || year % 100 != 0) ? 29 : 28;
            default:
                throw new IllegalArgumentException(month + "is not right month");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
