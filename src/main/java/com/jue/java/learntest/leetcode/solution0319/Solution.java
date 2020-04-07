package com.jue.java.learntest.leetcode.solution0319;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).bulbSwitch(4));
        System.out.println((new Solution()).bulbSwitch(5));
        System.out.println((new Solution()).bulbSwitch(6));
    }

    // 所有的完全平方数
    public int bulbSwitch_Perfect(int n) {
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