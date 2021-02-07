// 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
//
// 
//
// 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。 
//
// 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。 
//
// 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。 
//
// 
//
// 提示： 
//
// 
// 给定的两颗树可能会有 1 到 200 个结点。 
// 给定的两颗树上的值介于 0 到 200 之间。 
// 
// Related Topics 树 深度优先搜索 
// 👍 66 👎 0


package com.jue.java.learn.leetcode.editor.cn.LeafSimilarTrees;

import com.jue.java.learn.tooffer.bean.TreeNode;

import java.util.Objects;

/**
 * @author JUE
 * @number 872
 */
public class LeafSimilarTrees {
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return Objects.equals(leafValues(root1), leafValues(root2));
    }

    public String leafValues(TreeNode node) {
        if (node == null) {
            return "";
        }
        if (node.left == null && node.right == null) {
            return "" + node.val;
        }
        String left = leafValues(node.left);
        String right = leafValues(node.right);
        if (!"".equals(left) && !"".equals(right)) {
            return left + "," + right;
        } else if ("".equals(left)) {
            return right;
        } else {
            return left;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
