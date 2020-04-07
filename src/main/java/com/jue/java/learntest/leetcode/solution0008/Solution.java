package com.jue.java.learntest.leetcode.solution0008;

class Solution {
    public static void main(String[] args) {
//        System.out.println((new Solution()).myAtoi("42"));
//        System.out.println((new Solution()).myAtoi("-000000000000001"));
        System.out.println((new Solution()).myAtoi("2147483648"));
    }

    public int myAtoi(String str) {
        int len = str.length();
        if (len <= 0) {
            return 0;
        }
        int index = 0;
        while (index < len && ' ' == str.charAt(index)) {
            index++;
        }
        int flag = 1;
        if (index < len && ('-' == str.charAt(index) || '+' == str.charAt(index))) {
            if ('-' == str.charAt(index)) {
                flag = -1;
            }
            index++;
        }
        int result = 0;
        int count = 0;
        while (index < len && '0' <= str.charAt(index) && '9' >= str.charAt(index)) {
            int temp = str.charAt(index) - '0';
            if (count > 8) {
                if (flag > 0) {
                    if (Integer.MAX_VALUE / 10 >= result && Integer.MAX_VALUE > temp) {
                        result = result * 10 + temp;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (Integer.MIN_VALUE / 10 <= -result && Integer.MAX_VALUE + result * 10 < -temp) {
                        result = result * 10 + temp;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                result = result * 10 + temp;
            }
            if (count > 0 || result > 0) count++;
            index++;
        }
        return flag * result;
    }
}