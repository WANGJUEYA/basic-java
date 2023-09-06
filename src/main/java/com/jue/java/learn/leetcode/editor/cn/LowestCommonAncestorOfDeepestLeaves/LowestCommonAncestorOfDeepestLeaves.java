//给你一个有根节点
// root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
//
// 回想一下：
//
//
// 叶节点 是二叉树中没有子节点的节点
// 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
// 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4]
//输出：[2,7,4]
//解释：我们返回值为 2 的节点，在图中用黄色标记。
//在图中用蓝色标记的是树的最深的节点。
//注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：[1]
//解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
//
//
// 示例 3：
//
//
//输入：root = [0,1,3,null,2]
//输出：[2]
//解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。
//
//
//
// 提示：
//
//
// 树中的节点数将在
// [1, 1000] 的范围内。
// 0 <= Node.val <= 1000
// 每个节点的值都是 独一无二 的。
//
//
//
//
// 注意：本题与力扣 865 重复：https://leetcode-cn.com/problems/smallest-subtree-with-all-
//the-deepest-nodes/
//
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 175 👎 0


package com.jue.java.learn.leetcode.editor.cn.LowestCommonAncestorOfDeepestLeaves;

import com.jue.java.learn.tooffer.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @number 1123
 */
public class LowestCommonAncestorOfDeepestLeaves {
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
    /*
    1 | 1
    2 | 2 3
    3 | 4 5 6 7
    4 | 8 9 10 11 12 13 14 15
     */
    // 从第1层开始，第n层结尾数字为 2^n -1, 第n层开始数字为 2^(n-1); 每个节点 k 的父节点为 k/2;
    // 节点数目不代表总数，防止栈溢出，上面只记录最深节点序号
    Map<Integer, TreeNode> indexOfTreeNode = new HashMap<>();
    int deepMax = 0;
    List<Integer> deepIdxes = new ArrayList<>();

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // 本质上是一道树的数学题
        setStore(root, 1, 0);
        // 计算父亲链中最小的数据
        Map<Integer, Integer> countOfParent = new HashMap<>();
        for (int i : deepIdxes) {
            countOfParent.put(1, countOfParent.getOrDefault(1, 0) + 1);
            int p = i;
            while (p > 1) {
                // 单节点父亲是自己
                countOfParent.put(p, countOfParent.getOrDefault(p, 0) + 1);
                p /= 2;
            }
        }
        int countMax = countOfParent.get(1);
        // 肯定只有一个最大索引树
        int maxIndex = 1;
        for (Map.Entry<Integer, Integer> entry : countOfParent.entrySet()) {
            if (entry.getValue() == countMax) {
                maxIndex = Math.max(maxIndex, entry.getKey());
            }
        }
        return indexOfTreeNode.get(maxIndex);
    }

    private void setStore(TreeNode root, int floor, int no) {
        if (root == null) {
            return;
        }
        if (floor > deepMax) {
            deepMax = floor;
            deepIdxes = new ArrayList<>();
        }
        int index = (int) Math.pow(2, floor - 1) + no;
        if (floor == deepMax) {
            deepIdxes.add(index);
        }
        // 存储当前节点
        indexOfTreeNode.put(index, root);
        setStore(root.left, floor + 1, no * 2);
        setStore(root.right, floor + 1, no * 2 + 1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
