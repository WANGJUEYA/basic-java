package com.jue.java.learntest.leetcode.solution0168;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).convertToTitle(1));
        System.out.println((new Solution()).convertToTitle(28));
        System.out.println((new Solution()).convertToTitle(52));
        System.out.println((new Solution()).convertToTitle(701));
    }

    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int mod = n % 26;
            n = n / 26;
            if (mod == 0) {
                mod = 26;
                n--;
            }
            char temp = (char) (mod + (int) 'A' - 1);
            result.insert(0, temp);
        }
        return result.toString();
    }
}