package com.jue.java.learntest.leetcode.solution0003;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        System.out.println((new Solution()).lengthOfLongestSubstring("abcabcbb"));
        System.out.println((new Solution()).lengthOfLongestSubstring("bbbbb"));
        System.out.println((new Solution()).lengthOfLongestSubstring("pwwkew"));
        System.out.println((new Solution()).lengthOfLongestSubstring("abba"));
    }

    // 方法1: 使用hashMap的方式解决
    public int lengthOfLongestSubstring(String s) {
        // 当前子串包含的字符
        Map<Character, Integer> chars = new HashMap<>();
        // 当前子串的开始位置 0
        int currentIndex = 0;
        // 最长子串的大小
        int maxSize = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 重复字符出现
            if (chars.containsKey(c)) {
                maxSize = Math.max(maxSize, i - currentIndex);
                currentIndex = Math.max(currentIndex, chars.get(c) + 1);
            }
            // 更新索引位置
            chars.put(c, i);
        }
        return Math.max(maxSize, len - currentIndex);
    }
}

class SolutionPerfect {

    // 方法1: 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
}