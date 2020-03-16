package com.jue.java.learntest.tooffer.solution21;

public class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).isNumeric("+-5".toCharArray()));
    }

    private enum Special {
        /**
         * 一些数据中的特殊符号
         */
        CHAR_E('e'), CHAR_ADD('+'), CHAR_SUB('-'), CHAR_COMMA('.'), CHAR_WRONG(' ');
        private char val;

        Special(char val) {
            this.val = val;
        }

        public char val() {
            return val;
        }

        public static Special val(char val) {
            //values()方法返回enum实例的数组
            for (Special s : values()) {
                if (String.valueOf(s.val).equalsIgnoreCase(String.valueOf(val))) {
                    return s;
                }
            }
            return CHAR_WRONG;
        }
    }

    /**
     * 小数点只能出现在数字之后(且不能出现在e之后)
     * 符号只能出现在开始和e之后
     */
    public boolean isNumeric(char[] str) {
        //允许出现加减符号
        boolean allowAddAndSub = true;
        //允许出现e
        int countExponent = 0;
        //允许出现小数点
        boolean allowComma = true;
        //需要数字
        boolean needNumber = true;
        for (char temp : str) {
            if (temp >= '0' && temp <= '9') {
                allowAddAndSub = false;
                needNumber = false;
            } else {
                switch (Special.val(temp)) {
                    case CHAR_WRONG:
                        return false;
                    case CHAR_E:
                        if (countExponent >= 1) {
                            return false;
                        } else {
                            countExponent++;
                            allowAddAndSub = true;
                            allowComma = false;
                            needNumber = true;
                        }
                        break;
                    case CHAR_ADD:
                    case CHAR_SUB:
                        if (!allowAddAndSub) {
                            return false;
                        } else {
                            allowAddAndSub = false;
                            needNumber = true;
                        }
                        break;
                    case CHAR_COMMA:
                        if (!allowComma) {
                            return false;
                        } else {
                            allowAddAndSub = false;
                            allowComma = false;
                            needNumber = true;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        return !needNumber;
    }
}

class SolutionPerfect {
    public boolean isNumeric(char[] str) {
        String s=String.valueOf(str);
        //return s.matches("[+-]?[0-9]*(.[0-9]*)?([eE][+-]?[0-9]+)?");
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }
}