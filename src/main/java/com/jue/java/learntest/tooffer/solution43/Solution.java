package com.jue.java.learntest.tooffer.solution43;

import com.jue.java.learntest.tooffer.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * 广度遍历
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> workQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue;
        workQueue.offer(pRoot);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        do {
            nextQueue = new LinkedList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            while (!workQueue.isEmpty()) {
                TreeNode node = workQueue.poll();
                //空节点的展示？
                if (node != null) {
                    temp.add(node.val);
                    nextQueue.offer(node.left);
                    nextQueue.offer(node.right);
                }
            }
            if (!temp.isEmpty()) {
                result.add(temp);
            }
            workQueue = nextQueue;
        } while (!nextQueue.isEmpty());
        return result;
    }
}

//用递归做的
class SolutionPerfect {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if (root == null) {
            return;
        }
        if (depth > list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(depth - 1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }
}