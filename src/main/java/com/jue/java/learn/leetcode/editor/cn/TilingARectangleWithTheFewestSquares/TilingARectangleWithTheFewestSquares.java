//你是一位施工队的工长，根据设计师的要求准备为一套设计风格独特的房子进行室内装修。
//
// 房子的客厅大小为 n x m，为保持极简的风格，需要使用尽可能少的 正方形 瓷砖来铺盖地面。
//
// 假设正方形瓷砖的规格不限，边长都是整数。
//
// 请你帮设计师计算一下，最少需要用到多少块方形瓷砖？
//
//
//
// 示例 1：
//
//
//
// 输入：n = 2, m = 3
//输出：3
//解释：3 块地砖就可以铺满卧室。
//     2 块 1x1 地砖
//     1 块 2x2 地砖
//
// 示例 2：
//
//
//
// 输入：n = 5, m = 8
//输出：5
//
//
// 示例 3：
//
//
//
// 输入：n = 11, m = 13
//输出：6
//
//
//
//
// 提示：
//
//
// 1 <= n <= 13
// 1 <= m <= 13
//
//
// Related Topics 动态规划 回溯 👍 127 👎 0


package com.jue.java.learn.leetcode.editor.cn.TilingARectangleWithTheFewestSquares;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 1240
 */
public class TilingARectangleWithTheFewestSquares {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tilingRectangle(11, 13));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    static final Map<String, Integer> STORE = new HashMap<>();

    public int tilingRectangle(int n, int m) {
        // 强暴力计算数据
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == n) {
            return 1;
        }
        int max = Math.max(m, n);
        int min = Math.min(m, n);

        String key = max + "," + min;
        if (STORE.containsKey(key)) {
            return STORE.get(key);
        }
        // 如果以上都不满足, 开始遍历每一种情况
        int count = m * n;
        for (int i = 0, len = min / 2; i <= len; i++) {
            // 减下一个正方型，剩下的两块扔去查最小
            int temp = 1 + tilingRectangle(i, min - i) + tilingRectangle(max - min, min);
            System.out.printf("(%s,%s) : %s %n", i, min - i, tilingRectangle(i, min - i));
            System.out.printf("(%s,%s) : %s %n", max - min, min, tilingRectangle(max - min, min));
            count = Math.min(count, temp);
            System.out.printf("count >>> %s %n", count);
        }
        STORE.put(key, count);
        System.out.printf("(%s,%s) : %s %n", max, min, count);
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class SolutionWrong {
    public int tilingRectangle(int n, int m) {
        // 不用缓存了, 直接强行计算
        // 有没有数学公式证明，一定每次取最大正方形就是最少的数量; fix 错误的考想象的公式
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == n) {
            return 1;
        }
        int max = Math.max(m, n);
        int min = Math.min(m, n);
        int count = max / min;
        int sub = max % min;
        if (sub != 0) {
            count += tilingRectangle(min, sub);
        }
        return count;
    }
}
