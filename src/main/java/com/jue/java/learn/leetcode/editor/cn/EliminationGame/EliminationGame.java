//给定一个从1 到 n 排序的整数列表。 
//首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。 
//第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。 
//我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。 
//返回长度为 n 的列表中，最后剩下的数字。 
//
// 示例： 
//
// 
//输入:
//n = 9,
//1 2 3 4 5 6 7 8 9
//2 4 6 8
//2 6
//6
//
//输出:
//6 
// Related Topics 数学 👍 143 👎 0


package com.jue.java.learn.leetcode.editor.cn.EliminationGame;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @number 390
 */
public class EliminationGame {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(9)); // 6
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n) {
        // 无法使用暴力
        // 剩余数量，每次取二的商
        int remain = n;
        int first = 1;
        int step = 1;
        boolean left = true;
        while (remain > 1) {
            if (left || (remain & 1) == 1) {
                first += step;
            }
            step <<= 1;
            remain >>= 1;
            left = !left;
        }
        return first;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class SolutionTimeOut {
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        // 目前采用双栈的暴力方式
        // 第一轮 只留偶数
        List<Integer> result = new ArrayList<>();
        for (int index = 1; index <= n; index++) {
            if (index % 2 == 0) {
                result.add(index);
            }
        }
        // 后面进行循环
        List<Integer> temp;
        boolean leftToRight = false;
        while (result.size() > 1) {
            temp = new ArrayList<>();
            boolean push = false;
            while (!result.isEmpty()) {
                int num = result.remove(leftToRight ? 0 : result.size() - 1);
                if (push) {
                    if (leftToRight) {
                        temp.add(num);
                    } else {
                        temp.add(0, num);
                    }
                    ;
                }
                push = !push;
            }
            leftToRight = !leftToRight;
            result = temp;
        }
        return result.get(0);
    }
}


