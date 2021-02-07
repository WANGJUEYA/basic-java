//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树


package com.jue.java.learn.leetcode.editor.cn.DiameterOfBinaryTree;

import com.jue.java.learn.tooffer.bean.TreeNode;

/**
 * @author JUE
 * @number 543
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(new TreeNode("1,2,3,4,5")));
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
    private int max = 0;

    // 计算左右子树最大深度之和的最大值(根节点深度为 0)
    public int diameterOfBinaryTree(TreeNode root) {
        // 计算树的深度
        deep(root);
        return max;
    }

    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
