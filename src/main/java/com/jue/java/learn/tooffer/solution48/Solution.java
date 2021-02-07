package com.jue.java.learn.tooffer.solution48;

import com.jue.java.learn.tooffer.bean.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class Solution {
    Logger logger = LoggerFactory.getLogger(Solution.class);
    String loggerInfo;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pre = {1, 2, 3, 4};
        int[] in = {4, 3, 2, 1};
        solution.loggerInfo = solution.reConstructBinaryTree(pre, in).toString();
        solution.logger.info(solution.loggerInfo);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int[] rightPre;
        int[] rightIn;
        int[] leftPre;
        int[] leftIn;

        if (pre.length != in.length || pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);

        int mid = 0;
        while (in[mid] != pre[0]) {
            mid++;
        }

        rightPre = new int[mid];
        rightIn = new int[mid];
        leftPre = new int[pre.length - mid - 1];
        leftIn = new int[pre.length - mid - 1];

        for (int r = 1; r <= mid; r++) {
            rightPre[r - 1] = pre[r];
            loggerInfo = MessageFormat.format("rightPre[{0}]=pre[{1}]={2}", r - 1, r, pre[r]);
            logger.info(loggerInfo);
            rightIn[r - 1] = in[r - 1];
            loggerInfo = MessageFormat.format("rightIn[{0}]=in[{1}]={2}", r - 1, r - 1, in[r - 1]);
            logger.info(loggerInfo);
        }
        for (int l = mid + 1; l < pre.length; l++) {
            leftPre[l - mid - 1] = pre[l];
            loggerInfo = MessageFormat.format("leftPre[{0}]=pre[{1}]={2}", l - mid - 1, l, pre[l]);
            logger.info(loggerInfo);
            leftIn[l - mid - 1] = in[l];
            loggerInfo = MessageFormat.format("leftIn[{0}]=in[{1}]={2}", l - mid - 1, l, in[l]);
            logger.info(loggerInfo);
        }

        root.right = new Solution().reConstructBinaryTree(leftPre, leftIn);
        root.left = new Solution().reConstructBinaryTree(rightPre, rightIn);

        return root;
    }
}