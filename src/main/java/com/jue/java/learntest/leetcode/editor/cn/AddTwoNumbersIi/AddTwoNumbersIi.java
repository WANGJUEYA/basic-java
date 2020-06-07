//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表


package com.jue.java.learntest.leetcode.editor.cn.AddTwoNumbersIi;

import com.jue.java.learntest.tooffer.bean.ListNode;

import java.util.Stack;

/**
 * @author JUE
 * @number 445
 */
public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addTwoNumbers(new ListNode(5), new ListNode(5)));
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        int add = 0, item;
        ListNode result = null;
        while (!stack1.empty() || !stack2.empty() || add > 0) {
            item = add;
            item += stack1.empty() ? 0 : stack1.pop();
            item += stack2.empty() ? 0 : stack2.pop();
            add = item / 10;
            ListNode temp = new ListNode(item % 10);
            temp.next = result;
            result = temp;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
