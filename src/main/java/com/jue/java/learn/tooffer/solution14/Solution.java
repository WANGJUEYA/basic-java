package com.jue.java.learn.tooffer.solution14;

import com.jue.java.learn.tooffer.bean.RandomListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        RandomListNode randomListNode = new RandomListNode(10);
        RandomListNode next = new RandomListNode(9);
        RandomListNode random = new RandomListNode(8);
        next.next = random;
        randomListNode.next = next;
        randomListNode.random = random;
        System.out.println(randomListNode);
        System.out.println(solution.Clone(randomListNode));
    }

    List<Integer> oldIndexes = new ArrayList<>();
    List<Integer> oldRandomIndexes = new ArrayList<>();
    List<RandomListNode> newNodes = new ArrayList<>();

    public RandomListNode Clone(RandomListNode pHead) {
        if (null == pHead) {
            return pHead;
        }
        //第一次循环,取出所有的节点
        RandomListNode temp = pHead;
        while (null != temp) {
            oldIndexes.add(temp.hashCode());
            oldRandomIndexes.add(null == temp.random ? null : temp.random.hashCode());
            newNodes.add(new RandomListNode(temp.label));
            temp = temp.next;
        }

        //建立结果
        for (int i = 0, n = oldIndexes.size(); i < n; i++) {
            if (i < n - 1) {
                newNodes.get(i).next = newNodes.get(i + 1);
            }
            int randomIndex = oldIndexes.indexOf(oldRandomIndexes.get(i));
            newNodes.get(i).random = -1 == randomIndex ? null : newNodes.get(randomIndex);
        }
        return newNodes.get(0);
    }
}

/**
 * 解题思路：
 * 1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
 * 2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
 * 3、拆分链表，将链表拆分为原链表和复制后的链表
 */
class SolutionPerfect {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }
}