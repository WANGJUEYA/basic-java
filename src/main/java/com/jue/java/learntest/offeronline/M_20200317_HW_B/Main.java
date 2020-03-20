package com.jue.java.learntest.offeronline.M_20200317_HW_B;

/**
 * @author JUE
 * @date 2020/3/16
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    /**
     * 日期转换: 给定哪年哪月第几周周几转出公历日期
     */
    public static void main(String[] args) {

//        for (int year = 2000; year < 2021; year++) {
//            for (int month = 1; month <= 12; month++) {
//                System.out.println((new M_20200317_HW_B()).function(year, month, 1, 1));
//            }
//        }
        System.out.println((new Main()).function(2018, 2, 3, 1));
//        System.out.println((new M_20200317_HW_B()).function(2018, 2, 8, 1));
//        for (int year = 2000; year < 2001; year++) {
//            for (int month = 1; month <= 12; month++) {
//                for (int week = 1; week <= 5; week++) {
//                    System.out.println((new M_20200317_HW_B()).function(year, month, week, 1));
//                }
//            }
//        }
//        System.out.println((new M_20200317_HW_B()).function(2000, 3, 2, 1));
        System.out.println((new Main()).function(2020, 3, 1, 7));
    }

    public String function(int year, int month, int week, int day) {
        String result = "0";
        // ps 每月最多有五周
        if (year < 2000 || year > 9999 || month < 1 || month > 12 || week < 1 || week > 5 || day < 1 || day > 7) {
            return result;
        }
        // 2000年1月1日 为周六
        // 开始计数 year-用来计算闰年(前面所有的天数)
        // month 用来计算当月的天数(前面所有天数)
        int days = 0;
        for (int y = 2000; y < year; y++) {
            days += daysWithYear(y);
        }
        for (int m = 1; m < month; m++) {
            days += daysWithYearAndMonth(year, m);
        }
        // 计算该月1日是周几
        days++;
        int monthFirstDay = (days % 7 + 5) % 7; // 1-周六 2-周天 3-周一...
        monthFirstDay = monthFirstDay == 0 ? 7 : monthFirstDay;
        // 计算天数在当月第几天
        int daysOfMonthToday = 1;
        for (int w = 1; w < week; w++) {
            daysOfMonthToday += 7;
        }
        daysOfMonthToday += (day - monthFirstDay);

        // 当月一共有多少天
        if (daysOfMonthToday <= 0 || daysOfMonthToday > daysWithYearAndMonth(year, month)) {
            return result;
        } else {
            // 补全日期
            return year + "-" + (month < 10 ? "0" + month : month) + "-" + (daysOfMonthToday < 10 ? "0" + daysOfMonthToday : daysOfMonthToday);
        }
    }

    // 是否闰年 闰年366
    public int daysWithYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0) ? 366 : 365;
    }

    // 返回某年某月有多少天
    public int daysWithYearAndMonth(int year, int month) {
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
                return daysWithYear(year) - 337;
            default:
                throw new IllegalArgumentException("illegal month!");
        }
    }
}
