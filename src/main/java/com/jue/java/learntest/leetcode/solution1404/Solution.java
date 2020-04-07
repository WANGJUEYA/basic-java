package com.jue.java.learntest.leetcode.solution1404;

class Solution {
    // 位运算? 如果0 结尾右移一次, 如果1结尾 加1再操作
    public int numSteps(String s) {
        int count = 0;
        while ('0' == s.charAt(s.length() - 1)) {
            // 去除末尾, 计数器加一
            s = s.substring(0, s.length() - 1);
            count++;
        }
        int len = s.length();
        if (len <= 1) {
            return count;
        }
        // 末尾为1
        char[] chars = s.toCharArray();
        int index = len - 1;
        boolean hasUpdate = true;
        while (index >= 0 && hasUpdate) {
            if ('1' == chars[index]) {
                chars[index] = '0';
                hasUpdate = true;
            } else {
                chars[index] = '1';
                hasUpdate = false;
            }
            index--;
        }
        s = (hasUpdate ? "1" : "") + String.valueOf(chars);
        return count + 1 + numSteps(s);
    }
}