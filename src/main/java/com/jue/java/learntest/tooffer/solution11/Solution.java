package com.jue.java.learntest.tooffer.solution11;


import com.jue.java.learntest.tooffer.bean.TreeNode;

public class Solution {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (null == root2) {
            return true;
        }
        if (null == root1) {
            return false;
        }
        if (root1.val == root2.val) {
            if (hasSubtree(root1.left, root2.left) && hasSubtree(root1.right, root2.right)) {
                return true;
            }
        }
        return hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        return null != root1 && null != root2 && hasSubtree(root1, root2);
    }
}