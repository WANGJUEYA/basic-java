package com.jue.java.learntest.leetcode.solution0828;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).uniqueLetterString("ABC"));
        System.out.println((new Solution()).uniqueLetterString("ABA"));
        System.out.println((new Solution()).uniqueLetterString("LEETCODE"));
    }

    public int uniqueLetterString(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        int count = len; // 一个字符的子串
        Map<Character, Integer> base = new HashMap<>();
        base.put(s.charAt(0), 1);
        int countBase = 1;
        // 滑动窗口  窗口大小
        for (int win = 2; win <= len; win++) {

            char one = s.charAt(win - 1);
            if (base.containsKey(one)) {
                if (base.get(one) == 1) {
                    countBase--;
                }
                base.put(one, base.get(one) + 1);
            } else {
                base.put(one, 1);
                countBase++;
            }
            count += countBase;

            Map<Character, Integer> record = new HashMap<>(base);
            int countTemp = countBase;
            // 移动窗口
            for (int index = win; index < len; index++) {
                char c = s.charAt(index);

                if (record.containsKey(c)) {
                    if (record.get(c) == 1) {
                        countTemp--;
                    }
                    record.put(c, record.get(c) + 1);
                } else {
                    record.put(c, 1);
                    countTemp++;
                }
                // 减去上一个字符
                char last = s.charAt(index - win);
                int lastCount = record.get(last);
                if (lastCount == 1) {
                    record.remove(last);
                    countTemp--;
                } else {
                    if (lastCount == 2) {
                        countTemp++;
                    }
                    record.put(last, lastCount - 1);
                }
                count += countTemp;
            }
        }
        return count % (int) (1e9 + 7);
    }
}

class Solution_Perfect {
    public static void main(String[] args) {
//        System.out.println((new Solution_Perfect()).uniqueLetterString("ABC"));
//        System.out.println((new Solution_Perfect()).uniqueLetterString("ABA"));
        System.out.println((new Solution_Perfect()).uniqueLetterString("LEETCODE"));
    }
    public int uniqueLetterString(String S) {
        Map<Character, List<Integer>> index = new HashMap();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            index.computeIfAbsent(c, x-> new ArrayList<Integer>()).add(i);
        }

        long ans = 0;
        for (List<Integer> A: index.values()) {
            for (int i = 0; i < A.size(); ++i) {
                long prev = i > 0 ? A.get(i-1) : -1;
                long next = i < A.size() - 1 ? A.get(i+1) : S.length();
                ans += (A.get(i) - prev) * (next - A.get(i));
            }
        }

        return (int) ans % 1_000_000_007;
    }
}