package com.jue.java.learntest.tooffer.solution67;

/**
 * @author jue
 * @date 2019/10/30
 * note no error(0) no warning(0)
 **/
public class Solution {
    // 采用动态规划的算法 令最大值初始为零
    // 我们已知和同的两组数差越小乘积越大???需要证明过程嘛? ->已经证明
    // a1^2+b1^2-(a1-b1)^2 = a2^2+b2^2-(a2-b2)^2
    // 2a1b1-(a1-b1)^2 = 2a2b2-(a2-b2)^2
    // 三个数如何证明不得而知,我们便靠暴力方式穷举
    public int cutRope(int target) {
        double max = 0;
        for (int i = 0; i < target; i++) {
            double floor = Math.floor((target - i) / 2.0);
            double ceil = Math.ceil((target - i) / 2.0);
            double tempMax = Math.max(floor, 1) * Math.max(ceil, 1) * Math.max(i, 1);
            max = Math.max(tempMax, max);
        }
        return (int) max;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).cutRope(2));
        System.out.println((new Solution()).cutRope(4));
        System.out.println((new Solution()).cutRope(8));
    }
}
