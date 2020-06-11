//根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表


package com.jue.java.learntest.leetcode.editor.cn.DailyTemperatures;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author JUE
 * @number 739
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(result));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] result = new int[len];
        if (len <= 1) {
            return result;
        }
        // 栈中始终存放当前的最大值
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int index = 1; index < len; index++) {
            while (!stack.isEmpty() && T[index] > T[stack.peek()]) {
                int tempIndex = stack.pop();
                result[tempIndex] = index - tempIndex;
            }
            stack.push(index);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
