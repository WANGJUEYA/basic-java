//package com.jue.java.learntest.leetcode.solution1248;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//class Solution {
//    public static void main(String[] args) {
//        System.out.println((new Solution()).numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
//        System.out.println((new Solution()).numberOfSubarrays(new int[]{2, 4, 6}, 1));
//        System.out.println((new Solution()).numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
//    }
//
//    public int numberOfSubarrays(int[] nums, int k) {
//        int len = nums.length;
//        if (len <= 0) {
//            return 0;
//        }
//        List<Integer> splits = new ArrayList<>();
//        int split = 0;
//        for (int index = 0; index <= len; index++) {
//            if (index == len || nums[index] % 2 == 1) {
//                splits.add(split);
//                split = 0;
//            } else {
//                split++;
//            }
//        }
//        len = splits.size();
//        int count = 0;
//        for (int index = 0; index < len - k; index++) {
//            count += (1 + splits.get(index)) * (1 + splits.get(index + k));
//        }
//        return count;
//    }
//}
//
//import com.jue.java.learntest.tooffer.bean.TreeNode;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// * int val;
// * TreeNode left;
// * TreeNode right;
// * TreeNode(int x) { val = x; }
// * }
// */
//class Solution {
//    public List<Integer> rightSideView(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        List<Integer> result = new ArrayList<>();
//        Queue<TreeNode> current = new LinkedList<>(), last;
//        current.add(root);
//        TreeNode temp;
//        // 使用队列记录每层节点(先进先出)
//        int value = -1;
//        while (!current.isEmpty()) {
//            last = new LinkedList<>();
//            while (!current.isEmpty()) {
//                temp = current.poll();
//                value = temp.val;
//                if (temp.left != null) {
//                    last.add(temp.left);
//                }
//                if (temp.right != null) {
//                    last.add(temp.right);
//                }
//            }
//            result.add(value);
//            current = last;
//        }
//        return result;
//    }
//}