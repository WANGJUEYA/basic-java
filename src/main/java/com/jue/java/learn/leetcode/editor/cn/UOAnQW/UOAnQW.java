//「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为
// `cnt` 张卡牌数字总和。
//给定数组 `cards` 和 `cnt`，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分
//的卡牌方案，则返回 0。
//
//**示例 1：**
//
//> 输入：`cards = [1,2,8,9], cnt = 3`
//>
//> 输出：`18`
//>
//> 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。
//
//**示例 2：**
//
//> 输入：`cards = [3,3,1], cnt = 1`
//>
//> 输出：`0`
//>
//> 解释：不存在获取有效得分的卡牌方案。
//
//**提示：**
//- `1 <= cnt <= cards.length <= 10^5`
//- `1 <= cards[i] <= 1000`
//
// Related Topics 贪心 数组 排序 👍 88 👎 0


package com.jue.java.learn.leetcode.editor.cn.UOAnQW;

import java.util.Arrays;

/**
 * @author JUE
 * @number LCP 40
 */
public class UOAnQW {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxmiumScore(new int[]{9, 5, 9, 1, 6, 10, 3, 4, 5, 1}, 2));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        // 动态规划
        int sum = 0;
        // 最小的偶数 和最小的奇数
        int[] min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int len = cards.length;
        for (int i = 1; i < cnt; i++) {
            int num = cards[len - i];
            min[num % 2] = Math.min(min[num % 2], num);
            sum += num;
        }
        if ((sum + cards[len - cnt]) % 2 == 0) {
            return sum + cards[len - cnt];
        } else {
            int firstDiff = 0;
            // 是个偶数: 找到一个偶数或者一对奇数
            int num1 = 0, num2 = 0;
            for (int i = len - cnt; i >= 0; i--) {
                if ((sum + cards[i]) % 2 == 0) {
                    if (num1 == 0) {
                        num1 = sum + cards[i];
                    }
                } else {
                    if (firstDiff == 0) {
                        firstDiff = cards[i];
                    } else if (num2 == 0) {
                        num2 = sum + firstDiff + cards[i] - min[sum % 2];
                    }
                }
            }
            return Math.max(num1, num2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
