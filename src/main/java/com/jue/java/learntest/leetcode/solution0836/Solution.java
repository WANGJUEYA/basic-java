package com.jue.java.learntest.leetcode.solution0836;

class Solution {
    public static void main(String[] args) {
//        System.out.println((new Solution()).isRectangleOverlap());
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !((rec1[2] <= rec2[0]) || (rec1[0] >= rec2[2]) || (rec1[3] <= rec2[1]) || (rec1[1] >= rec2[3]));
    }
}