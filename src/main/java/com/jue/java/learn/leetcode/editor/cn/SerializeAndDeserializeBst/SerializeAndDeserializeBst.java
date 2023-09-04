//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。
//
// 编码的字符串应尽可能紧凑。
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：[2,1,3]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数范围是 [0, 10⁴]
// 0 <= Node.val <= 10⁴
// 题目数据 保证 输入的树是一棵二叉搜索树。
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 456 👎 0


package com.jue.java.learn.leetcode.editor.cn.SerializeAndDeserializeBst;

import com.jue.java.learn.tooffer.bean.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JUE
 * @number 449
 */
public class SerializeAndDeserializeBst {
    public static void main(String[] args) {
        Codec solution = new Codec();
//        System.out.println(solution.serialize(solution.deserialize("2,1,3")));
        System.out.println(solution.serialize(solution.deserialize("2,1")));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        // 二叉搜索树的中序遍历是有序的; 前序遍历唯一确认当前序列化二叉搜索树
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val);
        if (root.left != null) {
            stringBuilder.append(",");
            stringBuilder.append(serialize(root.left));
        }
        if (root.right != null) {
            stringBuilder.append(",");
            stringBuilder.append(serialize(root.right));
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        return deserialize(Arrays.stream(data.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
    }

    private TreeNode deserialize(List<Integer> data) {
        int len = data.size();
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(data.get(0));
        // 可以用二分查找法
        int mid = -1;
        for (int index = 1; index < len; index++) {
            if (data.get(index) >= root.val) {
                mid = index;
                break;
            }
        }
        root.left = deserialize(data.subList(1, mid == -1 ? len : mid));
        root.right = mid == -1 ? null : deserialize(data.subList(mid, len));
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
//leetcode submit region end(Prohibit modification and deletion)
