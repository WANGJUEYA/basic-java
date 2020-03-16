package com.jue.java.learntest.leetcode.solution0017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static Map<String, String[]> maps = new HashMap<>();

    static {
        maps.put("2", new String[]{"a", "b", "c"});
        maps.put("3", new String[]{"d", "e", "f"});
        maps.put("4", new String[]{"g", "h", "i"});
        maps.put("5", new String[]{"j", "k", "l"});
        maps.put("6", new String[]{"m", "n", "o"});
        maps.put("7", new String[]{"p", "q", "r", "s"});
        maps.put("8", new String[]{"t", "u", "v"});
        maps.put("9", new String[]{"w", "x", "y", "z"});
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        for (String first : maps.get(String.valueOf(digits.charAt(0)))) {
            if (digits.length() == 1) {
                result.add(first);
            } else {
                List<String> sub = letterCombinations(digits.substring(1));
                for (String s : sub) {
                    result.add(first + s);
                }
            }
        }
        return result;
    }
}

class SolutionPerfect {
    // TODO

}