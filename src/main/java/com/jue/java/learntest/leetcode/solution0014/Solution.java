package com.jue.java.learntest.leetcode.solution0014;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        int count = 0;
        boolean flag = true;
        StringBuilder result = new StringBuilder();
        while (flag) {
            Character temp = null;
            for (String s : strs) {
                if (count >= s.length() || (temp != null && temp != s.charAt(count))) {
                    flag = false;
                    break;
                }
                temp = s.charAt(count);
            }
            count++;
            if (flag) {
                result.append(temp);
            }
        }
        return result.toString();
    }
}