//句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。每个句子
//可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。 
//
// 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词： 
//
// 
// 仅由小写字母、连字符和/或标点（不含数字）。 
// 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。 
// 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。 
// 
//
// 这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。 
//
// 给你一个字符串 sentence ，请你找出并返回 sentence 中 有效单词的数目 。 
//
// 
//
// 示例 1： 
//
// 输入：sentence = "cat and  dog"
//输出：3
//解释：句子中的有效单词是 "cat"、"and" 和 "dog"
// 
//
// 示例 2： 
//
// 输入：sentence = "!this  1-s b8d!"
//输出：0
//解释：句子中没有有效单词
//"!this" 不是有效单词，因为它以一个标点开头
//"1-s" 和 "b8d" 也不是有效单词，因为它们都包含数字
// 
//
// 示例 3： 
//
// 输入：sentence = "alice and  bob are playing stone-game10"
//输出：5
//解释：句子中的有效单词是 "alice"、"and"、"bob"、"are" 和 "playing"
//"stone-game10" 不是有效单词，因为它含有数字
// 
//
// 示例 4： 
//
// 输入：sentence = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."
//输出：6
//解释：句子中的有效单词是 "he"、"bought"、"pencils,"、"erasers,"、"and" 和 "pencil-sharpener."
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sentence.length <= 1000 
// sentence 由小写英文字母、数字（0-9）、以及字符（' '、'-'、'!'、'.' 和 ','）组成 
// 句子中至少有 1 个 token 
// 
// Related Topics 字符串 👍 50 👎 0


package com.jue.java.learn.leetcode.editor.cn.NumberOfValidWordsInASentence;

/**
 * @author JUE
 * @number 2047
 */
public class NumberOfValidWordsInASentence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countValidWords("cat and  dog"));// 3
        System.out.println(solution.countValidWords("!this  1-s b8d!"));// 0
        System.out.println(solution.countValidWords("alice and  bob are playing stone-game10"));// 5
        System.out.println(solution.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));// 6
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int countValidWords(String sentence) {
        int result = 0;
        // 表示这个单词是个正确的单词
        boolean right = true;
        boolean hasJoin = false;
        boolean hasMark = false;

        // 去除开始的空格
        int idx = 0;
        int len = sentence.length();
        while (idx < len && isBlank(sentence.charAt(idx))) {
            idx++;
        }
        for (; idx < len; idx++) {
            char c = sentence.charAt(idx);
            // 如果结束等一个空格重启(但是注意上一个不要是空格)
            if (right) {
                if (isBlank(c)) {
                    // 空格, 且上一个不是空格, 加一重启
                    if (!isBlank(sentence.charAt(idx - 1))) {
                        result++;
                        right = true;
                        hasJoin = false;
                        hasMark = false;
                    }
                } else if (isNumber(c)) {
                    // 数字直接结束
                    right = false;
                } else if (isJoin(c)) {
                    if (hasJoin) {
                        right = false;
                    } else {
                        hasJoin = true;
                        right = (idx > 0 && idx < len - 1
                                && isChar(sentence.charAt(idx - 1))
                                && isChar(sentence.charAt(idx + 1)));
                    }
                } else if (isMark(c)) {
                    if (hasMark) {
                        right = false;
                    } else {
                        hasMark = true;
                        right = idx == len - 1 || isBlank(sentence.charAt(idx + 1));
                    }
                }

            } else {
                if (isBlank(c)) {
                    right = true;
                    hasJoin = false;
                    hasMark = false;
                }
            }
        }
        if (right && !isBlank(sentence.charAt(len - 1))) {
            result++;
        }
        return result;
    }

    private boolean isChar(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isJoin(char c) {
        return c == '-';
    }

    private boolean isMark(char c) {
        return c == '!' || c == '.' || c == ',';
    }

    private boolean isBlank(char c) {
        return c == ' ';
    }

}
//leetcode submit region end(Prohibit modification and deletion)
