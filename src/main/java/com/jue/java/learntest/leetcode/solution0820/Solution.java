package com.jue.java.learntest.leetcode.solution0820;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        List<String> array = new ArrayList<>(Arrays.asList(words));
        // 按字符长度从小到大排序
        array.sort(Comparator.comparingInt(String::length));
        StringBuilder result = new StringBuilder();
        while (!array.isEmpty()) {
            int len = array.size();
            result.append("#").append(array.get(len - 1));
            array.remove(len - 1);
            array.removeIf(s -> result.substring(result.length() - s.length()).equals(s));
        }
        return result.length() - 1; // “#”
    }
}