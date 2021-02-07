package com.jue.java.learn.tooffer.solution53;

public class Solution {
    public static void main(String[] args) {
        int[] test= {1,2,3,3,3,3,4,5};
        System.out.println((new Solution()).GetNumberOfK(test,3));
    }

    public int GetNumberOfK(int[] array, int k) {
        int count = 0;
        //先默认升序 PS 有序考虑二分查找
        for (int i = 0, n = array.length; i < n && k >= array[i]; i++) {
            if(array[i] == k){
                count++;
            }
        }
        return count;
    }
}