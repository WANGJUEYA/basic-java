package com.jue.java.learn.tooffer.solution63;

import com.jue.java.learn.tooffer.bean.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        //利用hash值
        Map<Integer, ListNode> map = new HashMap<>();
        while (pHead != null) {
            int hash = pHead.hashCode();
            if (map.containsKey(hash)) {
                return map.get(hash);
            } else {
                map.put(hash, pHead);
            }
            pHead = pHead.next;
        }
        return null;
    }
}

class SolutionPerfect {

    /**
     * 此解法如此微妙？？如果保证刚好就是想要的呢!
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p1 = pHead;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if (p1 == p2) return p1;
            }
        }
        return null;
    }
}