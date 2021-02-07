//给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0
// 的节点。 
//
// 请你设计并实现 getKthAncestor(int node, int k) 函数，函数返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节
//点，返回 -1 。 
//
// 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。 
//
// 
//
// 示例： 
//
// 
//
// 输入：
//["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
//[[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
//
//输出：
//[null,1,0,-1]
//
//解释：
//TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
//
//treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
//treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
//treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 5*10^4 
// parent[0] == -1 表示编号为 0 的节点是根节点。 
// 对于所有的 0 < i < n ，0 <= parent[i] < n 总成立 
// 0 <= node < n 
// 至多查询 5*10^4 次 
// 
// Related Topics 动态规划


package com.jue.java.learn.leetcode.editor.cn.KthAncestorOfATreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 5188
 */
public class KthAncestorOfATreeNode {
    public static void main(String[] args) {
//        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
//        System.out.println(treeAncestor.getKthAncestor(3, 1));
//        System.out.println(treeAncestor.getKthAncestor(5, 2));
//        System.out.println(treeAncestor.getKthAncestor(6, 3));

        TreeAncestor treeAncestor = new TreeAncestor(5, new int[]{-1, 0, 0, 1, 2});
        System.out.println(treeAncestor.getKthAncestor(3, 5));
        System.out.println(treeAncestor.getKthAncestor(3, 2));
        System.out.println(treeAncestor.getKthAncestor(2, 2));
        System.out.println(treeAncestor.getKthAncestor(0, 2));
        System.out.println(treeAncestor.getKthAncestor(2, 1));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
// TODO should learn
class TreeAncestor {
    int[][] dp;

    public TreeAncestor(int n, int[] parent) {
        dp = new int[n][(int) (Math.log(n) / Math.log(2)) + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = parent[i];
        }
        for (int j = 1; (1 << j) < n; j++) {
            for (int i = 0; i < n; i++) {
                if (dp[i][j - 1] != -1) {
                    dp[i][j] = dp[dp[i][j - 1]][j - 1];
                } else dp[i][j] = -1;
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        if (k == 0 || node == -1) return node;
        int p = (int) (Math.log(k) / Math.log(2));
        return getKthAncestor(dp[node][p], k - (1 << p));
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
//leetcode submit region end(Prohibit modification and deletion)

class TreeAncestor_TimeOut {

    private int[] parent;
    private int len;

    // 二叉树每层节点数目为 2^(n-1)
    // 二叉树满二叉树公有 2^n -1
    public TreeAncestor_TimeOut(int n, int[] parent) {
        this.parent = parent;
        this.len = parent.length;
    }

    // 暴力遍历法
    public int getKthAncestor(int node, int k) {
        while (k-- > 0) {
            if (node >= 0 && node < len) {
                node = parent[node];
            } else {
                return -1;
            }
        }
        return node;
    }
}


class TreeAncestor_MemoryOut {

    Map<Integer, int[]> map = new HashMap<>();

    // 二叉树每层节点数目为 2^(n-1)
    // 二叉树满二叉树公有 2^n -1
    // 初始化时存储各父辈
    public TreeAncestor_MemoryOut(int n, int[] parent) {
        int len = parent.length;
        this.map.put(0, new int[0]);
        for (int index = 1; index < len; index++) {
            int pNode = parent[index];
            int[] pNodeList = map.get(pNode);
            int[] nodeList = Arrays.copyOf(pNodeList, pNodeList.length + 1);
            nodeList[pNodeList.length] = pNode;
            map.put(index, nodeList);
        }
    }

    // 暴力遍历法
    public int getKthAncestor(int node, int k) {
        if (map.containsKey(node)) {
            int len = map.get(node).length;
            if (k > 0 && k <= len) {
                return map.get(node)[len - k];
            }
        }
        return -1;
    }
}
