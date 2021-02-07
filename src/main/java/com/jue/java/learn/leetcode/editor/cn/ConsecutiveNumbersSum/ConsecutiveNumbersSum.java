//给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N? 
//
// 示例 1: 
//
// 
//输入: 5
//输出: 2
//解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。 
//
// 示例 2: 
//
// 
//输入: 9
//输出: 3
//解释: 9 = 9 = 4 + 5 = 2 + 3 + 4 
//
// 示例 3: 
//
// 
//输入: 15
//输出: 4
//解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5 
//
// 说明: 1 <= N <= 10 ^ 9 
// Related Topics 数学


package com.jue.java.learn.leetcode.editor.cn.ConsecutiveNumbersSum;

/**
 * @author JUE
 * @number 829
 */
public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.consecutiveNumbersSum(5));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int consecutiveNumbersSum(int N) {
        // (a1+an)*n/2 => (a1+a1+n-1)*n/2 => n = (2*N + 1) - 2*a1 > 0
        int count = 0;
        for (int index = 1; index <= N; index++) {
            if ((2 * N + 1) - 2 * index > 0) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_Perfect {
    /**
     * 在 2N = k(2x + k + 1)2N=k(2x+k+1) 中，我们可以发现 k < 2x + k + 1k<2x+k+1，因此有 k < sqrt{2N}k< 2N，
     * 即我们只需要枚举 1 <= k <= sqrt{2N} 即可，此时通过枚举可以通过本题。
     * 我们还可以继续挖掘一些性质。由于 kk 和 2x + k + 12x+k+1 的奇偶性不同，此时将 2N2N 写成 2^a * M
     * α 为 2N 中因子 2 的个数，M 为一个奇数。对于 M 的一种拆分 M = a * b, a≤b，可以将 2N 分成奇数 a 和偶数 2^a * a
     * 每一种分配方法中，将小的那个数给 k，大的那个数给 2x + k + 1 就对应了一组解，
     * 那么一种拆分方法对应了两组解。如果不限制 a≤b，那么可以看作一种拆分方法对应了一组解。
     * 有一种特殊情况是 a = b 此时这种拆分方法只对应了一组解，但仍然和之前的对应（一对一）相同。
     * 因此，我们只需要求出 M 的拆分方法即可，其中 M 为 N 的最大奇因子。M 的拆分方法等价于 M 的因子个数。
     */
    public int consecutiveNumbersSum(int N) {
        while ((N & 1) == 0) N >>= 1;
        int ans = 1, d = 3;

        while (d * d <= N) {
            int e = 0;
            while (N % d == 0) {
                N /= d;
                e++;
            }
            ans *= e + 1;
            d += 2;
        }

        if (N > 1) ans <<= 1;
        return ans;
    }
}