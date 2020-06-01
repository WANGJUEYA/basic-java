//给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
// 例如，
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//
//
// 示例 1:
//
// 输入: 1
//输出: "A"
//
//
// 示例 2:
//
// 输入: 28
//输出: "AB"
//
//
// 示例 3:
//
// 输入: 701
//输出: "ZY"
//
// Related Topics 数学


package com.jue.java.learntest.leetcode.editor.cn.ExcelSheetColumnTitle;

/**
 * @author JUE
 * @number 168
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(1));
        System.out.println(solution.convertToTitle(28));
        System.out.println(solution.convertToTitle(52));
        System.out.println(solution.convertToTitle(701));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int mod = n % 26;
            n = n / 26;
            if (mod == 0) {
                mod = 26;
                n--;
            }
            char temp = (char) (mod + (int) 'A' - 1);
            result.insert(0, temp);
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

