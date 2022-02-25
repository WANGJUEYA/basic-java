//n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。 
//
// 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。 
//
// 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。 
//
// 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。 
//
// 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中： 
//
// 
// dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧， 
// dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧， 
// dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。 
// 
//
// 返回表示最终状态的字符串。 
// 
//
// 示例 1： 
//
// 
//输入：dominoes = "RR.L"
//输出："RR.L"
//解释：第一张多米诺骨牌没有给第二张施加额外的力。
// 
//
// 示例 2： 
//
// 
//输入：dominoes = ".L.R...LR..L.."
//输出："LL.RR.LLRRLL.."
// 
//
// 
//
// 提示： 
//
// 
// n == dominoes.length 
// 1 <= n <= 10⁵ 
// dominoes[i] 为 'L'、'R' 或 '.' 
// 
// Related Topics 双指针 字符串 动态规划 👍 228 👎 0


package com.jue.java.learn.leetcode.editor.cn.PushDominoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JUE
 * @number 838
 */
public class PushDominoes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("LL.RR.LLRRLL..".equals(solution.pushDominoes(".L.R...LR..L..")));
        System.out.println("RR.L".equals(solution.pushDominoes("RR.L")));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        char[] dp = dominoes.toCharArray();
        List<Integer> current = new ArrayList<>();
        for (int index = 0; index < len; index++) {
            if (dp[index] != '.') {
                current.add(index);
            }
        }
        while (!current.isEmpty()) {
            char[] dpCopy = Arrays.copyOf(dp, len);
            List<Integer> temp = new ArrayList<>();
            for (int idx : current) {
                if (dp[idx] == 'R') {
                    // 向右倒
                    if (idx < len - 1) {
                        if (dp[idx + 1] == '.') {
                            if (!(idx + 2 < len && dp[idx + 2] == 'L')) {
                                dpCopy[idx + 1] = 'R';
                                temp.add(idx + 1);
                            }
                        }
                    }
                } else {
                    // 向左倒
                    if (idx > 0) {
                        if (dp[idx - 1] == '.') {
                            if (!(idx - 2 >= 0 && dp[idx - 2] == 'R')) {
                                dpCopy[idx - 1] = 'L';
                                temp.add(idx - 1);
                            }
                        }
                    }

                }
            }
            dp = dpCopy;
            current = temp;
        }
        return new String(dp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
