package com.jue.java.learn.tooffer.solution25;

public class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).LastRemaining_Solution(5, 2));
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 1 || m <= 0) {
            return -1;
        }
        boolean[] childs = new boolean[n];
        int len = n;
        int index = 0;
        int loop = m;
        while (n > 0) {
            while (loop > 0) {
                if (!childs[index]) {
                    loop--;
                    if (n == 1) {
                        return index;
                    }
                    if (loop == 0) {
                        childs[index] = true;
                    }
                }
                index = (index + 1) % len;
            }
            loop = m;
            n--;
        }
        return 0;
    }
}

class SolutionPerfect {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        int s = 0;
        for (int i = 2; i <= n; i++) {
            s = (s + m) % i;
        }
        return s;
    }
}