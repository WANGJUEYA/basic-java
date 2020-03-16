package com.jue.java.learntest.tooffer.solution50;

import com.jue.java.learntest.tooffer.bean.TreeNode;

public class Solution {
    public static void main(String[] args) {
        String test = "1,2,3,4,5,#,#,#,#,6";
        System.out.println((new SolutionPerfect()).IsBalanced_Solution(new TreeNode(test)));
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (null == root) {
            return true;
        }
        return high(root) != -1;
    }

    /**
     * 计算树的高度并且计算其是否为平衡二叉树(如果是平衡二叉树返回-1)
     */
    private int high(TreeNode root) {
        if (null == root) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) {
            return 1;
        } else if (left == null) {
            if ((right.right == null) && (right.left == null)) {
                return 2;
            } else {
                return -1;
            }
        } else if (right == null) {
            if ((left.right == null) && (left.left == null)) {
                return 2;
            } else {
                return -1;
            }
        } else {
            //发现不是平衡树及时止损
            int leftHigh = high(left);
            if (leftHigh == -1) {
                return -1;
            }
            int rightHigh = high(right);
            if (rightHigh == -1) {
                return -1;
            }
            if (leftHigh - rightHigh <= 1 && leftHigh - rightHigh >= -1) {
                return Math.max(leftHigh, rightHigh) + 1;
            } else {
                return -1;
            }
        }
    }
}

class SolutionPerfect {
    public boolean IsBalanced_Solution(TreeNode root) {
        return high(root) != -1;
    }

    /**
     * 计算树的高度并且计算其是否为平衡二叉树(如果是平衡二叉树返回-1)
     */
    private int high(TreeNode root) {
        if (null == root) {
            return 0;
        }
        //发现不是平衡树及时止损
        int leftHigh = high(root.left);
        if (leftHigh == -1) {
            return -1;
        }
        int rightHigh = high(root.right);
        if (rightHigh == -1) {
            return -1;
        }
        return Math.abs(leftHigh - rightHigh) <= 1 ? Math.max(leftHigh, rightHigh) + 1 : -1;
    }
}