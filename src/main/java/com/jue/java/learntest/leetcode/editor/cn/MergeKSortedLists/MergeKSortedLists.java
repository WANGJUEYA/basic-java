//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法


package com.jue.java.learntest.leetcode.editor.cn.MergeKSortedLists;

import com.jue.java.learntest.tooffer.bean.ListNode;

/**
 * @author JUE
 * @number 23
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode[] list = new ListNode[3];
        list[0] = (new ListNode(new int[]{1, 4, 5}));
        list[1] = (new ListNode(new int[]{1, 3, 4}));
        list[2] = (new ListNode(new int[]{2, 6}));
        System.out.println(solution.mergeKLists(list));
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

    // 方法1: 暴力法, 每次寻找最小的,放入
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len <= 0) {
            return null;
        }
        int minIndex = -1;
        for (int index = 0; index < len; index++) {
            if (lists[index] == null) {
                continue;
            }
            if (minIndex == -1 || lists[index].val < lists[minIndex].val) {
                minIndex = index;
            }
        }
        if (minIndex == -1) {
            return null;
        }
        ListNode result = new ListNode(lists[minIndex].val);
        lists[minIndex] = lists[minIndex].next;
        result.next = mergeKLists(lists);
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
