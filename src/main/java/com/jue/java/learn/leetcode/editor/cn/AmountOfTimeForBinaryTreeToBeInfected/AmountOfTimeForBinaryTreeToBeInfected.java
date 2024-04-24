//给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发
//。
//
// 每分钟，如果节点满足以下全部条件，就会被感染：
//
//
// 节点此前还没有感染。
// 节点与一个已感染节点相邻。
//
//
// 返回感染整棵树需要的分钟数。
//
//
//
// 示例 1：
// 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
//输出：4
//解释：节点按以下过程被感染：
//- 第 0 分钟：节点 3
//- 第 1 分钟：节点 1、10、6
//- 第 2 分钟：节点5
//- 第 3 分钟：节点 4
//- 第 4 分钟：节点 9 和 2
//感染整棵树需要 4 分钟，所以返回 4 。
//
//
// 示例 2：
// 输入：root = [1], start = 1
//输出：0
//解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 10⁵] 内
// 1 <= Node.val <= 10⁵
// 每个节点的值 互不相同
// 树中必定存在值为 start 的节点
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 88 👎 0


package com.jue.java.learn.leetcode.editor.cn.AmountOfTimeForBinaryTreeToBeInfected;

import com.jue.java.learn.tooffer.bean.TreeNode;

/**
 * @author JUE
 * @number 2385
 */
public class AmountOfTimeForBinaryTreeToBeInfected {
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

    TreeNode left;
    TreeNode target;

    private String print(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + print(root.left) + "," + print(root.right);
    }

    public int amountOfTime(TreeNode root, int start) {
        // 先用广度遍历找到节点，再用深度遍历计算最大层数； 不太行，其实层数是公共父节点的层数，不能无脑*2
        // 调整方法：先dfS找到，再重新构造树

        //System.out.println(print(root));

        dfs(root, start);

        //System.out.println(print(target));
        //System.out.println(print(left));

        int result = level(target, 0);
        if (left != null) {
            result = Math.max(result, level(left, 1));
        }
        return result;
    }

    private int level(TreeNode root, int count) {
        if (root == null) {
            return count - 1;
        }
        int result = count;
        if (root.left != null) {
            result = Math.max(result, level(root.left, count + 1));
        }
        if (root.right != null) {
            result = Math.max(result, level(root.right, count + 1));
        }
        return result;
    }

    private TreeNode dfs(TreeNode root, int start) {
        if (root.val == start) {
            target = root;
            left = root.left;
            root.left = null;
            return root;
        } else {
            if (root.left != null) {
                TreeNode newParent = dfs(root.left, start);
                if (newParent != null) {
                    newParent.left = root;
                    root.left = null;
                    return root;
                }
            }
            if (root.right != null) {
                TreeNode newParent = dfs(root.right, start);
                if (newParent != null) {
                    newParent.left = root;
                    root.right = root.left;
                    root.left = null;
                    return root;
                }
            }
        }
        return null;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
