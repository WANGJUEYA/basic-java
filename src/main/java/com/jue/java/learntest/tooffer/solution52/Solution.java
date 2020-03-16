package com.jue.java.learntest.tooffer.solution52;

public class Solution {
    public static void main(String[] args) {
        //System.out.println((new Solution()).LeftRotateString("abcXYZdef", 3));
        System.out.println((new SolutionPerfect()).LeftRotateString("abcXYZdef", 3));
    }

    public String LeftRotateString(String str, int n) {
        if (null == str || str.length() <= 0) {
            return str;
        }
        int count = n % (str.length());
        return str.substring(count) +
                str.substring(0, count);
    }
}

class SolutionPerfect {
    public String LeftRotateString(String str, int n) {
        int len;
        if (null == str || (len = str.length()) <= 0) {
            return str;
        }
        int count = n % len;
        str += str;
        return str.substring(count, count + len);
    }
}