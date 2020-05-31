package com.jue.java.learntest.leetcode.solution1419;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).minNumberOfFrogs("crcoakroak"));
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<String, Integer> temp = new HashMap<>();
        int max = 0, countForMax = 0;
        char[] key = new char[]{'c', 'r', 'o', 'a', 'k'};
        String keyC = "c";
        String keyCroak = "croak";
        for (char c : croakOfFrogs.toCharArray()) {
            System.out.println(temp);
            int index = keyCroak.indexOf(c);
            if (index == -1) {
                return index;
            } else if (index == 0) {
                countForMax++;
                temp.put(keyC, 1 + temp.getOrDefault(keyC, 0));
            } else {
                String that = String.valueOf(Arrays.copyOf(key, index + 1));
                String last = String.valueOf(Arrays.copyOf(key, index));
                if (temp.containsKey(last)) {
                    int count = temp.get(last);
                    if (count == 1) {
                        temp.remove(last);
                    } else {
                        temp.put(last, count - 1);
                    }
                    if (index < 4) {
                        temp.put(that, 1 + temp.getOrDefault(that, 0));
                    } else {
                        max = Math.max(max, countForMax--);
                    }
                } else {
                    return -1;
                }
            }
        }
        return temp.size() == 0 ? max : -1;
    }
}