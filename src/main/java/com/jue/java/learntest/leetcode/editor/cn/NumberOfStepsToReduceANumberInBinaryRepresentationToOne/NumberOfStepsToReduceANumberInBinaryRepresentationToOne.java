//给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数： 
//
// 
// 
// 如果当前数字为偶数，则将其除以 2 。 
// 
// 
// 如果当前数字为奇数，则将其加上 1 。 
// 
// 
//
// 题目保证你总是可以按上述规则将测试用例变为 1 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "1101"
//输出：6
//解释："1101" 表示十进制数 13 。
//Step 1) 13 是奇数，加 1 得到 14 
//Step 2) 14 是偶数，除 2 得到 7
//Step 3) 7  是奇数，加 1 得到 8
//Step 4) 8  是偶数，除 2 得到 4  
//Step 5) 4  是偶数，除 2 得到 2 
//Step 6) 2  是偶数，除 2 得到 1  
// 
//
// 示例 2： 
//
// 输入：s = "10"
//输出：1
//解释："10" 表示十进制数 2 。
//Step 1) 2 是偶数，除 2 得到 1 
// 
//
// 示例 3： 
//
// 输入：s = "1"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 由字符 '0' 或 '1' 组成。 
// s[0] == '1' 
// 
// Related Topics 位运算 字符串


package com.jue.java.learntest.leetcode.editor.cn.NumberOfStepsToReduceANumberInBinaryRepresentationToOne;

/**
 * @author JUE
 * @number 1404
 */
public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 位运算? 如果0 结尾右移一次, 如果1结尾 加1再操作
    public int numSteps(String s) {
        int count = 0;
        while ('0' == s.charAt(s.length() - 1)) {
            // 去除末尾, 计数器加一
            s = s.substring(0, s.length() - 1);
            count++;
        }
        int len = s.length();
        if (len <= 1) {
            return count;
        }
        // 末尾为1
        char[] chars = s.toCharArray();
        int index = len - 1;
        boolean hasUpdate = true;
        while (index >= 0 && hasUpdate) {
            if ('1' == chars[index]) {
                chars[index] = '0';
                hasUpdate = true;
            } else {
                chars[index] = '1';
                hasUpdate = false;
            }
            index--;
        }
        s = (hasUpdate ? "1" : "") + String.valueOf(chars);
        return count + 1 + numSteps(s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
