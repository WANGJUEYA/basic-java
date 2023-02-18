//给你一个函数 f(x, y) 和一个目标结果 z，函数公式未知，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。满足条件的结果数对
//可以按任意顺序返回。 
//
// 尽管函数的具体式子未知，但它是单调递增函数，也就是说： 
//
// 
// f(x, y) < f(x + 1, y) 
// f(x, y) < f(x, y + 1) 
// 
//
// 函数接口定义如下： 
//
// 
//interface CustomFunction {
//public:
//  // Returns some positive integer f(x, y) for two positive integers x and y 
//based on a formula.
//  int f(int x, int y);
//}; 
//
// 你的解决方案将按如下规则进行评判： 
//
// 
// 判题程序有一个由 CustomFunction 的 9 种实现组成的列表，以及一种为特定的 z 生成所有有效数对的答案的方法。 
// 判题程序接受两个输入：function_id（决定使用哪种实现测试你的代码）以及目标结果 z 。 
// 判题程序将会调用你实现的 findSolution 并将你的结果与答案进行比较。 
// 如果你的结果与答案相符，那么解决方案将被视作正确答案，即 Accepted 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：function_id = 1, z = 5
//输出：[[1,4],[2,3],[3,2],[4,1]]
//解释：function_id = 1 暗含的函数式子为 f(x, y) = x + y
//以下 x 和 y 满足 f(x, y) 等于 5：
//x=1, y=4 -> f(1, 4) = 1 + 4 = 5
//x=2, y=3 -> f(2, 3) = 2 + 3 = 5
//x=3, y=2 -> f(3, 2) = 3 + 2 = 5
//x=4, y=1 -> f(4, 1) = 4 + 1 = 5
// 
//
// 示例 2： 
//
// 
//输入：function_id = 2, z = 5
//输出：[[1,5],[5,1]]
//解释：function_id = 2 暗含的函数式子为 f(x, y) = x * y
//以下 x 和 y 满足 f(x, y) 等于 5：
//x=1, y=5 -> f(1, 5) = 1 * 5 = 5
//x=5, y=1 -> f(5, 1) = 5 * 1 = 5 
//
// 
//
// 提示： 
//
// 
// 1 <= function_id <= 9 
// 1 <= z <= 100 
// 题目保证 f(x, y) == z 的解处于 1 <= x, y <= 1000 的范围内。 
// 在 1 <= x, y <= 1000 的前提下，题目保证 f(x, y) 是一个 32 位有符号整数。 
// 
//
// Related Topics 数学 双指针 二分查找 交互 👍 86 👎 0


package com.jue.java.learn.leetcode.editor.cn.FindPositiveIntegerSolutionForAGivenEquation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author JUE
 * @number 1237
 */
public class FindPositiveIntegerSolutionForAGivenEquation {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

abstract class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public abstract int f(int x, int y);
};

//leetcode submit region begin(Prohibit modification and deletion)
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        // 二分法（不一定对称 不然还能省）
        List<List<Integer>> result = new ArrayList<>();
        for (int index = 1; index <= 1000; index++) {
            int l = 1, h = 1000;
            while (l < h) {
                int mid = (l + h) / 2; // 取的下整
                int count = customfunction.f(index, mid);
                if (count == z) {
                    result.add(Stream.of(index, mid).collect(Collectors.toList()));
                    break;
                } else if (count > z) {
                    h = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
