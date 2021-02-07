//我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。 
//
// 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueCh
//ars(s) = 5 。 
//
// 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。注意，某些子字符串可能是重复的，
//但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。 
//
// 由于答案可能非常大，请将结果 mod 10 ^ 9 + 7 后再返回。 
//
// 
//
// 示例 1： 
//
// 输入: "ABC"
//输出: 10
//解释: 所有可能的子串为："A","B","C","AB","BC" 和 "ABC"。
//     其中，每一个子串都由独特字符构成。
//     所以其长度总和为：1 + 1 + 1 + 2 + 2 + 3 = 10
// 
//
// 示例 2： 
//
// 输入: "ABA"
//输出: 8
//解释: 除了 countUniqueChars("ABA") = 1 之外，其余与示例 1 相同。
// 
//
// 示例 3： 
//
// 输入：s = "LEETCODE"
//输出：92
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10^4 
// s 只包含大写英文字符 
// 
// Related Topics 双指针


package com.jue.java.learn.leetcode.editor.cn.CountUniqueCharactersOfAllSubstringsOfAGivenString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @number 828
 */
public class CountUniqueCharactersOfAllSubstringsOfAGivenString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniqueLetterString("ABC"));
        System.out.println(solution.uniqueLetterString("ABA"));
        System.out.println(solution.uniqueLetterString("LEETCODE"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniqueLetterString(String S) {
        Map<Character, List<Integer>> index = new HashMap();
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            index.computeIfAbsent(c, x -> new ArrayList<Integer>()).add(i);
        }

        long ans = 0;
        for (List<Integer> A : index.values()) {
            for (int i = 0; i < A.size(); ++i) {
                long prev = i > 0 ? A.get(i - 1) : -1;
                long next = i < A.size() - 1 ? A.get(i + 1) : S.length();
                ans += (A.get(i) - prev) * (next - A.get(i));
            }
        }

        return (int) ans % 1_000_000_007;
    }
}
//leetcode submit region end(Prohibit modification and deletion)