package com.jue.java.learntest.leetcode.solution_m_01_06;

class Solution {
    public String compressString(String S) {
        int len = S.length();
        if(len <= 1){
            return S;
        }
        int count = 1;
        StringBuilder str = new StringBuilder();
        str.append(S.charAt(0));
        for (int index = 1; index < len; index++) {
            if (S.charAt(index) == S.charAt(index - 1)) {
                count++;
            } else {
                str.append(count);
                count = 1;
                str.append(S.charAt(index));
            }
        }
        str.append(count);
        return str.length() < len ? str.toString() : S;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).compressString("aabcccccaaa"));
        System.out.println((new Solution()).compressString("abbccd"));
    }
}
