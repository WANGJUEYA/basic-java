//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package com.jue.java.learn.leetcode.editor.cn.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 3
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("abba"));

    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 方法1: 使用hashMap的方式解决
    public int lengthOfLongestSubstring(String s) {
        // 当前子串包含的字符
        Map<Character, Integer> chars = new HashMap<>();
        // 当前子串的开始位置 0
        int currentIndex = 0;
        // 最长子串的大小
        int maxSize = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 重复字符出现
            if (chars.containsKey(c)) {
                maxSize = Math.max(maxSize, i - currentIndex);
                currentIndex = Math.max(currentIndex, chars.get(c) + 1);
            }
            // 更新索引位置
            chars.put(c, i);
        }
        return Math.max(maxSize, len - currentIndex);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class SolutionPerfect {
    // 方法1: 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
}
