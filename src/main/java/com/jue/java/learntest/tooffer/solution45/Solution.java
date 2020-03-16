package com.jue.java.learntest.tooffer.solution45;

import com.jue.java.learntest.tooffer.bean.TreeNode;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 树的序列化与反序列化是否 先序、中序、后序、按层 的方式都能满足？
 * 但是给出的用例 {5,4,#,3,#,2} 和广度遍历无关，看解体思路大多是前序遍历？
 * 正确的测试不应该是 -> 输入树->序列化->用​序列化的值反序列化->比较最后的树与之前的树是否相等
 * 而非直接把序列化的值用来比较？
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Serialize(solution.Deserialize("8,6,10,5,7,9,11")));
    }

    public static final String SPLIT = ",";
    public static final String NULL_NODE = "#";

    String Serialize(TreeNode root) {
        String result = "";
        if (root == null) {
            return NULL_NODE;
        }
        result += root.val;
        return result + SPLIT + Serialize(root.left) + SPLIT + Serialize(root.right);
    }


    TreeNode Deserialize(String str) {
        Solution.string = str;
        return Solution.Deserialize();
    }

    private static String string = null;

    private static TreeNode Deserialize() {
        if (string == null || "".equals(string)) {
            return null;
        }
        int index = string.indexOf(SPLIT);
        String val = string;
        if (-1 == index) {
            string = "";
        } else {
            val = string.substring(0, index);
            string = string.substring(index + 1);
        }
        if (NULL_NODE.equals(val)) {
            return null;
        }
        TreeNode result = new TreeNode(Integer.parseInt(val));
        result.left = Deserialize();
        result.right = Deserialize();
        return result;
    }
}