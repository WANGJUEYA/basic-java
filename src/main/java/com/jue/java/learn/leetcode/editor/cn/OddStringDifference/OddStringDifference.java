//给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
//
// 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，其中对于 0 <= j <= n - 2
// 有 difference[i][j] = words[i][j+1] - words[i][j] 。注意两个字母的差值定义为它们在字母表中 位置 之差，也就是
//说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
//
//
// 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
//
//
// words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
//
// 请你返回 words中 差值整数数组 不同的字符串。
//
//
//
// 示例 1：
//
//
//输入：words = ["adc","wzy","abc"]
//输出："abc"
//解释：
//- "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
//- "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
//- "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
//不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
//
//
// 示例 2：
//
//
//输入：words = ["aaa","bob","ccc","ddd"]
//输出："bob"
//解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
//
//
//
//
// 提示：
//
//
// 3 <= words.length <= 100
// n == words[i].length
// 2 <= n <= 20
// words[i] 只含有小写英文字母。
//
//
// Related Topics 数组 哈希表 字符串 👍 32 👎 0


package com.jue.java.learn.leetcode.editor.cn.OddStringDifference;

/**
 * @author JUE
 * @number 2451
 */
public class OddStringDifference {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String oddString(String[] words) {
        int wordLen = words[0].length() - 1;
        int[] different = new int[wordLen];
        int[] newDiff = null;
        // 前三一定能找到正确的差值数组
        for (int index = 0, n = words.length; index < n; index++) {
            char[] chars = words[index].toCharArray();
            if (index == 0) {
                for (int j = 0; j < wordLen; j++) {
                    different[j] = chars[j + 1] - chars[j];
                }
            } else if (index == 1) {
                int[] temp = new int[wordLen];
                boolean same = true;
                for (int j = 0; j < wordLen; j++) {
                    temp[j] = chars[j + 1] - chars[j];
                    if (temp[j] != different[j]) {
                        same = false;
                    }
                }
                if (!same) {
                    newDiff = temp;
                }
            } else if (index == 2 && newDiff != null) {
                for (int j = 0; j < wordLen; j++) {
                    int diff = chars[j + 1] - chars[j];
                    if (diff != different[j]) {
                        return words[0];
                    }
                    if (diff != newDiff[j]) {
                        return words[1];
                    }
                }
            } else {
                // 普通找出不同的串
                for (int j = 0; j < wordLen; j++) {
                    int diff = chars[j + 1] - chars[j];
                    if (diff != different[j]) {
                        return words[index];
                    }
                }
            }
        }
        return words[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
