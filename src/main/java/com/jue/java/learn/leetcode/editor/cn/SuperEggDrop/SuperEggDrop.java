//你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N 共有 N 层楼的建筑。 
//
// 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。 
//
// 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。 
//
// 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。 
//
// 你的目标是确切地知道 F 的值是多少。 
//
// 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？ 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：K = 1, N = 2
//输出：2
//解释：
//鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
//否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
//如果它没碎，那么我们肯定知道 F = 2 。
//因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
// 
//
// 示例 2： 
//
// 输入：K = 2, N = 6
//输出：3
// 
//
// 示例 3： 
//
// 输入：K = 3, N = 14
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= K <= 100 
// 1 <= N <= 10000 
// 
// Related Topics 数学 二分查找 动态规划


package com.jue.java.learn.leetcode.editor.cn.SuperEggDrop;

/**
 * @author JUE
 * @number 887
 */
public class SuperEggDrop {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.superEggDrop(1, 2));
//        System.out.println(solution.superEggDrop(2, 6));
        System.out.println(solution.superEggDrop(3, 14));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int superEggDrop(int K, int N) {
        if (N == 1) {
            return 1;
        }
        if (K == 1) {
            return N;
        }
        // F(K,N) = min ->  { max{ F(K-1,P), F(K,N-P)} }

        // N(K,A) = N(K,A-1) + N(K-1,A-1) + 1;
        int[] pre = new int[K + 1], current;
        for (int j = 1; j <= K; j++) {
            pre[j] = 1;
        }
        int A = 2;
        while (true) {
            current = new int[K + 1];
//            System.out.println(Arrays.toString(pre));
            for (int j = 1; j <= K; j++) {
                current[j] = pre[j] + pre[j - 1] + 1;
                if (current[j] >= N) {
                    return A;
                }
            }
            A++;
            pre = current;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_Perfect {

    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int ans = 0;    // 操作的次数
        // !!!! 从后往前计算可以节省 K+1 的空间
        while (dp[K] < N) {
            for (int i = K; i > 0; i--) // 从后往前计算
                dp[i] = dp[i] + dp[i - 1] + 1;
            ans++;
        }
        return ans;
    }
}
