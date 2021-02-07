package com.jue.java.learn.tooffer.solution26;

public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        int[] result = new int[length];
        int index = 0;
        if (null == numbers) {
            return false;
        }
        for (int i : numbers) {
            int size = index - 1;
            while (size >= 0) {
                if (i == result[size--]) {
                    duplication[0] = i;
                    return true;
                }
            }
            result[index++] = i;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test1 = {2, 1, 3, 1, 4};
        int[] test = {};
        int len = test.length;
        System.out.println((new Solution()).duplicate(test, len, new int[1]));
    }
}