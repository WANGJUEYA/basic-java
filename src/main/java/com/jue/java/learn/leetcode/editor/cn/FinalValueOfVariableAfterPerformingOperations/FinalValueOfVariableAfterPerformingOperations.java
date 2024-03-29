//存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：
//
//
// ++X 和 X++ 使变量 X 的值 加 1
// --X 和 X-- 使变量 X 的值 减 1
//
//
// 最初，X 的值是 0
//
// 给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。
//
//
//
// 示例 1：
//
//
//输入：operations = ["--X","X++","X++"]
//输出：1
//解释：操作按下述步骤执行：
//最初，X = 0
//--X：X 减 1 ，X =  0 - 1 = -1
//X++：X 加 1 ，X = -1 + 1 =  0
//X++：X 加 1 ，X =  0 + 1 =  1
//
//
// 示例 2：
//
//
//输入：operations = ["++X","++X","X++"]
//输出：3
//解释：操作按下述步骤执行：
//最初，X = 0
//++X：X 加 1 ，X = 0 + 1 = 1
//++X：X 加 1 ，X = 1 + 1 = 2
//X++：X 加 1 ，X = 2 + 1 = 3
//
//
// 示例 3：
//
//
//输入：operations = ["X++","++X","--X","X--"]
//输出：0
//解释：操作按下述步骤执行：
//最初，X = 0
//X++：X 加 1 ，X = 0 + 1 = 1
//++X：X 加 1 ，X = 1 + 1 = 2
//--X：X 减 1 ，X = 2 - 1 = 1
//X--：X 减 1 ，X = 1 - 1 = 0
//
//
//
//
// 提示：
//
//
// 1 <= operations.length <= 100
// operations[i] 将会是 "++X"、"X++"、"--X" 或 "X--"
//
//
// Related Topics 数组 字符串 模拟 👍 27 👎 0


package com.jue.java.learn.leetcode.editor.cn.FinalValueOfVariableAfterPerformingOperations;

import java.util.Arrays;

/**
 * @author JUE
 * @number 2011
 */
public class FinalValueOfVariableAfterPerformingOperations {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        return Arrays.stream(operations).mapToInt(item -> item.contains("+") ? 1 : -1).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
