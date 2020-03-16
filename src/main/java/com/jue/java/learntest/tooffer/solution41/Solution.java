package com.jue.java.learntest.tooffer.solution41;

import com.jue.java.learntest.tooffer.bean.TreeLinkNode;

public class Solution {
    //中序遍历的下一个节点为右子树的第一个节点或父节点
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode result = pNode.right;
        if (result == null) {
            result = pNode.next;
            while (result != null && result.right == pNode) {
                pNode = result;
                result = result.next;
            }

        } else {
            while (result.left != null) {
                result = result.left;
            }
        }
        return result;
    }
}