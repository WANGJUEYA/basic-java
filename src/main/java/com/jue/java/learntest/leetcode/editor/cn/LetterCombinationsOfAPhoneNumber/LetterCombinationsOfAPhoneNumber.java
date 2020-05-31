//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法


package com.jue.java.learntest.leetcode.editor.cn.LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @number 17
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
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
//leetcode submit region end(Prohibit modification and deletion)
