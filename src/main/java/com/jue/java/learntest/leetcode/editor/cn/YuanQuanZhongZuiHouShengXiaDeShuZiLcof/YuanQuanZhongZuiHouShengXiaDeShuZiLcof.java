//0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。 
//
// 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。 
//
// 
//
// 示例 1： 
//
// 输入: n = 5, m = 3
//输出: 3
// 
//
// 示例 2： 
//
// 输入: n = 10, m = 17
//输出: 2
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10^5 
// 1 <= m <= 10^6 
// 
//


package com.jue.java.learntest.leetcode.editor.cn.YuanQuanZhongZuiHouShengXiaDeShuZiLcof;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @number 面试题62
 */
public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(5, 3));
        System.out.println(solution.lastRemaining(10, 17));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {
        List<String> number = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            number.add(index + "");
        }
        int i = (m - 1) % n;
        while (number.size() > 1) {
            number.remove(i);
            i = (i + m - 1) % number.size();
        }
        return Integer.parseInt(number.get(0));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
