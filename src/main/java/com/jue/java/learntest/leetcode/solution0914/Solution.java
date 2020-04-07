package com.jue.java.learntest.leetcode.solution0914;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] array1 = {1, 1};
        System.out.println((new Solution()).hasGroupsSizeX(array1));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        if (len <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : deck) {
            if (map.containsKey(d)) {
                map.put(d, map.get(d) + 1);
            } else {
                map.put(d, 1);
            }
        }
        for (int index = 2; index <= len; index++) {
            boolean result = true;
            for (Integer v : map.values()) {
                if (!result) {
                    break;
                }
                result = v % index == 0;
            }
            if (result) {
                return true;
            }
        }
        return false;

// 若 X 在输入数组中
//        for (Integer value : map.values()) {
//            if (value >= 2 && map.containsKey(value)) {
//                boolean result = true;
//                for (Integer v : map.values()) {
//                    if (!result) {
//                        break;
//                    }
//                    result = v % value == 0;
//                }
//                if (result) {
//                    return true;
//                }
//            }
//        }
    }
}