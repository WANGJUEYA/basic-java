package com.jue.java.learntest.tooffer.solution47;

import java.util.ArrayList;

public class Solution {

    public ArrayList<Integer> list = new ArrayList() {
    };

    public void Insert(Integer num) {
        int i = 0, n = list.size();
        while (i < n) {
            if (num > list.get(i)) {
                i++;
            } else {
                list.add(i, num);
                break;
            }
        }
        if (i >= n) {
            list.add(num);
        }

    }

    public Double GetMedian() {
        int n = list.size();
        if (n <= 0) {
            return 0D;
        } else if (n % 2 == 0) {
            Integer a = list.get(n / 2);
            Integer b = list.get(n / 2 - 1);
            return (a + b) / 2D;
        } else {
            return list.get((n - 1) / 2) * 1D;
        }
    }
}