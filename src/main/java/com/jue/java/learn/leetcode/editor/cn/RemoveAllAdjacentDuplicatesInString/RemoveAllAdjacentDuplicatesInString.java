//给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
//
// 在 S 上反复执行重复项删除操作，直到无法继续删除。 
//
// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
//
// 
//
// 示例： 
//
// 输入："abbaca"
//输出："ca"
//解释：
//例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
//只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 20000 
// S 仅由小写英文字母组成。 
// 
// Related Topics 栈 
// 👍 268 👎 0


package com.jue.java.learn.leetcode.editor.cn.RemoveAllAdjacentDuplicatesInString;

/**
 * @author JUE
 * @number 1047
 */
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.removeDuplicates("abbaca"));
        System.out.println(solution.removeDuplicates("aaaaaaaaa"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicates(String s) {
        // 如果下一个与当前相同, 则两个都删除, 指针后移
        for (int index = 0; index < s.length() - 1 && s.length() > 1; index++) {
            if (index < 0) {
                index = 0;
            }
            // 比较操作
            if (s.charAt(index) == s.charAt(index + 1)) {
                // 删除字符
                s = s.substring(0, index) + s.substring(index + 2);
                // 回退索引到前一个(循环总是加一)
                index -= 2;
            }
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class SolutionPerfect {
    public String removeDuplicates(String S) {
        char[] s = S.toCharArray();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top == -1 || s[top] != s[i]) {
                s[++top] = s[i];
            } else {
                top--;
            }
        }
        return String.valueOf(s, 0, top + 1);
    }
}
