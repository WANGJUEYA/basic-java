package com.jue.java.learn.tooffer.solution39;

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length < size || size == 0) {
            return result;
        }
        int index = index(num, 0, size);
        result.add(num[index]);
        for (int i = 1, n = num.length - size + 1; i < n; i++) {
            if (num[i + size - 1] > num[index]) {
                index = i + size - 1;
            } else if (i > index) {
                index = index(num, i, size);
            }
            result.add(num[index]);
        }
        return result;
    }

    public int index(int[] num, int begin, int size) {
        int index = begin;
        for (int i = begin + 1, n = begin + size; i < n; i++) {
            if (num[i] > num[index]) {
                index = i;
            }
        }
        return index;
    }
}