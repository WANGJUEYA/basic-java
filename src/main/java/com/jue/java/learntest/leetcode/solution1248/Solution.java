package com.jue.java.learntest.leetcode.solution1248;

import com.jue.java.learntest.tooffer.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> current = new LinkedList<>(), last;
        current.add(root);
        TreeNode temp;
        // 使用队列记录每层节点(先进先出)
        int value = -1;
        while (!current.isEmpty()) {
            last = new LinkedList<>();
            while (!current.isEmpty()) {
                temp = current.poll();
                value = temp.val;
                if (temp.left != null) {
                    last.add(temp.left);
                }
                if (temp.right != null) {
                    last.add(temp.right);
                }
            }
            result.add(value);
            current = last;
        }
        return result;
    }
}