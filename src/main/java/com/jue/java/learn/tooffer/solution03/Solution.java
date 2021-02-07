package com.jue.java.learn.tooffer.solution03;

import com.jue.java.learn.tooffer.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JUE
 * @date 2019/6/18
 * @apiNote Solution
 * note: 0 error(s),0 warning(s)
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            if (null != node) {
                result.add(node.val);
                nodeQueue.offer(node.left);
                nodeQueue.offer(node.right);
            }
        }
        return result;
    }
}