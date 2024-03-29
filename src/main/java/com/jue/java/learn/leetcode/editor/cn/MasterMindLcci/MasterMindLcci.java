//珠玑妙算游戏（the game of master mind）的玩法如下。 
// 计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽
//4为蓝色）。作为用户，你试图猜出颜色组合。打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，则算一次“伪猜中”。
//注意，“猜中”不能算入“伪猜中”。 
// 给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer，其中answer[0]为猜中的次数，answer[
//1]为伪猜中的次数。 
// 示例： 
// 输入： solution="RGBY",guess="GGRR"
//输出： [1,1]
//解释： 猜中1次，伪猜中1次。
// 
// 提示： 
// 
// len(solution) = len(guess) = 4 
// solution和guess仅包含"R","G","B","Y"这4种字符 
// 
// Related Topics 哈希表 字符串 计数 👍 31 👎 0


package com.jue.java.learn.leetcode.editor.cn.MasterMindLcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JUE
 * @number 面试题 16.15
 */
public class MasterMindLcci {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.masterMind("RGBY", "GGRR")));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final List<Character> COLOR_INDEX = new ArrayList<>() {{
        add('R');
        add('Y');
        add('G');
        add('B');
    }};

    public int[] masterMind(String solution, String guess) {
        int rightCount = 0;
        int[][] count = new int[2][4];
        for (int index = 0, len = solution.length(); index < len; index++) {
            if (solution.charAt(index) == guess.charAt(index)) {
                rightCount++;
            } else {
                count[0][COLOR_INDEX.indexOf(solution.charAt(index))]++;
                count[1][COLOR_INDEX.indexOf(guess.charAt(index))]++;
            }
        }
        int followCount = 0;
        for (int index = 0; index < 4; index++) {
            followCount += Math.min(count[0][index], count[1][index]);
        }
        return new int[]{rightCount, followCount};
    }
}
//leetcode submit region end(Prohibit modification and deletion)


