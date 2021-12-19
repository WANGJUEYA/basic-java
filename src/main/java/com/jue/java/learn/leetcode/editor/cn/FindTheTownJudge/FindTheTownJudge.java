//在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。 
//
// 如果小镇的法官真的存在，那么： 
//
// 
// 小镇的法官不相信任何人。 
// 每个人（除了小镇法官外）都信任小镇的法官。 
// 只有一个人同时满足条件 1 和条件 2 。 
// 
//
// 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。 
//
// 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2, trust = [[1,2]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 3, trust = [[1,3],[2,3]]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：n = 3, trust = [[1,3],[2,3],[3,1]]
//输出：-1
// 
//
// 示例 4： 
//
// 
//输入：n = 3, trust = [[1,2],[2,3]]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//输出：3 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 0 <= trust.length <= 10⁴ 
// trust[i].length == 2 
// trust[i] 互不相同 
// trust[i][0] != trust[i][1] 
// 1 <= trust[i][0], trust[i][1] <= n 
// 
// Related Topics 图 数组 哈希表 👍 184 👎 0


package com.jue.java.learn.leetcode.editor.cn.FindTheTownJudge;

/**
 * @author JUE
 * @number 997
 */
public class FindTheTownJudge {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findJudge(int n, int[][] trust) {
        // 默认信任列表没有重复 1. 小镇法官信任人数为 0 2. 小镇法官被信任人数为 n-1
        // 信任人数
        int[] trustNum = new int[n];
        // 被信任人数
        int[] trustedNum = new int[n];
        for (int[] item : trust) {
            trustNum[item[0] - 1]++;
            trustedNum[item[1] - 1]++;
        }
        // 默认自己相信自己不在信任列表中
        for (int index = 0; index < n; index++) {
            if (trustNum[index] == 0 && trustedNum[index] == n - 1) {
                return index + 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


