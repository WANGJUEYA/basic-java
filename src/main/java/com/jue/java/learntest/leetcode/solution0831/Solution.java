package com.jue.java.learntest.leetcode.solution0831;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).maskPII("LeetCode@LeetCode.com"));
        System.out.println((new Solution()).maskPII("AB@qq.com"));
        System.out.println((new Solution()).maskPII("86-(10)12345678"));
        System.out.println((new Solution()).maskPII("86-(10)12345678"));
    }

    public String maskPII(String S) {
        if (S.indexOf('@') > -1) {
            // ps: 如果只有一个字母为名字怎么办?
            String[] split = S.split("@");
            char begin = split[0].charAt(0);
            char end = split[0].charAt(split[0].length() - 1);
            begin = begin <= 'Z' ? (char) ('z' + begin - 'Z') : begin;
            end = end <= 'Z' ? (char) ('z' + end - 'Z') : end;
            return begin + "*****" + end + "@" + split[1].toLowerCase();
        } else {
            int count = 0;
            StringBuilder result = new StringBuilder();
            for (int index = S.length() - 1; index >= 0; index--) {
                if (S.charAt(index) >= '0' && S.charAt(index) <= '9') {
                    if (count < 4) {
                        result.insert(0, S.charAt(index));
                    } else if (count == 4 || count == 7 || count == 10) {
                        result.insert(0, "-");
                        result.insert(0, "*");
                    } else {
                        result.insert(0, "*");
                    }
                    count++;
                }
            }
            while (count < 9) {
                result.insert(0, "*");
                count++;
            }
            if (count > 10) {
                while (count <= 11) {
                    result.insert(0, "*");
                    count++;
                }
                result.insert(0, "+");
            }
            return result.toString();
        }
    }
}