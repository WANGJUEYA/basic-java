//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = " "
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// 
// Related Topics 字符串 
// 👍 275 👎 0


package com.jue.java.learn.leetcode.editor.cn.LengthOfLastWord;

/**
 * @author JUE
 * @number 58
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord(" "));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        // 倒着计算
        int len = s.length();
        boolean start = false;
        int count = 0;
        for (int index = len - 1; index >= 0; index--) {
            char temp = s.charAt(index);
            if (start) {
                if (' ' == temp) {
                    break;
                } else {
                    count++;
                }
            } else {
                if (' ' != temp) {
                    start = true;
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
