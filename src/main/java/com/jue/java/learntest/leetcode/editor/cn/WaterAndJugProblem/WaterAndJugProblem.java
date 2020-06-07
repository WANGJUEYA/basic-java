//有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？ 
//
// 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。 
//
// 你允许： 
//
// 
// 装满任意一个水壶 
// 清空任意一个水壶 
// 从一个水壶向另外一个水壶倒水，直到装满或者倒空 
// 
//
// 示例 1: (From the famous "Die Hard" example) 
//
// 输入: x = 3, y = 5, z = 4
//输出: True
// 
//
// 示例 2: 
//
// 输入: x = 2, y = 6, z = 5
//输出: False
// 
// Related Topics 数学


package com.jue.java.learntest.leetcode.editor.cn.WaterAndJugProblem;

/**
 * @author JUE
 * @number 365
 */
public class WaterAndJugProblem {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canMeasureWater(3, 5, 0));
        System.out.println(solution.canMeasureWater(3, 5, 1));
        System.out.println(solution.canMeasureWater(3, 5, 2));
        System.out.println(solution.canMeasureWater(3, 5, 3));
        System.out.println(solution.canMeasureWater(3, 5, 4));
        System.out.println(solution.canMeasureWater(3, 5, 5));
        System.out.println(solution.canMeasureWater(3, 5, 6));
        System.out.println(solution.canMeasureWater(3, 5, 7));
        System.out.println(solution.canMeasureWater(3, 5, 8));
        System.out.println(solution.canMeasureWater(2, 6, 5));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean canMeasureWater(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || (x + y < z) || (x % 2 == 0 && y % 2 == 0 && z % 2 == 1)) {
            return false;
        }
        if (z == 0) {
            return true;
        }
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        while (max % min != 0) {
            int temp = (max % min);
            max = Math.max(temp, min);
            min = Math.min(temp, min);
        }
        return z % min == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_outTime {
    public boolean canMeasureWater_outTime(int x, int y, int z) {
        if (x < 0 || y < 0 || z < 0 || (x + y < z) || (x % 2 == 0 && y % 2 == 0 && z % 2 == 1)) {
            return false;
        }
        boolean[] flag = new boolean[x + y + 1];
        flag[0] = true;
        flag[x + y] = true;
        flag[x] = true;
        flag[y] = true;
        boolean circle = true; // 遍历进行
        int len = x + y + 1;
        while (circle) {
            circle = false;
            for (int i = 0; i < len; i++) {
                if (flag[i]) {
                    for (int j = 0; j < len; j++) {
                        if (flag[j]) {
                            int sum = i + j;
                            if (sum < len && !flag[sum]) {
                                circle = true;
                                flag[sum] = true;
                            }
                            int sub = Math.abs(i - j);
                            if (!flag[sub]) {
                                circle = true;
                                flag[sub] = true;
                            }
                        }
                    }
                }
            }
        }
        return flag[z];
    }
}
