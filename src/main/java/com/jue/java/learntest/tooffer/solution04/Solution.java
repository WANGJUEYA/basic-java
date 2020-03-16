package com.jue.java.learntest.tooffer.solution04;

import java.util.Arrays;

/**
 * @author JUE
 * @date 2019/6/18
 * @apiNote Solution
 * note: 0 error(s),0 warning(s)
 */
public class Solution {
    //注！！空树是二叉搜素树
    public boolean VerifySquenceOfBST(int[] sequence) {
        return (sequence.length > 0) && function(sequence);
    }

    public boolean function(int[] sequence) {
        //最后一个是根
        int len = sequence.length;
        if (len <= 2) {
            return true;
        }
        int head = sequence[len - 1];
        int[] left = new int[len];
        int[] right = new int[len];
        int index = 0, li = 0, ri = 0;
        while (sequence[index] <= head && index < len - 1) {
            left[li++] = sequence[index];
            index++;
        }
        while (sequence[index] >= head && index < len - 1) {
            right[ri++] = sequence[index];
            index++;
        }
        return (index == len - 1)
                && function(Arrays.copyOfRange(left, 0, li))
                && function(Arrays.copyOfRange(right, 0, ri));
    }
}
