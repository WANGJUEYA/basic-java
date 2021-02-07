package com.jue.java.learn.tooffer.bean;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JUE
 * @date 2019/5/20
 * @apiNote TreeNode(采用广度优先的测试读取和初始化树 - - 空树只作为叶子)
 * note: 0 error(s),0 warning(s)
 */
public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode val(String v) {
        if ("#".equals(v)) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(v));
        }
    }

    public TreeNode(String val) {
        init(val.split(","));
    }

    public TreeNode(String[] val) {
        init(val);
    }

    /**
     * 采用广度优先的方式生成树
     */
    private void init(String[] val) {
        TreeNode head = val(val[0]);
        int total = val.length;
        int index = 0;
        int top = -1;
        TreeNode[] nodes = new TreeNode[total];
        nodes[++top] = head;
        for (int i = 1; i < total; i += 2) {
            TreeNode root = nodes[index++];
            if (null == root) {
                continue;
            }
            TreeNode leftTemp = val(val[i]);
            TreeNode rightTemp = i + 1 < total ? val(val[i + 1]) : null;
            root.left = leftTemp;
            root.right = rightTemp;
            if (++top < total) {
                nodes[top] = root.left;
            }
            if (++top < total) {
                nodes[top] = root.right;
            }
        }
        this.val = head.val;
        this.left = head.left;
        this.right = head.right;
    }

    /**
     * 采用广度优先的方式打印树
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(this);
        while (!nodeQueue.isEmpty()) {
            if (!"".equals(result.toString())) {
                result.append(",");
            }
            TreeNode node = nodeQueue.poll();
            if (node == null) {
                result.append("#");
            } else {
                result.append(node.val);
                nodeQueue.offer(node.left);
                nodeQueue.offer(node.right);
            }
        }
        String content = result.toString();
        return content.replaceAll("[,#]+?$", "");
    }

    public String doubleLink() {
        StringBuilder result = new StringBuilder();
        TreeNode treeNode = this;
        boolean left = true;
        while (null != treeNode) {
            result.append(treeNode.val);
            if (left && null != treeNode.left) {
                treeNode = treeNode.left;
                continue;
            }
            left = false;
            treeNode = treeNode.right;
        }
        return result.toString();
    }

    /**
     * 前序遍历 TODO test
     */
    public String DLR() {
        StringBuilder result = new StringBuilder();
        result.append(this.val).append(",");
        if (this.left != null) {
            result.append(this.left.DLR()).append(",");
        }
        if (this.right != null) {
            result.append(this.right.DLR()).append(",");
        }
        return result.toString();
    }

    /**
     * 中序遍历 TODO test
     */
    public String LDR() {
        StringBuilder result = new StringBuilder();
        if (this.left != null) {
            result.append(this.left.LDR()).append(",");
        }
        result.append(this.val).append(",");
        if (this.right != null) {
            result.append(this.right.LDR()).append(",");
        }
        return result.toString();
    }

    /**
     * 后序遍历 TODO test
     */
    public String LRD() {
        StringBuilder result = new StringBuilder();
        if (this.left != null) {
            result.append(this.left.LRD()).append(",");
        }
        if (this.right != null) {
            result.append(this.right.LRD()).append(",");
        }
        result.append(this.val).append(",");
        return result.toString();
    }

    public static boolean BST(TreeNode root, TreeNode prev) {
        if (root != null) {
            if (!BST(root.left, prev)) {
                return false;
            }
            if (prev != null && root.val < prev.val) {
                return false;
            }
            prev = root;
            return BST(root.right, prev);
        }
        return true;
    }
}
