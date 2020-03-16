package com.jue.java.learntest.leetcode.solution0009;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).isPalindrome(485));
    }

    public boolean isPalindrome(int x) {
        // 1.判断正负
        if (x < 0) {
            return false;
        }
        // 判断整数是否为回文
        // 2.分解数字
        List<Integer> bit = new ArrayList<>();
        while (x > 0) {
            int lowBit = x % 10;
            // System.out.println("lowBit: " + lowBit);
            bit.add(lowBit);
            x /= 10; // x = x / 10;
        }

        // 3.判断回文
        int heightIndex = bit.size() - 1, lowIndex = 0;
        while (heightIndex > lowIndex) {
            if (!bit.get(heightIndex).equals(bit.get(lowIndex))) {
                return false;
            }
            heightIndex--;
            lowIndex++;
        }
        return true;
    }
}