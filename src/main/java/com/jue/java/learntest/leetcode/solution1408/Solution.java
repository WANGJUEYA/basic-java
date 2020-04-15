package com.jue.java.learntest.leetcode.solution1408;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author JUE
 * @date 2020/4/12
 * @note 0 error(s), 0 warning(s)
 **/
class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        System.out.println((new Solution()).stringMatching(new String[]{"leetcode", "et", "code"}));
        System.out.println((new Solution()).stringMatching(new String[]{"blue", "green", "bu"}));
        System.out.println((new Solution()).stringMatching(new String[]{"leetcoder", "leetcode", "od", "hamlet", "am"}));
    }

    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> result = new ArrayList<>();
        int len = words.length;
        for (int index = 0; index < len - 1; index++) {
            for (int next = index + 1; next < len && words[index].length() < words[len - 1].length(); next++) {
                if (words[next].contains(words[index])) {
                    result.add(words[index]);
                    break;
                }
                // 串的模式匹配
//                int i = 0, j = -1;
//                int[] dp = new int[words[next].length() + 1];
//                dp[0] = -1;
//                while (i < words[next].length()) {
//                    if (j == -1 || words[next].charAt(i) == words[index].charAt(j + 1)) {
//                        dp[++i] = ++j;
//                        if (j == words[index].length()-1) {
//                            flag = true;
//                            result.add(words[index]);
//                            break;
//                        }
//                    } else {
//                        j = dp[j];
//                    }
//                }
            }
        }
        return result;
    }
}
