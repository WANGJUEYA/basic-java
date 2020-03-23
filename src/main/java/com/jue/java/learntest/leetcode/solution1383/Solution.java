package com.jue.java.learntest.leetcode.solution1383;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int[] speed1 = {2, 5, 5, 5};
        int[] efficiency1 = {3, 3, 3, 5};
        int[] speed2 = {2, 8, 2};
        int[] efficiency2 = {2, 7, 1};
//        System.out.println((new Solution()).maxPerformance(6, speed, efficiency, 4));
//        System.out.println((new Solution()).maxPerformance(4, speed1, efficiency1, 4));
        System.out.println((new Solution()).maxPerformance(3, speed2, efficiency2, 2));
    }

    // 排序+堆
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] array = new int[n][2];
        for (int index = 0; index < n; index++) {
            array[index][0] = speed[index];
            array[index][1] = efficiency[index];
        }
        Arrays.sort(array, Comparator.comparingInt(a -> -a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long sum = 0;
        long max = Integer.MIN_VALUE;
        for (int index = 0; index < n; index++) {
            sum += array[index][0];
            queue.add(array[index][0]);
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            max = Math.max(max, sum * array[index][1]);
        }
        return (int) (max % (int) (1e9 + 7));
    }
}

class Solution_WRONG {
    public static void main(String[] args) {
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int[] speed1 = {2, 5, 5, 5};
        int[] efficiency1 = {3, 3, 3, 5};
        int[] speed2 = {2, 8, 2};
        int[] efficiency2 = {2, 7, 1};
//        System.out.println((new Solution_WRONG()).maxPerformance(6, speed, efficiency, 4));
//        System.out.println((new Solution_WRONG()).maxPerformance(4, speed1, efficiency1, 4));
        System.out.println((new Solution_WRONG()).maxPerformance(3, speed2, efficiency2, 2));
    }

    // 动态规划
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long[] every = new long[n];
        long sum = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int eIndex = 0;
        for (int index = 0; index < n; index++) {
            every[index] = speed[index] * efficiency[index];
            if (every[index] > sum || (every[index] == sum && efficiency[index] > efficiency[eIndex])) {
                sum = every[index];
                min = efficiency[index];
                eIndex = index;
            }
        }
        int choose = 1;
        int num = n - 1;
        every[eIndex] = -1;
        while (num > 0 && choose < k) {
            long sumRe = -1;
            int minRe = min;
            int eIndexRe = eIndex;
            for (int index = 0; index < n; index++) {
                if (every[index] < 0) {
                    continue;
                }
                long sumTemp = efficiency[index] >= min ? (sum + min * speed[index]) : ((sum / min + speed[index]) * efficiency[index]);
                // 不能直接剪枝
                if (sumTemp >= sum) {
                    if (sumTemp > sumRe || (sumTemp == sumRe && efficiency[index] > efficiency[eIndexRe])) {
                        sumRe = sumTemp;
                        minRe = Math.min(minRe, efficiency[index]);
                        eIndexRe = index;
                    }
                }
            }
            if (sumRe > 0) {
                choose++;
                sum = sumRe;
                min = minRe;
                eIndex = eIndexRe;
                every[eIndexRe] = -1;
                num--;
            } else {
                return (int) (sum % (int) (1e9 + 7));
            }
        }
        return (int) (sum % (int) (1e9 + 7));
    }
}

class Solution_EqualK {
    private static final int MOD = (int) (Math.pow(10, 9) + 7);

    // 方法1: 暴力穷举法
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        // 考虑动态规划? 时间复杂度 n*k
        // 1. 先将前k位放入
        int[][] array = new int[2][k];
        int speedSum = 0;
        int efficiencyMin = Integer.MAX_VALUE;
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for (int index = 0; index < k; index++) {
            array[0][index] = speed[index];
            array[1][index] = efficiency[index];
            speedSum += speed[index];
            int efficiencyTemp = (speed[index] * efficiency[index]) % MOD;
            if (efficiencyTemp < efficiencyMin || (efficiencyTemp == efficiencyMin && array[1][index] < array[1][minIndex])) {
                efficiencyMin = efficiencyTemp;
                minIndex = index;
            }
            min = Math.min(min, efficiency[index]);
        }

        int max = (speedSum * min) % MOD;
        for (int index = k; index < n; index++) {
            int speedSub = speed[index] - array[0][minIndex];
            int efficiencyTemp = (speed[index] * efficiency[index]) % MOD;
            if (efficiencyTemp >= efficiencyMin) {
                int speedSumRe = speedSum + speedSub;
                min = efficiency[index];
                for (int j = 0; j < k; j++) {
                    if (j == minIndex) {
                        continue;
                    }
                    min = Math.min(min, array[1][j]);
                }
                int maxRe = (speedSumRe * min) % MOD;
                if (maxRe > max) {
                    array[0][minIndex] = speed[index];
                    array[1][minIndex] = efficiency[index];
                    speedSum = speedSumRe;
                    max = maxRe;
                    minIndex = minIndex(array, k);
                    efficiencyMin = (speed[index] * efficiency[index]) % MOD;
                }
            }
        }
        return max;
    }

    // 求一组数中的最小总质量
    public int minIndex(int[][] array, int k) {
        int result = -1; // -1表示给定的数是最小的
        int efficiencyMin = Integer.MAX_VALUE;
        for (int index = 0; index < k; index++) {
            int efficiencyTemp = (array[0][index] * array[1][index]) % MOD;
            if (efficiencyTemp < efficiencyMin || (efficiencyTemp == efficiencyMin && array[1][index] < array[1][result])) {
                result = index;
                efficiencyMin = efficiencyTemp;
            }
        }
        return result;
    }
}