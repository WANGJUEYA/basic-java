package com.jue.java.learn.tooffer.bean;

/**
 * @author JUE
 * @date 2019/5/20
 * @apiNote ListNode
 * note: 0 error(s),0 warning(s)
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] val) {
        ListNode head = new ListNode(val[0]);
        ListNode node = head;
        for (int i = 1, n = val.length; i < n; i++) {
            ListNode temp = new ListNode(val[i]);
            node.next = temp;
            node = temp;
        }
        this.val = head.val;
        this.next = head.next;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode node = this;
        while (node != null) {
            if (!"".equals(result.toString())) {
                result.append(",");
            }
            result.append(node.val);
            node = node.next;
        }
        return result.toString();
    }
}
