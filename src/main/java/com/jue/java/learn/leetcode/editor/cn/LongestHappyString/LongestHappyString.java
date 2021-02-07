//如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。 
//
// 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s： 
//
// 
// s 是一个尽可能长的快乐字符串。 
// s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。 
// s 中只含有 'a'、'b' 、'c' 三种字母。 
// 
//
// 如果不存在这样的字符串 s ，请返回一个空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 输入：a = 1, b = 1, c = 7
//输出："ccaccbcc"
//解释："ccbccacc" 也是一种正确答案。
// 
//
// 示例 2： 
//
// 输入：a = 2, b = 2, c = 1
//输出："aabbc"
// 
//
// 示例 3： 
//
// 输入：a = 7, b = 1, c = 0
//输出："aabaa"
//解释：这是该测试用例的唯一正确答案。 
//
// 
//
// 提示： 
//
// 
// 0 <= a, b, c <= 100 
// a + b + c > 0 
// 
// Related Topics 贪心算法 动态规划


package com.jue.java.learn.leetcode.editor.cn.LongestHappyString;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author JUE
 * @number 1405
 */
public class LongestHappyString {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[][] array = new int[][]{{'a', a}, {'b', b}, {'c', c}};
        StringBuilder result = new StringBuilder();
        char c1 = ' ';
        char c2 = ' ';
        // 每次选择最大的一个字母填入
        do {
            Arrays.sort(array, Comparator.comparingInt(arr -> arr[1]));
            int index = 2;
            if (c1 == c2 && c1 == (char) array[index][0]) {
                if (array[1][1] > 0) {
                    index = 1;
                } else if (array[0][1] > 0) {
                    index = 0;
                } else {
                    return result.toString();
                }
            }
            c1 = c2;
            c2 = (char) array[index][0];
            result.append(c2);
            array[index][1]--;
        } while (array[0][1] > 0 || array[1][1] > 0 || array[2][1] > 0);
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
