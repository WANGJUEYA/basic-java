//给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称
//字母 c 是一个 特殊字母 。 
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
// 特殊字母是 'a'、'b' 和 'c'。 
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
// word 中不存在特殊字母。 
//
// 示例 3: 
//
// 
// 输入：word = "AbBCab" 
// 
//
// 输出：0 
//
// 解释： 
//
// word 中不存在特殊字母。 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 2 * 10⁵ 
// word 仅由小写和大写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 👍 5 👎 0


package com.jue.java.learn.leetcode.editor.cn.CountTheNumberOfSpecialCharactersIi;

/**
 * @author JUE
 * @number 3121
 */
public class CountTheNumberOfSpecialCharactersIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSpecialChars("AbBCab")); // 1
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSpecialChars(String word) {
        // 位运算统计
        int[][] store = new int[26][2];
        // 每个小写形式都出现在第一个大写形式之前
        // 从1开始规避了首位判断问题
        for (int i = 1, len = word.length(); i <= len; i++) {
            int c = word.charAt(i - 1);
            boolean lower = c >= 'a';
            if (lower) {
                store[c - 'a'][0] = i;
            } else {
                if (store[c - 'A'][1] == 0) {
                    store[c - 'A'][1] = i;
                }
            }
        }
        int count = 0;
        for (int[] item : store) {
            if (item[0] > 0 && item[0] < item[1]) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
