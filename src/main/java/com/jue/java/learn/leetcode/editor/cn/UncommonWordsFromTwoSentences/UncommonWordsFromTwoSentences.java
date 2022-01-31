//句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。 
//
// 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。 
//
// 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s1 = "this apple is sweet", s2 = "this apple is sour"
//输出：["sweet","sour"]
// 
//
// 示例 2： 
//
// 
//输入：s1 = "apple apple", s2 = "banana"
//输出：["banana"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 200 
// s1 和 s2 由小写英文字母和空格组成 
// s1 和 s2 都不含前导或尾随空格 
// s1 和 s2 中的所有单词间均由单个空格分隔 
// 
// Related Topics 哈希表 字符串 👍 152 👎 0


package com.jue.java.learn.leetcode.editor.cn.UncommonWordsFromTwoSentences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JUE
 * @number 884
 */
public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.uncommonFromSentences("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(solution.uncommonFromSentences("banana", "apple apple")));
        System.out.println(Arrays.toString(solution.uncommonFromSentences("apple apple", "banana")));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> result = new ArrayList<>();
        List<String> remove = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        for (String item : s1.split(" ")) {
            if (list1.contains(item)) {
                remove.add(item);
            } else {
                list1.add(item);
            }
        }
        List<String> list2 = new ArrayList<>();
        for (String item : s2.split(" ")) {
            if (list2.contains(item)) {
                remove.add(item);
            } else {
                list2.add(item);
                if (list1.contains(item)) {
                    list1.remove(item);
                } else {
                    result.add(item);
                }
            }
        }
        result.addAll(list1);
        for (String item : remove) {
            result.remove(item);
        }
        return result.toArray(new String[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
