package com.jue.java.learntest.leetcode.solution_m_16_26;

class Solution {
    public static void main(String[] args) {
//        System.out.println((new Solution()).calculate("3+2*2"));
//        System.out.println((new Solution()).calculate("1-1+1"));
//        System.out.println((new Solution()).calculate("0-1"));
        System.out.println((new Solution()).calculate("22*3+4"));
    }

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