//给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。 
//
// 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应
//该含有冗余的括号。 
//
// 示例： 
//
// 
//输入: [1000,100,10,2]
//输出: "1000/(100/10/2)"
//解释:
//1000/(100/10/2) = 1000/((100/10)/2) = 200
//但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
//因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
//
//其他用例:
//1000/(100/10)/2 = 50
//1000/(100/(10/2)) = 50
//1000/100/10/2 = 0.5
//1000/100/(10/2) = 2
// 
//
// 说明: 
//
// 
// 输入数组的长度在 [1, 10] 之间。 
// 数组中每个元素的大小都在 [2, 1000] 之间。 
// 每个测试用例只有一个最优除法解。 
// 
// Related Topics 数组 数学 动态规划 👍 100 👎 0


package com.jue.java.learn.leetcode.editor.cn.OptimalDivision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @number 553
 */
public class OptimalDivision {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("1000/(100/10/2)".equals(solution.optimalDivision(new int[]{1000, 100, 10, 2})));
        System.out.println("1000/(100/10/2)".equals(solution.optimalDivision(new int[]{297,139,80,717,137,490,654,141,227,315})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String optimalDivision(int[] nums) {
        // 尝试暴力递归法
        List<Double> group = new ArrayList<>();
        List<String> substr = new ArrayList<>();
        for (int num : nums) {
            group.add(1.0 * num);
            substr.add(String.valueOf(num));
        }
        optimalDivision(substr, group);
        double max = Double.MIN_VALUE;
        for (Double item : result.keySet()) {
            max = Math.max(max, item);
        }
        return result.get(max);
    }

    Map<Double, String> result = new HashMap<>();

    public void optimalDivision(List<String> substr, List<Double> group) {
        int len = group.size();
        if (len == 1) {
            // 这个时候需要告诉结果值是多少
            if (!result.containsKey(group.get(0)) || result.get(group.get(0)).length() > substr.get(0).length()) {
                result.put(group.get(0), substr.get(0));
            }
            return;
        }
        for (int index = 0; index < len - 1; index++) {
            List<String> substrCopy = new ArrayList<>(substr);
            List<Double> groupCopy = new ArrayList<>(group);
            Double current = (group.get(index) / group.get(index + 1));
            // 如果除数包含除号一定要加括号
            String second = substr.get(index + 1);
            String currentStr = substr.get(index) + "/" + (second.contains("/") ? "(" + second + ")" : second);
            groupCopy.remove(index);
            groupCopy.remove(index);
            groupCopy.add(index, current);
            substrCopy.remove(index);
            substrCopy.remove(index);
            substrCopy.add(index, currentStr);
            optimalDivision(substrCopy, groupCopy);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_Timeout {
    public String optimalDivision(int[] nums) {
        // 尝试暴力递归法
        List<Double> group = new ArrayList<>();
        List<String> substr = new ArrayList<>();
        for (int num : nums) {
            group.add(1.0 * num);
            substr.add(String.valueOf(num));
        }
        optimalDivision(substr, group);
        double max = Double.MIN_VALUE;
        for (Double item : result.keySet()) {
            max = Math.max(max, item);
        }
        return result.get(max);
    }

    Map<Double, String> result = new HashMap<>();

    public void optimalDivision(List<String> substr, List<Double> group) {
        int len = group.size();
        if (len == 1) {
            // 这个时候需要告诉结果值是多少
            if (!result.containsKey(group.get(0)) || result.get(group.get(0)).length() > substr.get(0).length()) {
                result.put(group.get(0), substr.get(0));
            }
            return;
        }
        for (int index = 0; index < len - 1; index++) {
            List<String> substrCopy = new ArrayList<>(substr);
            List<Double> groupCopy = new ArrayList<>(group);
            Double current = (group.get(index) / group.get(index + 1));
            // 如果除数包含除号一定要加括号
            String second = substr.get(index + 1);
            String currentStr = substr.get(index) + "/" + (second.contains("/") ? "(" + second + ")" : second);
            groupCopy.remove(index);
            groupCopy.remove(index);
            groupCopy.add(index, current);
            substrCopy.remove(index);
            substrCopy.remove(index);
            substrCopy.add(index, currentStr);
            optimalDivision(substrCopy, groupCopy);
        }
    }

}