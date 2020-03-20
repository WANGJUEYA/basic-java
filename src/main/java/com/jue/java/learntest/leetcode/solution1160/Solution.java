package com.jue.java.learntest.leetcode.solution1160;

import java.util.HashMap;
import java.util.Map;

// PS int[26] is the perfect answer
class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : chars.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }
        int count = 0;
        Map<Character, Integer> temp;
        for (int index = 0, n = words.length; index < n; index++) {
            temp = new HashMap<>(charCount);
            boolean learned = true;
            for (char c : words[index].toCharArray()) {
                if (temp.containsKey(c)) {
                    if (temp.get(c) > 1) {
                        temp.put(c, temp.get(c) - 1);
                    } else {
                        temp.remove(c);
                    }
                } else {
                    learned = false;
                    break;
                }
            }
            count += learned ? words[index].length() : 0;
        }
        return count;
    }
}