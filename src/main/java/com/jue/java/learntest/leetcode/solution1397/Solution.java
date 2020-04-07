package com.jue.java.learntest.leetcode.solution1397;

/**
 * @author JUE
 * @date 2020/3/29
 * @note 0 error(s), 0 warning(s)
 **/
class Solution {
    public static void main(String[] args) {
//        System.out.println((new Solution()).findGoodStrings(2, "aa", "da", "b"));
//        System.out.println((new Solution()).findGoodStrings(2, "gx", "gz", "x"));
//        System.out.println((new Solution()).findGoodStrings(8, "leetcode", "leetgood", "leet"));
        System.out.println((new Solution()).findGoodStrings(3, "szc", "zyi", "p")); // 4357
    }

    int MOD = (int) (1E9 + 7);
    int[][][] dp;
    int[][] trans;
    int[] next;
    int N;
    String S1;
    String S2;
    int LEN;
    String EVIL;

    // 先单纯使用暴力搜索的方法 计算有多少字符包含evil
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        N = n;
        S1 = s1;
        S2 = s2;
        EVIL = evil;
        LEN = evil.length();
        // KMP 得到evil 数组最长前缀后缀数组
        next = new int[LEN + 1];
        int next_i = 0, next_j = -1;
        next[0] = -1;
        while (next_i < LEN) {
            if (next_j == -1 || evil.charAt(next_i) == evil.charAt(next_j)) {
                next[++next_i] = ++next_j;
            } else {
                next_j = next[next_j];
            }
        }

        // 数位DP int[pos][stats][bound] = num; pos s1/s2 数组的第pos位; stats 某串的后缀与 evil最长匹配前缀; bound边界状态
        dp = new int[n][LEN][4]; // 00 01 10 11
        trans = new int[LEN][26];
        return dfs(0, 0, 3);
    }

    // 这是计算关于 stats 的转移函数
    // 输入为 stats 和 d
    // 输出为转移的结果 g_s(stats, d)
    private int getTrans(int stats, char ch) {
        int chInt = ch - 'a';
        // 如果之前计算过该转移函数就直接返回结果
        if (trans[stats][chInt] != 0) {
            return trans[stats][chInt];
        }
        // 这是 KMP 算法的一部分
        // 把 evil 看作「模式串」，stats 看作「主串」匹配到的位置
        int s = stats;
        while (s >= 0 && EVIL.charAt(s) != ch) {
            s = next[s];
        }
        // 存储结果并返回
        return trans[stats][chInt] = s + 1;
    }

    // 这是用来进行记忆化搜索的函数
    int dfs(int pos, int stats, int bound) {
        // 如果匹配到了 evil 的末尾
        // 说明字符串不满足要求了
        // 返回 0
        if (stats == LEN) {
            return 0;
        }
        // 如果匹配到了上下界的末尾
        // 说明找到了一个满足要求的字符串
        // 返回 1
        if (pos == N) {
            return 1;
        }
        // 记忆化搜索的关键
        // 如果之前计算过该状态就直接返回结果
        if (dp[pos][stats][bound] != 0) {
            return dp[pos][stats][bound];
        }

        // 将当前状态初始化
        dp[pos][stats][bound] = 0;
        // 计算第 pos 位可枚举的字符下界
        char l = ((bound == 1 || bound == 3) ? S1.charAt(pos) : 'a');
        // 计算第 pos 位可枚举的字符上界
        char r = ((bound == 2 || bound == 3) ? S2.charAt(pos) : 'z');
        for (char ch = l; ch <= r; ch++) {
            int nxt_stats = getTrans(stats, ch);
            // 这里写得较为复杂
            // 本质上就是关于 bound 的转移函数
            // 可以根据自己的理解编写
            // int nxt_bound = (bound & 1 ? ch == s1[pos] : 0) ^ (bound & 2 ? (ch == s2[pos]) << 1 : 0);

            int nxt_bound = 0;
            if (bound == 1 && S1.charAt(pos) == ch) {
                nxt_bound = 1;
            } else if (bound == 2 && S2.charAt(pos) == ch) {
                nxt_bound = 2;
            } else if (bound == 3) {
                if (S1.charAt(pos) == ch && S2.charAt(pos) == ch) {
                    nxt_bound = 3;
                } else if (S1.charAt(pos) == ch) {
                    nxt_bound = 1;
                } else if (S2.charAt(pos) == ch) {
                    nxt_bound = 2;
                }
            }

            dp[pos][stats][bound] += dfs(pos + 1, nxt_stats, nxt_bound);
            dp[pos][stats][bound] %= MOD;
        }
        return dp[pos][stats][bound];
    }
}

class Solution_NeedFix {
    public static void main(String[] args) {
        System.out.println((new Solution_NeedFix()).findGoodStrings(2, "aa", "da", "b"));
        System.out.println((new Solution_NeedFix()).findGoodStrings(2, "gx", "gz", "x"));
        System.out.println((new Solution_NeedFix()).findGoodStrings(8, "leetcode", "leetgood", "leet"));
    }

    long MOD = (long) (1E9 + 7);

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        if (s1.equals(s2)) {
            return s1.equals(evil) ? 0 : 1;
        }
        // s1 放更小的
        if (s1.compareTo(s2) > 0) {
            return 0;
        }

        long total = sub(s1, s2);
        long bad = 0;
        int len = evil.length();
        int midCount = 0;
        System.out.println("total: " + total);
        for (int index = -1; index < n - len; index++) {
            String begin1 = s1.substring(0, index + 1);
            String begin2 = s2.substring(0, index + 1);
            String mid1 = s1.substring(index + 1, index + len + 1);
            String mid2 = s2.substring(index + 1, index + len + 1);
            String end1 = s1.substring(index + len + 1);
            String end2 = s2.substring(index + len + 1);

            // 如果字符串在其中
            long begin = sub(begin1, begin2) - midCount;
            long sub;

            if (mid1.compareTo(evil) <= 0 && mid2.compareTo(evil) >= 0) {
                if (mid1.equals(mid2)) {
                    sub = sub(end1, end2);
                } else if (evil.equals(mid1)) {
                    int lens1 = s1.length();
                    StringBuilder end = new StringBuilder();
                    while ((lens1--) > 0) {
                        end.append("z");
                    }
                    sub = sub(end1, end.toString());
                } else if (evil.equals(mid2)) {
                    int lens2 = s2.length();
                    StringBuilder end = new StringBuilder();
                    while ((lens2--) > 0) {
                        end.append("a");
                    }
                    sub = sub(end.toString(), end1);
                } else {
                    sub = pow(26, n - len - index - 1);
                }
                midCount++;
            } else {
                begin--;
                sub = 1;
            }
            bad += (begin * sub) % MOD;
            bad = bad % MOD;
            if (bad >= total) {
                return 0;
            }
            System.out.println("bad: " + bad);
        }

        return (int) (total - bad);
    }

    // 计算两个字符串间的距离
    public long sub(String s1, String s2) {
        int n = s1.length();
        if (n <= 0 || s1.equals(s2)) {
            return 1;
        }
        if (s1.compareTo(s2) > 0) {
            return 0;
        }
        int first = s2.charAt(0) - s1.charAt(0);
        long base = first == 0 ? 0 : (first * pow(26, n - 1)) % MOD;
        long sub = sub(s1.substring(1), s2.substring(1));
        return (base + sub) % MOD;
    }

    // 快速幂
    public long pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int temp = b / 2;
        if (b % 2 == 0) {
            return (pow(a, temp) * pow(a, temp)) % MOD;
        } else {
            return (a * pow(a, temp) * pow(a, temp)) % MOD;
        }
    }
}
