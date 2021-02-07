//给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。 
//
// 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串
//。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["mass","as","hero","superhero"]
//输出：["as","hero"]
//解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
//["hero","as"] 也是有效的答案。
// 
//
// 示例 2： 
//
// 输入：words = ["leetcode","et","code"]
//输出：["et","code"]
//解释："et" 和 "code" 都是 "leetcode" 的子字符串。
// 
//
// 示例 3： 
//
// 输入：words = ["blue","green","bu"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 30 
// words[i] 仅包含小写英文字母。 
// 题目数据 保证 每个 words[i] 都是独一无二的。 
// 
// Related Topics 字符串


package com.jue.java.learn.leetcode.editor.cn.StringMatchingInAnArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author JUE
 * @number 1408
 */
public class StringMatchingInAnArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        System.out.println(solution.stringMatching(new String[]{"leetcode", "et", "code"}));
        System.out.println(solution.stringMatching(new String[]{"blue", "green", "bu"}));
        System.out.println(solution.stringMatching(new String[]{"leetcoder", "leetcode", "od", "hamlet", "am"}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
