//给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。 
//
// 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。 
//
// 
// 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,3,4,7,1,2,6]
//输出：[1,3,4,1,2,6]
//解释：
//上图表示给出的链表。节点的下标分别标注在每个节点的下方。
//由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
//返回结果为移除节点后的新链表。 
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,2,4]
//解释：
//上图表示给出的链表。
//对于 n = 4 ，值为 3 的节点 2 是中间节点，用红色标注。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [2,1]
//输出：[2]
//解释：
//上图表示给出的链表。
//对于 n = 2 ，值为 1 的节点 1 是中间节点，用红色标注。
//值为 2 的节点 0 是移除节点 1 后剩下的唯一一个节点。 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 
// 👍 0 👎 0


package com.jue.java.learn.leetcode.editor.cn.DeleteTheMiddleNodeOfALinkedList;

import com.jue.java.learn.tooffer.bean.ListNode;

/**
 * @author JUE
 * @number 5943
 */
public class DeleteTheMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.deleteMiddle(new ListNode(new int[]{1, 3, 4, 7, 1, 2, 6})));
        System.out.println(solution.deleteMiddle(new ListNode(new int[]{1, 2, 3, 4})));
        System.out.println(solution.deleteMiddle(new ListNode(new int[]{2, 1})));
        System.out.println(solution.deleteMiddle(new ListNode(new int[]{2})));
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
    public ListNode deleteMiddle(ListNode head) {
        // 如果只有一个节点; 返回null
        if (head == null || head.next == null) {
            return null;
        }
        // 删除中间节点; 目测只能用双指针的做法
        ListNode pre = head;
        ListNode suf = head;
        boolean execute = true;
        while (pre.next != null) {
            pre = pre.next;
            // 如果前方遇到空; 删除节点退出
            if (pre.next == null) {
                execute = false;
                suf.next = suf.next.next;
                break;
            }
            pre = pre.next;
            if (pre.next != null) {
                suf = suf.next;
            }
        }
        if (execute) {
            suf.next = suf.next.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


