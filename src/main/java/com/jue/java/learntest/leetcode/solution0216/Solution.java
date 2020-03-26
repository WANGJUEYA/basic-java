package com.jue.java.learntest.leetcode.solution0216;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).combinationSum3(3, 7));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(0, 1, k, n);
    }

    public List<List<Integer>> combinationSum3(int last, int len, int k, int n) {
//        System.out.println("(last,len,k,n) => " + last + "," + len + "," + k + "," + n);
        List<List<Integer>> result = new ArrayList<>();
        if (len > k) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        if (len == k && last < n && n >= 1 && n <= 9) {
            temp.add(n);
            result.add(temp);
            return result;
        }
        for (int index = last + 1; index < 10 && index <= n; index++) {
            List<List<Integer>> sub = combinationSum3(index, len + 1, k, n - index);
//            System.out.println(sub);
            for (List<Integer> s : sub) {
                s.add(index);
                result.add(s);
            }
        }
        return result;
    }
}