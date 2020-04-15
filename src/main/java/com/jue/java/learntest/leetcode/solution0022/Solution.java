package com.jue.java.learntest.leetcode.solution0022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).generateParenthesis(3));
    }

    // 暴力法
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        } else if (n == 1) {
            result.add("()");
        } else {
            // 在每一个回括号后追加回括号
            List<String> sub = generateParenthesis(n - 1);
            int index, len;
            String prefix, suffix, temp;
            for (String s : sub) {
                for (index = 0, len = s.length(); index < len; index++) {
                    if (index == 0 || s.charAt(index) == ')') {
                        prefix = s.substring(0, index);
                        suffix = s.substring(index);
//                        System.out.println("prefix: " + prefix);
//                        System.out.println("suffix: " + suffix);
                        temp = "(" + prefix + ")" + suffix;
                        if (!result.contains(temp)) {
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return result;
    }
}

class Solution_Update {
    Map<Integer, List<String>> dp = new HashMap<>();

    // 单步的存储空间
    public List<String> generateParenthesis(int n) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        } else if (n == 1) {
            result.add("()");
        } else {
            String temp;
            // 在每一个回括号后追加回括号
            for (int index = 0; index < n; index++) {
                List<String> prefixes = dp.containsKey(index) ? dp.get(index) : generateParenthesis(index);
                List<String> suffixes = dp.containsKey(n - index - 1) ? dp.get(n - index - 1) : generateParenthesis(n - index - 1);
                for (String prefix : prefixes) {
                    for (String suffix : suffixes) {
                        temp = "(" + prefix + ")" + suffix;
                        if (!result.contains(temp)) {
                            result.add(temp);
                        }
                    }
                }
            }
        }
        dp.put(n, result);
        return result;
    }
}