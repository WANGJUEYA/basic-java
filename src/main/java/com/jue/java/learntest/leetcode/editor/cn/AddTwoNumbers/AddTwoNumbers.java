//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


package com.jue.java.learntest.leetcode.editor.cn.AddTwoNumbers;

import com.jue.java.learntest.tooffer.bean.ListNode;

/**
 * @author JUE
 * @number 2
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // ps: 排列顺序先低位再高位
        int[] l1 = {2, 4, 3};
        int[] l2 = {5, 6, 4};
        int[] l3 = {0};
        int[] l4 = {0};
        int[] l5 = {9};
        int[] l6 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        // System.out.println((new Solution()).addTwoNumbers(new ListNode(l1), new ListNode(l2)));
        // System.out.println((new Solution()).addTwoNumbers(new ListNode(l3), new ListNode(l4)));
        System.out.println(solution.addTwoNumbers(new ListNode(l5), new ListNode(l6)));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    // 方法1: 将列表转换为数字, 再将数字加和的结果转换为链表[TODO 数据太大计算量不够->使用BigNum]
    // 空间复杂度为O(1 * max(n1, n2)) 时间复杂度为O(n1 + n2 + max(n1, n2))
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 默认int型已经足够->long都不足够(此场景用于大数相加)
        long i1 = 0, m1 = 1;
        long i2 = 0, m2 = 1;
        ListNode head = l1;
        while (head != null) {
            i1 += m1 * head.val;
            m1 *= 10;
            head = head.next;
        }
        head = l2;
        while (head != null) {
            i2 += m2 * head.val;
            m2 *= 10;
            head = head.next;
        }
        long add = i1 + i2;
        head = null;
        ListNode p = null;
        while (add > 0) {
            long endNum = add % 10;
            add = add / 10;
            ListNode node = new ListNode((int) endNum);
            if (head == null) {
                head = node;
            } else {
                p.next = node;
            }
            p = node;
        }
        if (head == null) {
            return new ListNode((int) add);
        }
        return head;
    }

    // 方法2: 利用递归依次计算数据
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (carry == 0 && (l1 == null || l2 == null)) {
            return l1 == null ? l2 : l1;
        }
        ListNode next1 = null, next2 = null;
        int val1 = 0, val2 = 0;
        if (l1 != null) {
            val1 = l1.val;
            next1 = l1.next;
        }
        if (l2 != null) {
            val2 = l2.val;
            next2 = l2.next;
        }
        int sum = val1 + val2 + carry;
        ListNode node = new ListNode(sum % 10);
        node.next = addTwoNumbers(next1, next2, sum / 10);
        return node;
    }

    // 方法3: 非递归的方法计算
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, p = null, head1 = l1, head2 = l2;
        int carry = 0, val1 = 0, val2 = 0;
        while (carry != 0 || (head1 != null && head2 != null)) {
            if (head1 != null) {
                val1 = head1.val;
                head1 = head1.next;
            } else {
                val1 = 0;
            }
            if (head2 != null) {
                val2 = head2.val;
                head2 = head2.next;
            } else {
                val2 = 0;
            }
            int sum = val1 + val2 + carry;
            ListNode node = new ListNode(sum % 10);
            if (head == null) {
                head = node;
            } else {
                p.next = node;
            }
            p = node;
            carry = sum / 10;
        }
        if (head == null) {
            head = new ListNode(0);
        } else {
            p.next = head1 != null ? head1 : head2;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)