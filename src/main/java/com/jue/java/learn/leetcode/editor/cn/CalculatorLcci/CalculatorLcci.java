//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 字符串


package com.jue.java.learn.leetcode.editor.cn.CalculatorLcci;

/**
 * @author JUE
 * @number 面试题 16.26
 */
public class CalculatorLcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println((new Solution()).calculate("3+2*2"));
//        System.out.println((new Solution()).calculate("1-1+1"));
//        System.out.println((new Solution()).calculate("0-1"));
        System.out.println((new Solution()).calculate("22*3+4"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        int len = s.length();
        // 使用栈计算
        int[] nums = new int[len];
        int numsPoint = -1;
        char[] ops = new char[len];
        int opsPoint = -1;
        int num = 0;
        for (int index = 0, n = s.length(); index < n; index++) {
            char item = s.charAt(index);
            switch (item) {
                case '+':
                case '-':
                case '*':
                case '/':
                    // 先计算上一个乘除
                    if (opsPoint > -1 && (ops[opsPoint] == '*' || ops[opsPoint] == '/')) {
                        int result = option(nums[numsPoint--], num, ops[opsPoint--]);
                        nums[++numsPoint] = result;
                    } else {
                        nums[++numsPoint] = num;
                    }
                    ops[++opsPoint] = item;
                    num = 0;
                    continue;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    num = num * 10 + (int) item - (int) '0';
                    continue;
                case ' ':
                    continue;
                default: // 未知元素
                    throw new IllegalArgumentException("unknown char");
            }
        }
        if (opsPoint > -1 && (ops[opsPoint] == '*' || ops[opsPoint] == '/')) {
            num = option(nums[numsPoint--], num, ops[opsPoint--]);
        }
        nums[++numsPoint] = num;
        num = nums[0];
        // ps 目前没有复数
        for (int index = 0; index <= opsPoint; index++) {
            num = option(num, nums[index + 1], ops[index]);
        }
        return num;
    }

    public int option(int op1, int op2, char op) {
        switch (op) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
            default:
                throw new IllegalArgumentException("the op must be + - * /");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
