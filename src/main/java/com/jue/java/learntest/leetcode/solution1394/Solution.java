package com.jue.java.learntest.leetcode.solution1394;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author JUE
 * @date 2020/3/29
 * @note 0 error(s), 0 warning(s)
 **/
class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int a : arr) {
            if (count.containsKey(a)) {
                count.put(a, count.get(a) + 1);
            } else {
                count.put(a, 1);
            }
            if (a == count.get(a)) {
                queue.add(a);
            } else {
                queue.remove(a);
            }
        }
        return queue.isEmpty() ? -1 : queue.poll();
    }
}