//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 541 👎 0


package com.jue.java.learn.leetcode.editor.cn.MaximumWidthOfBinaryTree;

import com.jue.java.learn.tooffer.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @number 662
 */
public class MaximumWidthOfBinaryTree {
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
    public int widthOfBinaryTree(TreeNode root) {
        // 最大宽度, 广度遍历法走起
        if (root == null) {
            return 0;
        }
        long result = 1;
        Map<Long, TreeNode> current = new HashMap<>();
        current.put(1L, root);
        while (!current.isEmpty()) {
            // 最后一级索引int装不下
            Map<Long, TreeNode> next = new HashMap<>();
            long min = Long.MAX_VALUE;
            long max = -1;
            for (Map.Entry<Long, TreeNode> item : current.entrySet()) {
                TreeNode treeNode = item.getValue();
                if (treeNode != null) {
                    if (treeNode.left != null) {
                        long index = item.getKey() * 2 - 1;
                        min = Math.min(min, index);
                        max = Math.max(max, index);
                        next.put(index, treeNode.left);
                    }
                    if (treeNode.right != null) {
                        long index = item.getKey() * 2;
                        min = Math.min(min, index);
                        max = Math.max(max, index);
                        next.put(index, treeNode.right);
                    }
                }
            }
            if (max > min) {
                result = Math.max(result, max - min + 1);
            }
            current = next;
        }
        return (int) result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_Memory_Limit {
    public int widthOfBinaryTree(TreeNode root) {
        // 最大宽度, 广度遍历法走起
        if (root == null) {
            return 0;
        }
        int max = 1;
        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            boolean hasValue = false;
            for (TreeNode item : current) {
                if (item == null) {
                    if (hasValue) {
                        next.add(null);
                        next.add(null);
                    }
                } else {
                    hasValue = true;
                    next.add(item.left);
                    next.add(item.right);
                }
            }
            // 删除前方的空
            while (!next.isEmpty() && next.get(0) == null) {
                next.remove(0);
            }
            // 删除末尾的空
            int index = next.size() - 1;
            while (index >= 0 && next.get(index) == null) {
                next.remove(index);
                index--;
            }
            max = Math.max(max, next.size());
            current = next;
        }
        return max;
    }
}
