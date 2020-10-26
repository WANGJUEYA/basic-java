//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。 
//
// 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。 
//
// 
//
// 示例 1： 
//
// 输入：name = "alex", typed = "aaleex"
//输出：true
//解释：'alex' 中的 'a' 和 'e' 被长按。
// 
//
// 示例 2： 
//
// 输入：name = "saeed", typed = "ssaaedd"
//输出：false
//解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
// 
//
// 示例 3： 
//
// 输入：name = "leelee", typed = "lleeelee"
//输出：true
// 
//
// 示例 4： 
//
// 输入：name = "laiden", typed = "laiden"
//输出：true
//解释：长按名字中的字符并不是必要的。
// 
//
// 
//
// 提示： 
//
// 
// name.length <= 1000 
// typed.length <= 1000 
// name 和 typed 的字符都是小写字母。 
// 
//
// 
//
// 
// Related Topics 双指针 字符串 
// 👍 154 👎 0


package com.jue.java.learntest.leetcode.editor.cn.LongPressedName;

/**
 * @author JUE
 * @number 925
 */
public class LongPressedName {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isLongPressedName("alex","aaleex"));
        System.out.println(solution.isLongPressedName("",""));
        System.out.println(solution.isLongPressedName("",""));
        System.out.println(solution.isLongPressedName("",""));
        System.out.println(solution.isLongPressedName("",""));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int index1 = 0, index2 = 0, len1 = name.length(), len2 = typed.length();
        if(len1 == 0 && len2==0){
            return true;
        }
        if(len1 > len2){
            return false;
        }
        while (index1 < len1 && index2 < len2) {
            if (name.charAt(index1) == typed.charAt(index2)) {
                index1++;
                index2++;
            } else if (index1 > 0 && name.charAt(index1 - 1) == typed.charAt(index2)) {
                index2++;
            } else {
                return false;
            }
        }
        if (index1 == len1) {
            char end = name.charAt(len1 - 1);
            while (index2 < len2) {
                if (typed.charAt(index2) != end) {
                    return false;
                }
                index2++;
            }
            return true;
        } else {
            return false;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
