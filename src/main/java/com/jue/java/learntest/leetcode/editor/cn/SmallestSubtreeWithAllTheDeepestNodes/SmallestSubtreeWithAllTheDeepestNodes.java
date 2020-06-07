//给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。 
//
// 如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。 
//
// 一个结点的子树是该结点加上它的所有后代的集合。 
//
// 返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。 
//
// 
//
// 示例： 
//
// 输入：[3,5,1,6,2,0,8,null,null,7,4]
//输出：[2,7,4]
//解释：
//
//我们返回值为 2 的结点，在图中用黄色标记。
//在图中用蓝色标记的是树的最深的结点。
//输入 "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" 是对给定的树的序列化表述。
//输出 "[2, 7, 4]" 是对根结点的值为 2 的子树的序列化表述。
//输入和输出都具有 TreeNode 类型。
// 
//
// 
//
// 提示： 
//
// 
// 树中结点的数量介于 1 和 500 之间。 
// 每个结点的值都是独一无二的。 
// 
// Related Topics 树


package com.jue.java.learntest.leetcode.editor.cn.SmallestSubtreeWithAllTheDeepestNodes;

import com.jue.java.learntest.tooffer.bean.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JUE
 * @number 865
 */
public class SmallestSubtreeWithAllTheDeepestNodes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode("3,5,1,6,2,0,8,#,#,7,4");
//        TreeNode node1 = new TreeNode("0,#,1,#,2,#,3");
//        TreeNode node1 = new TreeNode("0,#,1,#,#,#,2");
//        node1.right.right.right = new TreeNode(3);
        System.out.println(solution.subtreeWithAllDeepest(node));
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

    boolean[] flag;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // 1. 标记所有直接包含最深节点的跟
        // 2. 某一层只有唯一一个true
        flag = new boolean[2];
        flag(root, 1, 1);
        int deep = (int) (Math.log(flag.length) / Math.log(2));
        Arrays.fill(flag, 0, (int) (Math.pow(2, deep - 1)), false);
        int base = flag.length / 2;
        int layerCount;
        int head;
        do {
            head = -1;
            layerCount = 0;
            for (int index = 0; index < base; index++) {
                if (flag[base + index]) {
                    head = base + index;
                    layerCount++;
                    flag[(base + index) / 2] = true;
                }
            }
            base /= 2;
        } while (layerCount > 1);
        List<Integer> path = new ArrayList<>();
        TreeNode result = root;
        while (head > 1) {
            path.add(head % 2);
            head /= 2;
        }
        for (int index = path.size() - 1; index >= 0; index--) {
            if (path.get(index) % 2 == 0) {
                result = result.left;
            } else {
                result = result.right;
            }
        }
        return result;
    }

    public void flag(TreeNode root, int deep, int index) {
        //ps 满二叉树 根节点为第1层, 第k层有 2^(k-1) 一共有 2 ^ k -1
        int sizeAll = (int) Math.pow(2, deep);
        if (flag.length < sizeAll) {
            flag = Arrays.copyOf(flag, sizeAll);
        }
        boolean isLeaf = false;
        if (root != null) {
            if (root.left == null && root.right == null) {
                isLeaf = true;
            } else {
                flag(root.left, deep + 1, 2 * index);
                flag(root.right, deep + 1, 2 * index + 1);
            }
        }
        flag[index] = isLeaf;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
