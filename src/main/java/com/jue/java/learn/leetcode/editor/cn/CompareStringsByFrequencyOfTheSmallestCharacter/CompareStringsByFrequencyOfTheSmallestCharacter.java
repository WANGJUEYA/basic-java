//定义一个函数 f(s)，统计 s 中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。 
//
// 例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。 
//
// 现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(
//queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。 
//
// 请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：queries = ["cbd"], words = ["zaaaz"]
//输出：[1]
//解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
// 
//
// 示例 2： 
//
// 
//输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
//输出：[1,2]
//解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queries.length <= 2000 
// 1 <= words.length <= 2000 
// 1 <= queries[i].length, words[i].length <= 10 
// queries[i][j]、words[i][j] 都由小写英文字母组成 
// 
//
// Related Topics 数组 哈希表 字符串 二分查找 排序 👍 95 👎 0


package com.jue.java.learn.leetcode.editor.cn.CompareStringsByFrequencyOfTheSmallestCharacter;

import java.util.Arrays;

/**
 * @author JUE
 * @number 1170
 */
public class CompareStringsByFrequencyOfTheSmallestCharacter {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"})));
//        System.out.println(Arrays.toString(solution.numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"})));
        System.out.println(Arrays.toString(solution.numSmallerByFrequency(new String[]{"bba", "abaaaaaa", "aaaaaa", "bbabbabaab", "aba", "aa", "baab", "bbbbbb", "aab", "bbabbaabb"},
                new String[]{"aaabbb", "aab", "babbab", "babbbb", "b", "bbbbbbbbab", "a", "bbbbbbbbbb", "baaabbaab", "aa"})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // 存储word的计算结果
        int[] store = new int[words.length];
        int index = -1;
        while (++index < words.length) {
            store[index] = count(words[index]);
        }
        Arrays.sort(store);
        int[] result = new int[queries.length];
        index = -1;
        for (String q : queries) {
            // 二分查找法确定多少个
            int find = count(q);
            result[++index] = find(store, find);
        }
        return result;
    }

    private int find(int[] arr, int f) {
        int low = -1, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            // 有可能有相同的数字
            if (arr[mid] > f) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return arr.length - low - 1;
    }

    private int count(String word) {
        char current = 'z';
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c == current) {
                count++;
            } else if (c < current) {
                current = c;
                count = 1;
            }
        }
        return count;
    }

    private int countWrong(String word) {
        // 注意: 不是计算次数最多的，是字典序最小的
        int count = 0;
        int[] store = new int[26];
        for (char c : word.toCharArray()) {
            count = Math.max(count, ++store[c - 'a']);
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
