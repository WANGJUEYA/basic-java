//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索


package com.jue.java.learntest.leetcode.editor.cn.BinaryTreeRightSideView;

import com.jue.java.learntest.tooffer.bean.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author JUE
 * @number 199
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode("1,2,3,#,5,#,4");
        System.out.println(solution.rightSideView(root));
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 先进先出(使用队列)
        Queue<TreeNode> current = new ArrayDeque<>();
        current.add(root);
        Queue<TreeNode> next;
        while (!current.isEmpty()) {
            next = new ArrayDeque<>();
            int last = -1;
            while (!current.isEmpty()) {
                TreeNode item = current.poll();
                last = item.val;
                if (item.left != null) {
                    next.add(item.left);
                }
                if (item.right != null) {
                    next.add(item.right);
                }
            }
            result.add(last);
            current = next;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
