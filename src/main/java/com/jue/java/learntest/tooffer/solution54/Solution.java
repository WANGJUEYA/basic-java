package com.jue.java.learntest.tooffer.solution54;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        num1[0] = set.toArray(new Integer[2])[0];
        num2[0] = set.toArray(new Integer[2])[1];
    }
}