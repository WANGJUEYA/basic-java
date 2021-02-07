package com.jue.java.learn.tooffer.solution46;

import com.jue.java.learn.tooffer.bean.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode("5,3,7,2,4,6,8");
        TreeNode root = new TreeNode("8,6,10,5,7,9,11");
        System.out.println(TreeNode.BST(root, null));
        System.out.println((new Solution()).KthNode(root, 2));
    }

    private TreeNode result = null;
    private int count = 1;
    private int knum = 0;

    /**
     * 中序遍历
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        result = null;
        count = 1;
        knum = k;
        KthNode(pRoot);
        return result;
    }

    private void KthNode(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        KthNode(pRoot.left);
        if (knum == count && result == null) {
            result = pRoot;
        } else {
            count++;
            KthNode(pRoot.right);
        }
    }
}

class SolutionPerfrct {
    //计数器
    int count = 1;

    TreeNode KthNode(TreeNode root, int k) {
        if (root != null) {
            TreeNode node = KthNode(root.left, k);
            if (node != null) {
                return node;
            }
            if (count == k) {
                return root;
            }
            count++;
            node = KthNode(root.right, k);
            if (node != null) {
                return node;
            }
        }
        return null;
    }
}