package com.jue.java.learntest.leetcode.solution1306;

class Solution {
    private boolean arrive = false;
    private boolean[] flag = null;

    public boolean canReach(int[] arr, int start) {
        if (flag == null) {
            flag = new boolean[arr.length];
        }
        if (!flag[start]) {
            flag[start] = true;
            if (arr[start] == 0) {
                arrive = true;
            }
            if (!arrive && start + arr[start] < arr.length) {
                canReach(arr, start + arr[start]);
            }
            if (!arrive && start - arr[start] >= 0) {
                canReach(arr, start - arr[start]);
            }
        }
        return arrive;
    }
}