package com.jue.java.learn.tooffer.solution51;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.FindContinuousSequence(3));
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //公式 n^2 + (2x-1)n - c 中的C
        for (int i = 2, c = sum * 2, n = (int) Math.ceil(Math.sqrt(c)); i < n; i++) {
            if (0 == c % i) {
                int sub = (c / i) - i;
                if (0 < sub && 0 != sub % 2) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    for (int p = 0, begin = (sub + 1) / 2; p < i; p++, begin++) {
                        temp.add(begin);
                    }
                    result.add(0, temp);
                }
            }
        }
        return result;
    }
}