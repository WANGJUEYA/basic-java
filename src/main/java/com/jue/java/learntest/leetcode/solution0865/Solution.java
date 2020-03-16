package com.jue.java.learntest.leetcode.solution0865;

import com.jue.java.learntest.tooffer.bean.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    boolean[] flag;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // 1. 标记所有直接包含最深节点的跟
        // 2. 某一层只有唯一一个true
        flag = new boolean[2];
        flag(root, 1, 1);
        int deep = (int) (Math.log(flag.length) / Math.log(2));
        Arrays.fill(flag, 0, (int) (Math.pow(2, deep - 1)), false);
        int base = flag.length / 2;
        int layerCount;
        int head;
        do {
            head = -1;
            layerCount = 0;
            for (int index = 0; index < base; index++) {
                if (flag[base + index]) {
                    head = base + index;
                    layerCount++;
                    flag[(base + index) / 2] = true;
                }
            }
            base /= 2;
        } while (layerCount > 1);
        List<Integer> path = new ArrayList<>();
        TreeNode result = root;
        while (head > 1) {
            path.add(head % 2);
            head /= 2;
        }
        for (int index = path.size() - 1; index >= 0; index--) {
            if (path.get(index) % 2 == 0) {
                result = result.left;
            } else {
                result = result.right;
            }
        }
        return result;
    }

    public void flag(TreeNode root, int deep, int index) {
        //ps 满二叉树 根节点为第1层, 第k层有 2^(k-1) 一共有 2 ^ k -1
        int sizeAll = (int) Math.pow(2, deep);
        if (flag.length < sizeAll) {
            flag = Arrays.copyOf(flag, sizeAll);
        }
        boolean isLeaf = false;
        if (root != null) {
            if (root.left == null && root.right == null) {
                isLeaf = true;
            } else {
                flag(root.left, deep + 1, 2 * index);
                flag(root.right, deep + 1, 2 * index + 1);
            }
        }
        flag[index] = isLeaf;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode("3,5,1,6,2,0,8,#,#,7,4");
//        TreeNode node1 = new TreeNode("0,#,1,#,2,#,3");
//        TreeNode node1 = new TreeNode("0,#,1,#,#,#,2");
//        node1.right.right.right = new TreeNode(3);
        System.out.println((new Solution()).subtreeWithAllDeepest(node));
    }
}