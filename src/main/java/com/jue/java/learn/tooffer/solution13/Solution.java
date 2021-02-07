package com.jue.java.learn.tooffer.solution13;

import com.jue.java.learn.tooffer.bean.TreeNode;

public class Solution {
    int count = 1;
    TreeNode head = null;
    TreeNode realHead = null;

    //利用中序遍历直接解决
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        System.out.print("\n" + (count++) + "====>");
        if (pRootOfTree == null) {
            return;
        }
        System.out.print("(pRootOfTree)" + pRootOfTree.val);
        ConvertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            System.out.print("(head1)" + head.val);
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
            System.out.print("(head2)" + head.val);
        }
        ConvertSub(pRootOfTree.right);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode("4,2,6,1,3,5,7");
        System.out.println(treeNode);
        TreeNode result = solution.Convert(treeNode);
        System.out.println(result.doubleLink());
    }
}