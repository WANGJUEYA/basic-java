package com.jue.java.learn.tooffer.solution55;

public class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).ReverseSentence("student. a am I"));
    }

    public String ReverseSentence(String str) {
        int len;
        if (null == str || (len = str.length()) <= 0) {
            return str;
        }
        String result = "";
        String word = "";
        boolean begin = true;
        for (int i = 0; i < len; i++) {
            char temp = str.charAt(i);
            if (' ' == temp) {
                result = temp + word + result;
                word = "";
            } else {
                word += temp;
            }
        }
        result = word + result;
        return result;
    }
}