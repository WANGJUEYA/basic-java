package com.jue.java.learntest.leetcode.solution0830;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
//        System.out.println((new Solution()).largeGroupPositions("abbxxxxzzy"));
        System.out.println((new Solution()).largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println((new Solution()).largeGroupPositions("aaa"));
        System.out.println((new Solution()).largeGroupPositions("nnnhaaannnm"));
    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        char last = ' ';
        int beginIndex = 0;
        for (int index = 0, len = S.length(); index < len; index++) {
            char c = S.charAt(index);
            if (c != last) {
                if (index - beginIndex >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(beginIndex);
                    temp.add(index - 1);
                    result.add(temp);
                }
                last = c;
                beginIndex = index;
            }
        }
        if (S.length() - beginIndex >= 3) {
            List<Integer> temp = new ArrayList<>();
            temp.add(beginIndex);
            temp.add(S.length() - 1);
            result.add(temp);
        }
        return result;
    }
}