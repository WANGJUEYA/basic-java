//给你一个字符串 s，表示一个 12 小时制的时间格式，其中一些数字（可能没有）被 "?" 替换。 
//
// 12 小时制时间格式为 "HH:MM" ，其中 HH 的取值范围为 00 至 11，MM 的取值范围为 00 至 59。最早的时间为 00:00，最晚的时
//间为 11:59。 
//
// 你需要将 s 中的 所有 "?" 字符替换为数字，使得结果字符串代表的时间是一个 有效 的 12 小时制时间，并且是可能的 最晚 时间。 
//
// 返回结果字符串。 
//
// 
//
// 示例 1： 
//
// 
// 输入： s = "1?:?4" 
// 
//
// 输出： "11:54" 
//
// 解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "11:54"。 
//
// 示例 2： 
//
// 
// 输入： s = "0?:5?" 
// 
//
// 输出： "09:59" 
//
// 解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "09:59"。 
//
// 
//
// 提示： 
//
// 
// s.length == 5 
// s[2] 是字符 ":" 
// 除 s[2] 外，其他字符都是数字或 "?" 
// 输入保证在替换 "?" 字符后至少存在一个介于 "00:00" 和 "11:59" 之间的时间。 
// 
//
// Related Topics 字符串 枚举 👍 0 👎 0


package com.jue.java.learn.leetcode.editor.cn.LatestTimeYouCanObtainAfterReplacingCharacters;

import java.util.Objects;

/**
 * @author JUE
 * @number 3114
 */
public class LatestTimeYouCanObtainAfterReplacingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLatestTime(String s) {
        String[] split = s.split(":");
        // 12小时制
        if (Objects.equals(split[0], "??")) {
            split[0] = "11";
        } else if (split[0].charAt(0) == '?') {
            char char1 = split[0].charAt(1);
            if (char1 > '1') {
                split[0] = "0" + char1;
            } else {
                split[0] = "1" + char1;
            }
        } else if (split[0].charAt(1) == '?') {
            char char0 = split[0].charAt(0);
            if (char0 == '0') {
                split[0] = char0 + "9";
            } else {
                split[0] = char0 + "1";
            }
        }


        if (Objects.equals(split[1], "??")) {
            split[1] = "59";
        } else if (split[1].charAt(0) == '?') {
            char char1 = split[1].charAt(1);
            split[1] = "5" + char1;
        } else if (split[1].charAt(1) == '?') {
            char char0 = split[1].charAt(0);
            split[1] = char0 + "9";
        }

        return split[0] + ":" + split[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
