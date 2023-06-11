//给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。 
//
// 删除完毕后，请你返回最终结果链表的头节点。 
//
// 
//
// 你可以返回任何满足题目要求的答案。 
//
// （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。） 
//
// 示例 1： 
//
// 输入：head = [1,2,-3,3,1]
//输出：[3,1]
//提示：答案 [1,2,1] 也是正确的。
// 
//
// 示例 2： 
//
// 输入：head = [1,2,3,-3,4]
//输出：[1,2,4]
// 
//
// 示例 3： 
//
// 输入：head = [1,2,3,-3,-2]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 给你的链表中可能有 1 到 1000 个节点。 
// 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000. 
// 
//
// Related Topics 哈希表 链表 👍 263 👎 0


package com.jue.java.learn.leetcode.editor.cn.RemoveZeroSumConsecutiveNodesFromLinkedList;

import com.jue.java.learn.tooffer.bean.ListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author JUE
 * @number 1171
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.removeZeroSumSublists(new ListNode(new int[]{1, 2, -3, 3, 1})));
//        System.out.println(solution.removeZeroSumSublists(new ListNode(new int[]{1, 2, 3, -3, 4})));
//        System.out.println(solution.removeZeroSumSublists(new ListNode(new int[]{1, 2, 3, -3, -2})));
//        System.out.println(solution.removeZeroSumSublists(new ListNode(new int[]{1, -1})));
//        System.out.println(solution.removeZeroSumSublists(new ListNode(new int[]{2, 0})));
//        System.out.println(solution.removeZeroSumSublists(new ListNode(new int[]{-1, 1, 0, 1})));
        System.out.println(solution.removeZeroSumSublists(new ListNode(new int[]{2, 2, -2, 1, -1, -1})));
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
    public ListNode removeZeroSumSublists(ListNode head) {
        // 有个很相似的前缀和问题，队列和数组都不能满足条件，故使用栈
        Set<Integer> sumSet = new HashSet<>();
        Stack<ListNode> stack = new Stack<>();
        ListNode result = head;
        int prefix = 0;
        ListNode next = result;
        while (next != null) {
            if (next.val == 0) {
                if (stack.isEmpty()) {
                    result = next.next;
                } else {
                    stack.peek().next = next.next;
                }
                next = next.next;
                continue;
            }
            int prefixCurrent = prefix + next.val;
            if (prefixCurrent == 0 || sumSet.contains(prefixCurrent)) {
                int nowPrefix = prefixCurrent - next.val;
                while (!stack.isEmpty()) {
                    // 出栈到最后一个
                    ListNode pre = stack.pop();
                    sumSet.remove(nowPrefix);
                    nowPrefix -= pre.val;
                    if (nowPrefix == prefixCurrent) {
                        prefix = nowPrefix;
                        if (stack.isEmpty()) {
                            result = next.next;
                        } else {
                            stack.peek().next = next.next;
                        }
                        break;
                    }
                }
            } else {
                prefix = prefixCurrent;
                sumSet.add(prefixCurrent);
                stack.push(next);
            }
            next = next.next;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
