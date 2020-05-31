package com.jue.java.learntest.leetcode.solution0472;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).reversePairs(new int[]{7, 5, 6, 4}));
    }

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return 0;
        }
        // 暴力解法
        int count = 0;
        // for(int i=1; i< len;i++){
        //     for(int j=0;j<i;j++){
        //         if(nums[j] > nums[i]){
        //             count++;
        //         }
        //     }
        // }

        List<List<Integer>> array = new ArrayList<>();
        for (int n : nums) {
            boolean flag = true;
            for (int i = 0, size = array.size(); i < size; i++) {
                List<Integer> temp = array.get(i);
                int index = temp.size();
                while (--index >= 0) {
                    if (temp.get(index) > n) {
                        flag = false;
                        count += (index + 1);
                        break;
                    }
                }
                if (index == temp.size() - 1) {
                    temp.add(n);
                } else if (temp.get(index) > n) {
                    List<Integer> newTemp = new ArrayList<>(List.copyOf(temp.subList(0, index + 1)));
                    newTemp.add(n);
                    array.add(newTemp);
                }
            }
            if (flag) {
                List<Integer> temp = new ArrayList<>();
                temp.add(n);
                array.add(temp);
            }
            System.out.println(array);
        }
        return count;
    }
}