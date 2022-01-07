//给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。 
//
// 输入为三个整数：day、month 和 year，分别表示日、月、年。 
//
// 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", 
//"Friday", "Saturday"}。 
//
// 
//
// 示例 1： 
//
// 输入：day = 31, month = 8, year = 2019
//输出："Saturday"
// 
//
// 示例 2： 
//
// 输入：day = 18, month = 7, year = 1999
//输出："Sunday"
// 
//
// 示例 3： 
//
// 输入：day = 15, month = 8, year = 1993
//输出："Sunday"
// 
//
// 
//
// 提示： 
//
// 
// 给出的日期一定是在 1971 到 2100 年之间的有效日期。 
// 
// Related Topics 数学 👍 49 👎 0


package com.jue.java.learn.leetcode.editor.cn.DayOfTheWeek;

/**
 * @author JUE
 * @number 1185
 */
public class DayOfTheWeek {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dayOfTheWeek(1, 1, 1971)); // Friday
        System.out.println(solution.dayOfTheWeek(31, 8, 2019)); // Saturday
        System.out.println(solution.dayOfTheWeek(18, 7, 1999)); // Sunday
        System.out.println(solution.dayOfTheWeek(15, 8, 1993)); // Sunday
        System.out.println(solution.dayOfTheWeek(29, 2, 2016)); // Monday
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        // 1971-01-01 星期五 1971不是闰年 1972是闰年
        // 计算一共有多少个闰年 四年一个闰年
        int diffYear = year - 1971;
        int leadNum = diffYear / 4;
        // 除了当前以外的闰年
        if (diffYear % 4 > 1) {
            leadNum++;
        }
        int total = diffYear * 365 + leadNum;
        // 计算月份
        for (int m = 1; m < month; m++) {
            int diffMonth = 0;
            switch (m) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    diffMonth = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    diffMonth = 30;
                    break;
                //闰年 能被四整除但不能被一百整除, 能被四百整除
                case 2:
                    diffMonth = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? 29 : 28;
                    break;
                default:
                    System.out.println("month [" + m + "] is not exist!");

            }
            total += diffMonth;
        }
        total += day;
        String[] week = new String[]{"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        return week[total % 7];
    }


}
//leetcode submit region end(Prohibit modification and deletion)


