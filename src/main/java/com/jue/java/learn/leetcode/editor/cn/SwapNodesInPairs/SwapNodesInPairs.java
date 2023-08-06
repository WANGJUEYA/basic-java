//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 1943 👎 0


package com.jue.java.learn.leetcode.editor.cn.SwapNodesInPairs;

import com.jue.java.learn.tooffer.bean.ListNode;

/**
 * @author JUE
 * @number 24
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.swapPairs(new ListNode(new int[]{1, 2, 3, 4})));
        System.out.println(solution.swapPairs(new ListNode(new int[]{1, 2, 3})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode result = null;
        ListNode pre = null;

        ListNode next = head;
        while (next != null) {
            ListNode first = next;
            ListNode second = first.next;
            first.next = null;
            if (second != null) {
                next = second.next;
                if (pre == null) {
                    result = second;
                } else {
                    pre.next = second;

                }
                second.next = first;
                pre = first;
            } else {
                if (pre == null) {
                    return first;
                } else {
                    pre.next = first;
                }
                break;
            }
        }


        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
