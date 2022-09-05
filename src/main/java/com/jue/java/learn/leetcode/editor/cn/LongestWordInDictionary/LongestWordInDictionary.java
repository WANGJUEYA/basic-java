//给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。 
//
// 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
// 
//
// 示例 2： 
//
// 
//输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply" 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 30 
// 所有输入的字符串 words[i] 都只包含小写字母。 
// 
// Related Topics 字典树 数组 哈希表 字符串 排序 👍 267 👎 0


package com.jue.java.learn.leetcode.editor.cn.LongestWordInDictionary;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author JUE
 * @number 720
 */
public class LongestWordInDictionary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(solution.longestWord(new String[]{"d", "do", "dog", "p", "pe", "pen", "peng", "pengu", "pengui", "penguin", "e", "el", "ele", "elep", "eleph", "elepha", "elephan", "elephant"}));
        System.out.println(solution.longestWord(new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public String longestWord(String[] words) {
        // 先对单词进行排序(先字典逆序, 再数字序)
        Arrays.sort(words, Collections.reverseOrder());
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> list = Arrays.asList(words);
        int len = words.length;
        for (int index = len - 1; index >= 0; index--) {
            String word = words[index];
            while (word.length() > 1) {
                word = word.substring(0, word.length() - 1);
                if (!list.contains(word)) {
                    break;
                }
            }
            if (list.contains(word)) {
                return words[index];
            }
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
