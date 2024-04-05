//给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。 
//
//
// （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先） 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
//输出：7
//解释： 
//我们有大量的节点与其祖先的差值，其中一些如下：
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,null,2,null,0,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 2 到 5000 之间。 
// 0 <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 247 👎 0


package com.jue.java.learn.leetcode.editor.cn.MaximumDifferenceBetweenNodeAndAncestor;

import com.jue.java.learn.tooffer.bean.TreeNode;

/**
 * @author JUE
 * @number 1026
 */
public class MaximumDifferenceBetweenNodeAndAncestor {
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
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int diff = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minMaxAncestor(root);
        return diff;
    }

    public int[] minMaxAncestor(TreeNode root) {
        if (root == null) {
            throw new NullPointerException();
        }
        int[] result = new int[]{root.val, root.val};
        if (root.left != null) {
            int[] count = minMaxAncestor(root.left);
            result[0] = Math.min(result[0], count[0]);
            result[1] = Math.max(result[1], count[1]);
        }
        if (root.right != null) {
            int[] count = minMaxAncestor(root.right);
            result[0] = Math.min(result[0], count[0]);
            result[1] = Math.max(result[1], count[1]);
        }
        diff = Math.max(diff, Math.abs(root.val - result[0]));
        diff = Math.max(diff, Math.abs(root.val - result[1]));
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
