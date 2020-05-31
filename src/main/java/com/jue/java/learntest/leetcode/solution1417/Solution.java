package com.jue.java.learntest.leetcode.solution1417;

import java.util.Arrays;

class Solution {
    public String reformat(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        // 暴力拼接 假定总是以字母开头，偶数总能匹配，奇数字母较多可，数字较多拼接在串首
        char[] temp = new char[len];
        int indexAz = 0;
        int index09 = 1;
        char last09 = ' ';
        for (int index = 0; index < len; index++) {
            char c = s.charAt(index);
            if (c >= 'a' && c <= 'z') {
                if (indexAz < len) {
                    temp[indexAz] = c;
                    indexAz += 2;
                } else {
                    return "";
                }
            } else if (c >= '0' && c <= '9') {
                if (index09 < len) {
                    temp[index09] = c;
                    index09 += 2;
                } else if (len % 2 == 1 && index09 == len) {
                    last09 = c;
                    index09 += 2;
                } else {
                    return "";
                }
            } else {
                return "";
            }

        }
        if (len % 2 == 0) {
            if (indexAz == len && index09 == len + 1) {
                return String.valueOf(temp);
            }
        } else {
            if (indexAz == len + 1) {
                if (index09 == len) {
                    return String.valueOf(temp);
                }
            } else if (indexAz == len - 1) {
                if (index09 == len + 2) {
                    return last09 + String.valueOf(Arrays.copyOf(temp, len - 1));
                }
            }
        }
        return "";
    }
}