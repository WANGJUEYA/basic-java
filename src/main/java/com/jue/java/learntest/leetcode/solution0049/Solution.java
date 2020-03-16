package com.jue.java.learntest.leetcode.solution0049;

import java.util.*;

class Solution {

    // 方法1: 利用散列存储排序后的字段 时间复杂度O(n*m)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for (String str : strs) {
            String sort = sort(str);
            if (maps.containsKey(sort)) {
                // Arrays.sort(str.toCharArray());
                maps.get(sort).add(str);
            } else {
                List<String> value = new ArrayList<>();
                value.add(str);
                maps.put(sort, value);
            }
        }

        return new ArrayList<>(maps.values());
    }

    // TODO 各种排序算法
    private String sort(String str) {
        StringBuilder res = new StringBuilder();
        int len = str.length();
        while (len > 0) {
            int min = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < str.charAt(min)) {
                    min = i;
                }
            }
            res.append(str.charAt(min));
            str = str.substring(0, min) + str.substring(min + 1, len);
            len--;
        }
        return res.toString();
    }
}

class SolutionPerfect {

    // 优解1: 26个字符计数 当字符串长度够长时此方式更快速(省去了排序的时间)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}