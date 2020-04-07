package com.jue.java.learntest.leetcode.solution0887;

class Solution {
    public static void main(String[] args) {
//        System.out.println((new Solution()).superEggDrop(1, 2));
//        System.out.println((new Solution()).superEggDrop(2, 6));
        System.out.println((new Solution()).superEggDrop(3, 14));
    }

    public int superEggDrop_Perfect(int K, int N) {
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