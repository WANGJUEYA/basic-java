//给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
//
// 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
//
// 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
//
//
//
// 示例 1：
//
//
//输入：n = 7
//输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0
//,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
//
//
// 示例 2：
//
//
//输入：n = 3
//输出：[[0,0,0]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
//
// Related Topics 树 递归 记忆化搜索 动态规划 二叉树 👍 339 👎 0


package com.jue.java.learn.leetcode.editor.cn.AllPossibleFullBinaryTrees;

import com.jue.java.learn.tooffer.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @number 894
 */
public class AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.allPossibleFBT(1));
//        System.out.println(solution.allPossibleFBT(3));
//        System.out.println(solution.allPossibleFBT(5));
//        System.out.println(solution.allPossibleFBT(7));
        System.out.println(solution.allPossibleFBT(11));
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

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 1) {
            result.add(new TreeNode());
            map.put(1, result);
            return result;
        }
        // n 个节点，每个节点0个子树或者2个子树，边的数量为 n-1 且 (n-1)%2==0; 故 n 一定为奇数
        // 真二叉树的子树一定是真二叉树，左右子树数量一致且均为满二叉树时该构造方法只有一种,满二叉树节点个数 2^n-1: 1, 3, 7, 15, 31 (11 也是！)
        // ps 左右子树相同时，不重复进行左右树交换构造
        for (int left = 1; left <= n / 2; left += 2) {
            int right = n - 1 - left;
            if (!map.containsKey(left)) {
                map.put(left, allPossibleFBT(left));
            }
            if (!map.containsKey(right)) {
                map.put(right, allPossibleFBT(right));
            }
            // 如果左子树和右子树相同, 同索引元素只插入一次
            if (left == right) {
                List<TreeNode> list = map.get(left);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    for (TreeNode treeNode : list) {
                        result.add(new TreeNode(0, clone(list.get(i)), clone(treeNode)));
                    }
                }
            } else {
                for (TreeNode leftNode : map.get(left)) {
                    for (TreeNode rightNode : map.get(right)) {
                        result.add(new TreeNode(0, clone(leftNode), clone(rightNode)));
                        result.add(new TreeNode(0, clone(rightNode), clone(leftNode)));
                    }
                }
            }
        }
        map.put(n, result);
        return result;
    }

    public boolean equals(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        }
        return equals(left.left, right.left) && equals(left.right, right.right);
    }

    public TreeNode clone(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = new TreeNode();
        result.left = clone(root.left);
        result.right = clone(root.right);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
