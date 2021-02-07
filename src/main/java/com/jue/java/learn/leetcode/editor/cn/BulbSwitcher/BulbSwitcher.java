//初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启
//则关闭）。第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡。 
//
// 示例: 
//
// 输入: 3
//输出: 1 
//解释: 
//初始时, 灯泡状态 [关闭, 关闭, 关闭].
//第一轮后, 灯泡状态 [开启, 开启, 开启].
//第二轮后, 灯泡状态 [开启, 关闭, 开启].
//第三轮后, 灯泡状态 [开启, 关闭, 关闭]. 
//
//你应该返回 1，因为只有一个灯泡还亮着。
// 
// Related Topics 脑筋急转弯 数学


package com.jue.java.learn.leetcode.editor.cn.BulbSwitcher;

/**
 * @author JUE
 * @number 319
 */
public class BulbSwitcher {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bulbSwitch(4));
        System.out.println(solution.bulbSwitch(5));
        System.out.println(solution.bulbSwitch(6));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 所有的完全平方数
    public int bulbSwitch(int n) {
//        return (int) Math.sqrt(n * 1.0);
        if (n == 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int result = 1;
        while (result * result <= n) {
            result++;
        }
        return result - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_Timeout {
    public int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int sum = n;
        boolean[] array = new boolean[n + 1];
        for (int index = 2; index <= n; index++) {
            int mul = 1;
            while (index * mul <= n) {
                // false 为开启
                if (array[index * mul]) {
                    array[index * mul] = false;
                    sum++;
                } else {
                    array[index * mul] = true;
                    sum--;
                }
                mul++;
            }
        }
        return sum;
    }

    public int bulbSwitch_OutTime(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 1;
        for (int i = 4; i <= n; i++) {
            // 找出不重复的素数因子个数
            int count = 1;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count % 2 == 0) {
                sum++;
            }
        }
        return sum;
    }
}
