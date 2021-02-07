package com.jue.java.learn.tooffer.solution66;

import com.jue.java.learn.tooffer.bean.TreeNode;

public class Solution {
    public void Mirror(TreeNode root) {
        if (null != root) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            Mirror(left);
            Mirror(right);
            root.right = left;
            root.left = right;
        }
    }
}