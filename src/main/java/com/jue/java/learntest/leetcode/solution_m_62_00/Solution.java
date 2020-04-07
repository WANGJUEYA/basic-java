package com.jue.java.learntest.leetcode.solution_m_62_00;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).lastRemaining(5, 3));
        System.out.println((new Solution()).lastRemaining(10, 17));
    }

    public int lastRemaining(int n, int m) {
        List<String> number = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            number.add(index + "");
        }
        int i = (m - 1) % n;
        while (number.size() > 1) {
            number.remove(i);
            i = (i + m - 1) % number.size();
        }
        return Integer.parseInt(number.get(0));
    }
}