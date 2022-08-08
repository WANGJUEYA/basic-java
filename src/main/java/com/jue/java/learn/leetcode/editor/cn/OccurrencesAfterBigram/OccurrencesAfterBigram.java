//给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 
//second 紧随 first 出现，third 紧随 second 出现。 
//
// 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：text = "alice is a good girl she is a good student", first = "a", second = 
//"good"
//输出：["girl","student"]
// 
//
// 示例 2： 
//
// 
//输入：text = "we will we will rock you", first = "we", second = "will"
//输出：["we","rock"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 1000 
// text 由小写英文字母和空格组成 
// text 中的所有单词之间都由 单个空格字符 分隔 
// 1 <= first.length, second.length <= 10 
// first 和 second 由小写英文字母组成 
// 
// Related Topics 字符串 👍 58 👎 0

package com.jue.java.learn.leetcode.editor.cn.OccurrencesAfterBigram;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author JUE
 * @number 1078
 */
public class OccurrencesAfterBigram {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findOcurrences("alice is a good girl she is a good student", "a", "good"))); // ["girl","student"]
        System.out.println(Arrays.toString(solution.findOcurrences("alice is aa good girl she is a good student", "a", "good"))); // ["girl","student"]
        System.out.println(Arrays.toString(solution.findOcurrences("we will we will rock you", "we", "will"))); // ["we","rock"]
    }
}

class Solution {
    // fixme 方法不支持正则匹配;
    public String[] findOcurrences(String text, String first, String second) {
        text = " " + text;
        // 正则匹配  'first second ' (?)
        // (?<=exp2)exp1：查找 exp2 后面的 exp1。 => 这种方案预防字符串被缓存
        Pattern pattern = Pattern.compile("((?<=( " + first + " " + second + " " + "))(((?! ).)*))");
        // 匹配不包含空格的单词
        // Pattern pattern = Pattern.compile("(((?!\\s).)*)");
        Matcher matcher = pattern.matcher(text);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group(3));
        }
        return list.toArray(new String[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
