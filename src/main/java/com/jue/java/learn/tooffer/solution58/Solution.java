package com.jue.java.learn.tooffer.solution58;

public class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).StrToInt("+1a33"));
    }

    private enum special {
        /**
         * 一些数据中的特殊符号
         */
        CHAR_E("e"), CHAR_ADD("+"), CHAR_SUB("-");
        private String val;

        special(String val) {
            this.val = val;
        }

        public String val() {
            return val;
        }
    }

    /**
     * TODO 科学计数法展示
     */
    public int StrToInt(String str) {
        int result = 0;
        int mutiCount = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            char temp = str.charAt(i);
            if (temp >= '0' && temp <= '9') {
                result = result + mutiCount * (temp - '0');
                mutiCount *= 10;
            } else {
                if (i != 0) {
                    return 0;
                }
                if (special.CHAR_ADD.val.equals(temp + "")) {
                    return result;
                } else if (special.CHAR_SUB.val.equals(temp + "")) {
                    return -1 * result;
                }
            }
        }
        return result;
    }
}