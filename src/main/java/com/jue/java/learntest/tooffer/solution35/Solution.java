package com.jue.java.learntest.tooffer.solution35;

import com.jue.java.learntest.tooffer.bean.ListNode;

public class Solution {
    public static void main(String[] args) {
        int[] node1 = {1, 2, 3};
        int[] node2 = {4, 5};
        int[] common = {6, 7};

        ListNode pHead1 = new ListNode(node1);
        ListNode pHead2 = new ListNode(node2);
        ListNode pNode = new ListNode(common);
        ListNode temp1 = pHead1;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = pNode;
        ListNode temp2 = pHead2;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = pNode;
        System.out.println((new Solution()).FindFirstCommonNode(pHead1, pHead2));
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        while (null != node1) {
            ListNode node2 = pHead2;
            while (null != node2) {
                if (node1 == node2) {
                    return node1;
                }
                node2 = node2.next;
            }
            node1 = node1.next;
        }
        return null;
    }
}

//走第一遍应该相当于计数，第二遍的时候就调整到了相同长度
class SolutionPerfect {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }
}