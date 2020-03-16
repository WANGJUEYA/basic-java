package com.jue.java.learntest.leetcode.solution0279;


import java.util.ArrayList;
import java.util.List;

class Solution {

    public int numSquares(int n) {
        int[] num = new int[n + 1];
        for (int index = 0; index <= n; index++) {
            int min = index;
            for (int j = 1; index - j * j >= 0; j++) {
                min = Math.min(min, num[index - j * j] + 1);
            }
            num[index] = min;
        }
        return num[n];
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).numSquares(18));
    }
}


class Solution_WRONG {
    public int numSquares(int n) {
        // 是否需要证明完全平方数越大越好? ps: 已验证: 不是越大越好
        List<Integer> pow = new ArrayList<>();
        int base = 1, item;
        do {
            item = base * base;
            if (item == n) {
                return 1;
            }
            pow.add(item);
            base++;
        } while (item < n);
        int minCount = Integer.MAX_VALUE;

        for (int beginIndex = base - 3; beginIndex >= 0; beginIndex--) {
            int count = 1;
            int sub = n;
            sub -= pow.get(beginIndex);
            while (sub != 0) {
                // 利用二分查找快速找到
                int left = 0, right = base - 2;
                while (left < right) {
                    int index = (left + right) / 2;
                    if (pow.get(index) == sub) {
                        sub = 0;
                        count++;
                        break;
                    } else if (pow.get(index) > sub) {
                        if (pow.get(index - 1) <= sub) {
                            sub -= pow.get(index - 1);
                            count++;
                            break;
                        } else {
                            right = index - 1;
                        }
                    } else {
                        if (pow.get(index + 1) >= sub) {
                            sub -= pow.get(index);
                            count++;
                            break;
                        } else {
                            left = index + 1;
                        }
                    }
                }
            }
            minCount = Math.min(minCount, count);
        }

        return minCount;
    }

    public static void main(String[] args) {
//        System.out.println((new Solution()).numSquares(12));
//        System.out.println((new Solution()).numSquares(13));
        System.out.println((new Solution_WRONG()).numSquares(18));
    }
}