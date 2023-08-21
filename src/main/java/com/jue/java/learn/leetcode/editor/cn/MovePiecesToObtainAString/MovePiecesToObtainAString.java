//给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
//
//
// 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位
//时才能向 右 移动。
// 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
//
//
// 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
// 输入：start = "_L__R__R_", target = "L______RR"
//输出：true
//解释：可以从字符串 start 获得 target ，需要进行下面的移动：
//- 将第一个片段向左移动一步，字符串现在变为 "L___R__R_" 。
//- 将最后一个片段向右移动一步，字符串现在变为 "L___R___R" 。
//- 将第二个片段向右移动散步，字符串现在变为 "L______RR" 。
//可以从字符串 start 得到 target ，所以返回 true 。
//
//
// 示例 2：
//
// 输入：start = "R_L_", target = "__LR"
//输出：false
//解释：字符串 start 中的 'R' 片段可以向右移动一步得到 "_RL_" 。
//但是，在这一步之后，不存在可以移动的片段，所以无法从字符串 start 得到 target 。
//
//
// 示例 3：
//
// 输入：start = "_R", target = "R_"
//输出：false
//解释：字符串 start 中的片段只能向右移动，所以无法从字符串 start 得到 target 。
//
//
//
// 提示：
//
//
// n == start.length == target.length
// 1 <= n <= 10⁵
// start 和 target 由字符 'L'、'R' 和 '_' 组成
//
//
// Related Topics 双指针 字符串 👍 58 👎 0


package com.jue.java.learn.leetcode.editor.cn.MovePiecesToObtainAString;

/**
 * @author JUE
 * @number 2337
 */
public class MovePiecesToObtainAString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canChange("_L__R__R_", "L______RR")); // true
        System.out.println(solution.canChange("R_L_", "__LR")); // false
        System.out.println(solution.canChange("_R", "R_")); // false
        System.out.println(solution.canChange("R__L", "_LR_")); // false
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canChange(String start, String target) {
        // LR 的顺序必须要一致
        if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
            return false;
        }

        // 先判断`L`字符是否能够符合位置；如果位置中间有R字符间隔，直接返回false，
        int len = start.length();
        int indexStart = 0;
        for (int index = 0; index < len; index++) {
            if (target.charAt(index) == 'L') {
                if (indexStart < index) {
                    indexStart = index;
                }
                boolean find = false;
                while (indexStart < len) {
                    char charStart = start.charAt(indexStart++);
                    if (charStart == 'R') {
                        return false;
                    }
                    if (charStart == 'L') {
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    return false;
                }
            }
        }
        // 右边没有其他L
        while (indexStart < len) {
            if (start.charAt(indexStart) == 'L') {
                return false;
            }
            indexStart++;
        }
        indexStart = len - 1;
        for (int index = len - 1; index >= 0; index--) {
            if (target.charAt(index) == 'R') {
                if (indexStart > index) {
                    indexStart = index;
                }
                boolean find = false;
                while (indexStart >= 0) {
                    char charStart = start.charAt(indexStart--);
                    if (charStart == 'L') {
                        return false;
                    }
                    if (charStart == 'R') {
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    return false;
                }
            }
        }
        // 左边没有其他R
        while (indexStart >= 0) {
            if (start.charAt(indexStart) == 'R') {
                return false;
            }
            indexStart--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
