package com.jue.java.learntest.leetcode.solution0151;

class Solution {
    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        String[] split = s.split(" ");
        int index = split.length;
        boolean first = true;
        StringBuilder str = new StringBuilder();
        while (--index >= 0) {
            if (!"".equals(split[index])) {
                if (first) {
                    first = false;
                } else {
                    str.append(" ");
                }
                str.append(split[index]);
            }
        }
        return str.toString();
    }
}