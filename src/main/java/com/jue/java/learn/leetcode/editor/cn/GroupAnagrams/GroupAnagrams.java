//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


package com.jue.java.learn.leetcode.editor.cn.GroupAnagrams;

import java.util.*;

/**
 * @author JUE
 * @number 49
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 方法1: 利用散列存储排序后的字段 时间复杂度O(n*m)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for (String str : strs) {
            String sort = sort(str);
            if (maps.containsKey(sort)) {
                // Arrays.sort(str.toCharArray());
                maps.get(sort).add(str);
            } else {
                List<String> value = new ArrayList<>();
                value.add(str);
                maps.put(sort, value);
            }
        }

        return new ArrayList<>(maps.values());
    }

    // TODO 各种排序算法
    private String sort(String str) {
        StringBuilder res = new StringBuilder();
        int len = str.length();
        while (len > 0) {
            int min = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < str.charAt(min)) {
                    min = i;
                }
            }
            res.append(str.charAt(min));
            str = str.substring(0, min) + str.substring(min + 1, len);
            len--;
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class SolutionPerfect {

    // 优解1: 26个字符计数 当字符串长度够长时此方式更快速(省去了排序的时间)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}