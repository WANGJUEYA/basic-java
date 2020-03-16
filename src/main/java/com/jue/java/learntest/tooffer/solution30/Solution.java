package com.jue.java.learntest.tooffer.solution30;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        System.out.println((new Solution()).GetLeastNumbers_Solution(input,4));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int len = input.length;
        if (k < 0 || k > len) {
            return result;
        }
        for (int i = 0; i < len && k > 0; i++, k--) {
            int index = i;
            for (int j = i; j < len; j++) {
                if (input[j] < input[index]) {
                    index = j;
                }
            }
            int temp = input[index];
            input[index] = input[i];
            result.add(temp);
        }
        return result;
    }
}