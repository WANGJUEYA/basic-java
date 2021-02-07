package com.jue.java.learn.tooffer.solution32;

public class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).NumberOf1Between1AndN_Solution(13));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        //最笨的遍历
        for (int i = 1; i <= n; i++) {
            int temp = i;
            do {
                if (temp % 10 == 1) {
                    count++;
                }
            } while ((temp = temp / 10) > 0);
        }
        return count;
    }
}

class SolutionPerfect {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0)
            return 0;
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }
}