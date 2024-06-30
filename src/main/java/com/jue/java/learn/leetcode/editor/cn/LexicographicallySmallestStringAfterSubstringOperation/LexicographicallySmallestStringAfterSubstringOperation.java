//给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以完成以下行为： 
//
// 
// 选择 s 的任一非空子字符串，可能是整个字符串，接着将字符串中的每一个字符替换为英文字母表中的前一个字符。例如，'b' 用 'a' 替换，'a' 用 
//'z' 替换。 
// 
//
// 返回执行上述操作 恰好一次 后可以获得的 字典序最小 的字符串。 
//
// 子字符串 是字符串中的一个连续字符序列。 现有长度相同的两个字符串 
//x 和 字符串 
//y ，在满足 
//x[i] != y[i] 的第一个位置 
//i 上，如果 
//x[i] 在字母表中先于 
//y[i] 出现，则认为字符串 
//x 比字符串 
//y 
//字典序更小 。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "cbabc"
//输出："baabc"
//解释：我们选择从下标 0 开始、到下标 1 结束的子字符串执行操作。 
//可以证明最终得到的字符串是字典序最小的。
// 
//
// 示例 2： 
//
// 
//输入：s = "acbbc"
//输出："abaab"
//解释：我们选择从下标 1 开始、到下标 4 结束的子字符串执行操作。
//可以证明最终得到的字符串是字典序最小的。
// 
//
// 示例 3： 
//
// 
//输入：s = "leetcode"
//输出："kddsbncd"
//解释：我们选择整个字符串执行操作。
//可以证明最终得到的字符串是字典序最小的。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 字符串 👍 31 👎 0


package com.jue.java.learn.leetcode.editor.cn.LexicographicallySmallestStringAfterSubstringOperation;

/**
 * @author JUE
 * @number 2734
 */
public class LexicographicallySmallestStringAfterSubstringOperation {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.smallestString("cbabc"));
        System.out.println(solution.smallestString("aa"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String smallestString(String s) {
        int len = s.length();
        // 第一个A和第二个a
        int first = 0;
        while (s.charAt(first) == 'a') {
            first++;
            if (first >= len) {
                // 如果全部都是a, 替换最后一个
                return s.substring(0, len - 1) + 'z';
            }
        }
        int second = s.indexOf("a", first);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (i >= first && (second < 0 || i < second)) {
                c = (char) (c - 1);
            }
            res.append(c);
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
