package com.jue.java.learntest.leetcode.solution1409;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @date 2020/4/12
 * @note 0 error(s), 0 warning(s)
 **/
class Solution {
    public int[] processQueries(int[] queries, int m) {
        int len = queries.length;
        if (len <= 0) {
            return queries;
        }
        int[] result = new int[len];
        // 利用有序链表
        List<Integer> array = new ArrayList<>();
        for (int index = 1; index <= m; index++) {
            array.add(index);
        }
        int i = 0;
        for (int q : queries) {
            result[i++] = array.indexOf(q);
            array.remove(Integer.valueOf(q));
            array.add(0, q);
        }
        return result;
    }
}
