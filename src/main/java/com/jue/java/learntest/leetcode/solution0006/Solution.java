package com.jue.java.learntest.leetcode.solution0006;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).convert("LEETCODEISHIRING", 3));
        System.out.println((new Solution()).convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        int len = s.length();
        if (len <= 1 || numRows <= 1) {
            return s;
        }
        int sub = (numRows * 2 - 2);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i < len) {
                result.append(s.charAt(i));
            }
            int mid = sub - i;
            int j = i + sub;
            do {
                if (mid < len && i != 0 && i != numRows - 1) {
                    result.append(s.charAt(mid));
                }
                mid += sub;
                if (j < len) {
                    result.append(s.charAt(j));
                }
                j += sub;
            } while (mid < len);
        }
        return result.toString();
    }
}