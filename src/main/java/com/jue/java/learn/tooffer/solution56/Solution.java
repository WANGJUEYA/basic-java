package com.jue.java.learn.tooffer.solution56;

import com.jue.java.learn.tooffer.bean.TreeNode;

public class Solution {
    //回溯递归法
    public int TreeDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftHigh = TreeDepth(root.left);
        int rightHigh = TreeDepth(root.right);
        return Math.max(leftHigh, rightHigh) + 1;
    }
}