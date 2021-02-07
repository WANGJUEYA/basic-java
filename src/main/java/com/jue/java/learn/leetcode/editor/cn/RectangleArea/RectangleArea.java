//在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。 
//
// 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。 
//
// 
//
// 示例: 
//
// 输入: -3, 0, 3, 4, 0, -1, 9, 2
//输出: 45 
//
// 说明: 假设矩形面积不会超出 int 的范围。 
// Related Topics 数学


package com.jue.java.learn.leetcode.editor.cn.RectangleArea;

import java.util.Arrays;

/**
 * @author JUE
 * @number 223
 */
public class RectangleArea {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = ((C - A) * (D - B)) + ((G - E) * (H - F));
        if ((E > A && E > C) || (G < A && G < C) || (F > B && F > D) || (H < B && H < D)) {
            return sum;
        }

        int[] x = {A, C, E, G};
        int[] y = {B, D, F, H};
        Arrays.sort(x);
        Arrays.sort(y);
        return sum - (x[2] - x[1]) * (y[2] - y[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
