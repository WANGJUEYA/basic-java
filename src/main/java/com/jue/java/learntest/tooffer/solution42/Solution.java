package com.jue.java.learntest.tooffer.solution42;

import com.jue.java.learntest.tooffer.bean.TreeNode;

public class Solution {

    public static void main(String[] args) {
        System.out.println((new Solution()).isSymmetrical(new TreeNode("1,2,2,3,4,4,3,5,6,6,5,5,6,6,5")));
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val)
                && isSymmetrical(left.left, right.right)
                && isSymmetrical(left.right, right.left);
    }
}