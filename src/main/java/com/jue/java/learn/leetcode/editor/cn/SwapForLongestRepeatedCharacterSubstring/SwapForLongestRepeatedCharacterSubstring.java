//如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。 
//
// 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。 
//
// 
//
// 示例 1： 
//
// 输入：text = "ababa"
//输出：3
// 
//
// 示例 2： 
//
// 输入：text = "aaabaaa"
//输出：6
// 
//
// 示例 3： 
//
// 输入：text = "aaabbaaa"
//输出：4
// 
//
// 示例 4： 
//
// 输入：text = "aaaaa"
//输出：5
// 
//
// 示例 5： 
//
// 输入：text = "abcdef"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 20000 
// text 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 175 👎 0


package com.jue.java.learn.leetcode.editor.cn.SwapForLongestRepeatedCharacterSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @number 1156
 */
public class SwapForLongestRepeatedCharacterSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxRepOpt1("ababa"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxRepOpt1(String text) {
        Map<Character, List<int[]>> store = new HashMap<>();
        int firstIndex = 0;
        // 存储每个字母出现的位置
        for (int index = 1, len = text.length(); index < len; index++) {
            // 和上一个不一样开始重新计数
            Character last = text.charAt(index - 1);
            if (text.charAt(index) != last) {
                if (!store.containsKey(last))
                    store.put(last, new ArrayList<int[]>());
                store.get(last).add(new int[]{firstIndex, index - 1});
                firstIndex = index;
            }
        }
        // 最后一个数字
        Character end = text.charAt(text.length() - 1);
        if (!store.containsKey(end))
            store.put(end, new ArrayList<int[]>());
        store.get(end).add(new int[]{firstIndex, text.length() - 1});

        // 计算结果
        int max = 0;
        for (List<int[]> value : store.values()) {
            int last = -10;
            int size = value.size();
            int add = size > 2 ? 1 : 0;
            for (int index = 0; index < size; index++) {
                int current = value.get(index)[1] - value.get(index)[0] + 1;
                if (value.get(index)[0] == last + 2) {
                    current = current + add + (value.get(index - 1)[1] - value.get(index - 1)[0] + 1);
                } else if (size > 1) {
                    current++;
                }
                last = value.get(index)[1];
                max = Math.max(max, current);
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
