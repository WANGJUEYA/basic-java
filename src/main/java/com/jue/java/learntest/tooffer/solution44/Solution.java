package com.jue.java.learntest.tooffer.solution44;


import com.jue.java.learntest.tooffer.bean.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).Print(new TreeNode("8,6,10,5,7,9,11")));
    }

    /**
     * 广度遍历
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<TreeNode> workQueue = new ArrayList<>();
        ArrayList<TreeNode> nextQueue;
        workQueue.add(pRoot);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean clockwise = true;
        do {
            nextQueue = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            int index = 0;
            while (!workQueue.isEmpty()) {
                if (!clockwise) {
                    index = workQueue.size() - 1;
                }
                TreeNode node = workQueue.get(index);
                workQueue.remove(index);
                //空节点的展示？
                if (node != null) {
                    temp.add(node.val);
                    if (clockwise) {
                        nextQueue.add(node.left);
                        nextQueue.add(node.right);
                    } else {
                        nextQueue.add(0, node.right);
                        nextQueue.add(0, node.left);
                    }
                }
            }
            if (!temp.isEmpty()) {
                result.add(temp);
            }
            workQueue = nextQueue;
            clockwise = !clockwise;
        } while (!nextQueue.isEmpty());
        return result;
    }
}

class SolutionPerfect {
    /**
     * 大家的实现很多都是将每层的数据存进ArrayList中，偶数层时进行reverse操作，
     * 在海量数据时，这样效率太低了。
     * （我有一次面试，算法考的就是之字形打印二叉树，用了reverse，
     * 直接被鄙视了，面试官说海量数据时效率根本就不行。）
     * <p>
     * 下面的实现：不必将每层的数据存进ArrayList中，偶数层时进行reverse操作，直接按打印顺序存入
     * 思路：利用Java中的LinkedList的底层实现是双向链表的特点。
     * 1)可用做队列,实现树的层次遍历
     * 2)可双向遍历,奇数层时从前向后遍历，偶数层时从后向前遍历
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);//层分隔符
        queue.addLast(pRoot);
        boolean leftToRight = true;

        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();
            if (node == null) {//到达层分隔符
                Iterator<TreeNode> iter = null;
                if (leftToRight) {
                    iter = queue.iterator();//从前往后遍历
                } else {
                    iter = queue.descendingIterator();//从后往前遍历
                }
                leftToRight = !leftToRight;
                while (iter.hasNext()) {
                    TreeNode temp = (TreeNode) iter.next();
                    list.add(temp.val);
                }
                ret.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);//添加层分隔符
                continue;//一定要continue
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        return ret;
    }
}