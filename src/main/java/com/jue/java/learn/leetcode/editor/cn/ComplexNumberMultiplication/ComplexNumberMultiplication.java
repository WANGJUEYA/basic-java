//复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件： 
//
// 
// 实部 是一个整数，取值范围是 [-100, 100] 
// 虚部 也是一个整数，取值范围是 [-100, 100] 
// i² == -1 
// 
//
// 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "1+1i", num2 = "1+1i"
//输出："0+2i"
//解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
// 
//
// 示例 2： 
//
// 
//输入：num1 = "1+-1i", num2 = "1+-1i"
//输出："0+-2i"
//解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
// 
//
// 
//
// 提示： 
//
// 
// num1 和 num2 都是有效的复数表示。 
// 
// Related Topics 数学 字符串 模拟 👍 113 👎 0


package com.jue.java.learn.leetcode.editor.cn.ComplexNumberMultiplication;

/**
 * @author JUE
 * @number 537
 */
public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("0+2i".equals(solution.complexNumberMultiply("1+1i", "1+1i")));
        System.out.println("0+-2i".equals(solution.complexNumberMultiply("1+-1i", "1+-1i")));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] n1 = num1.split("\\+");
        String[] n2 = num2.split("\\+");
        int a1 = Integer.parseInt(n1[0]);
        int a2 = Integer.parseInt(n1[1].substring(0, n1[1].length() - 1));
        int b1 = Integer.parseInt(n2[0]);
        int b2 = Integer.parseInt(n2[1].substring(0, n2[1].length() - 1));
        return (a1 * b1 - a2 * b2) + "+" + (a1 * b2 + a2 * b1) + "i";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
