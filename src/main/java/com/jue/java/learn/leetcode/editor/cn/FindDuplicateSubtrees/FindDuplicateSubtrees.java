//给定一棵二叉树 root，返回所有重复的子树。 
//
// 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在[1,10^4]范围内。 
// -200 <= Node.val <= 200 
// 
//
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 592 👎 0


package com.jue.java.learn.leetcode.editor.cn.FindDuplicateSubtrees;

import com.jue.java.learn.tooffer.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @number 652
 */
public class FindDuplicateSubtrees {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findDuplicateSubtrees(new TreeNode("1,2,3,4,#,2,4,#,#,4"));
        // solution.findDuplicateSubtrees(new TreeNode("2,2,2,3,#,3,#"));
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

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // count = new HashMap<>();
        // result = new ArrayList<>();
        sort(root);
        // System.out.println(count);
        return result;
    }

    // 存储字符串对应的节点
    private Map<Integer, Integer> count = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    private String sort(TreeNode root) {
        if (root == null) {
            return "";
        }
        String left = sort(root.left);
        String right = sort(root.right);
        // 前序遍历(只存储中序遍历的hash值 - 防止内存溢出)
        String pre = root.val + "-" + left + "-" + right;
        String mid = left + "-" + root.val + "-" + right;
        String str = "+" + pre + "#" + mid.hashCode() + "+";
        // 默认hash不重复
        int hash = str.hashCode();
        count.put(hash, count.getOrDefault(hash, 0) + 1);
        // System.out.println(str);
        if (count.get(hash) == 2) {
            this.result.add(root);
        }
        return str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
