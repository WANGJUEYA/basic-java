//给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。 
//
// 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。 
//
// 如果有多种构造方法，请你返回任意一种。 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,null,2,null,3,null,4,null,null]
//输出：[2,1,3,null,null,null,4]
//解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
// 
//
// 
//
// 提示： 
//
// 
// 树节点的数目在 1 到 10^4 之间。 
// 树节点的值互不相同，且在 1 到 10^5 之间。 
// 
// Related Topics 二叉搜索树


package com.jue.java.learn.leetcode.editor.cn.BalanceABinarySearchTree;

import com.jue.java.learn.tooffer.bean.TreeNode;

import java.util.ArrayList;

/**
 * @author JUE
 * @number 1382
 */
public class BalanceABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

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
    // FIXME this need learn
    ArrayList<TreeNode> orderList = null;
    TreeNode[] orderNode = null;

    public TreeNode balanceBST(TreeNode root) {
        orderList = new ArrayList<>();

        // 思路：先找出所有节点，然后中分取数
        // 先找所有节点，中序遍历，查出有序的集合
        doSelect(root);

        if (orderList.size() < 3) return root; // 个数小于3就没必要了

        orderNode = orderList.toArray(new TreeNode[orderList.size()]); // 构建成数组，以便于取区间的中位数

        return doBuild(0, orderNode.length - 1); // 构建新的树
    }

    private TreeNode doBuild(int left, int right) {
        if (left > right) return null;

        int curRootIndex = (left + right) / 2;
        TreeNode curRoot = orderNode[curRootIndex];
        curRoot.left = doBuild(left, curRootIndex - 1);
        curRoot.right = doBuild(curRootIndex + 1, right);
        return curRoot;
    }

    // 中序遍历获取数组链表
    private void doSelect(TreeNode curRoot) {
        if (curRoot == null) return;

        doSelect(curRoot.left);
        orderList.add(curRoot);
        doSelect(curRoot.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
