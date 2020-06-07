//给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。 
//
// 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0,
// 2, 5]。 
//
// 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。 
//
// 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？ 
//
// 
//
// 示例： 
//
// 输入: words = ["time", "me", "bell"]
//输出: 10
//说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 7 
// 每个单词都是小写字母 。 
// 
//


package com.jue.java.learntest.leetcode.editor.cn.ShortEncodingOfWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author JUE
 * @number 820
 */
public class ShortEncodingOfWords {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumLengthEncoding(String[] words) {
        List<String> array = new ArrayList<>(Arrays.asList(words));
        // 按字符长度从小到大排序
        array.sort(Comparator.comparingInt(String::length));
        StringBuilder result = new StringBuilder();
        while (!array.isEmpty()) {
            int len = array.size();
            result.append("#").append(array.get(len - 1));
            array.remove(len - 1);
            array.removeIf(s -> result.substring(result.length() - s.length()).equals(s));
        }
        return result.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
