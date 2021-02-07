//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 425 👎 0


package com.jue.java.learn.leetcode.editor.cn.AddBinary;

/**
 * @author JUE
 * @number 67
 */
public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int lena = a.length(), lenb = b.length();
        int ia = lena - 1, ib = lenb - 1, add = 0, adda, addb;
        StringBuilder result = new StringBuilder();
        while (ia >= 0 || ib >= 0 || add > 0) {
            adda = ia >= 0 ? a.charAt(ia) - '0' : 0;
            addb = ib >= 0 ? b.charAt(ib) - '0' : 0;
            int count = adda + addb + add;
            char temp = (char) ((int) '0' + count % 2);
            result.insert(0, temp);
            add = count / 2;
            ia--;
            ib--;
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
