//给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。 
//
// 返回 word 中 特殊字母 的数量。 
//
// 
//
// 示例 1: 
//
// 
// 输入：word = "aaAbcBC" 
// 
//
// 输出：3 
//
// 解释： 
//
// word 中的特殊字母是 'a'、'b' 和 'c'。 
//
// 示例 2: 
//
// 
// 输入：word = "abc" 
// 
//
// 输出：0 
//
// 解释： 
//
// word 中不存在大小写形式同时出现的字母。 
//
// 示例 3: 
//
// 
// 输入：word = "abBCab" 
// 
//
// 输出：1 
//
// 解释： 
//
// word 中唯一的特殊字母是 'b'。 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 50 
// word 仅由小写和大写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 👍 1 👎 0


package com.jue.java.learn.leetcode.editor.cn.CountTheNumberOfSpecialCharactersI;

/**
 * @author JUE
 * @number 3120
 */
public class CountTheNumberOfSpecialCharactersI {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSpecialChars("aaAbcBC")); // 3
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSpecialChars(String word) {
        // 位运算统计
        int[][] store = new int[26][2];
        for (char c : word.toCharArray()) {
            boolean lower = c >= 'a';
            store[lower ? c - 'a' : c - 'A'][lower ? 0 : 1] = 1;
        }
        int count = 0;
        for (int[] item : store) {
            count += (item[0] & item[1]);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
