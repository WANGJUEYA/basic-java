package com.jue.java.learn.tooffer.solution57;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int low = 0, high = array.length - 1; low < high; ) {
            //越远乘积越小
            if (array[low] + array[high] == sum) {
                result.add(array[low]);
                result.add(array[high]);
                break;
            } else if (array[low] + array[high] < sum) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }
}