//给你一个下标从 0 开始的二维整数数组 pairs ，其中 pairs[i] = [starti, endi] 。如果 pairs 的一个重新排列，满足对每
//一个下标 i （ 1 <= i < pairs.length ）都有 endi-1 == starti ，那么我们就认为这个重新排列是 pairs 的一个 合法
//重新排列 。 
//
// 请你返回 任意一个 pairs 的合法重新排列。 
//
// 注意：数据保证至少存在一个 pairs 的合法重新排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：pairs = [[5,1},{4,5},{11,9},{9,4]]
//输出：[[11,9},{9,4},{4,5},{5,1]]
//解释：
//输出的是一个合法重新排列，因为每一个 endi-1 都等于 starti 。
//end0 = 9 == 9 = start1 
//end1 = 4 == 4 = start2
//end2 = 5 == 5 = start3
// 
//
// 示例 2： 
//
// 
//输入：pairs = [[1,3},{3,2},{2,1]]
//输出：[[1,3},{3,2},{2,1]]
//解释：
//输出的是一个合法重新排列，因为每一个 endi-1 都等于 starti 。
//end0 = 3 == 3 = start1
//end1 = 2 == 2 = start2
//重新排列后的数组 [[2,1},{1,3},{3,2]] 和 [[3,2},{2,1},{1,3]] 都是合法的。
// 
//
// 示例 3： 
//
// 
//输入：pairs = [[1,2},{1,3},{2,1]]
//输出：[[1,2},{2,1},{1,3]]
//解释：
//输出的是一个合法重新排列，因为每一个 endi-1 都等于 starti 。
//end0 = 2 == 2 = start1
//end1 = 1 == 1 = start2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pairs.length <= 10⁵ 
// pairs[i].length == 2 
// 0 <= starti, endi <= 10⁹ 
// starti != endi 
// pairs 中不存在一模一样的数对。 
// 至少 存在 一个合法的 pairs 重新排列。 
// 
// 👍 1 👎 0


package com.jue.java.learn.leetcode.editor.cn.ValidArrangementOfPairs;

import java.util.*;

/**
 * @author JUE
 * @number 5932
 */
public class ValidArrangementOfPairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{5, 1}, {4, 5}, {11, 9}, {9, 4}})));
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{1, 3}, {3, 2}, {2, 1}})));
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{1, 2}, {1, 3}, {2, 1}})));
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{17, 18}, {18, 10}, {10, 18}})));
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{8, 5}, {8, 7}, {0, 8}, {0, 5}, {7, 0}, {5, 0}, {0, 7}, {8, 0}, {7, 8}})));
        System.out.println(Arrays.deepToString(solution.validArrangement(new int[][]{{5, 13}, {10, 6}, {11, 3}, {15, 19}, {16, 19}, {1, 10}, {19, 11}, {4, 16}, {19, 9}, {5, 11}, {5, 6}, {13, 5}, {13, 9}, {9, 15}, {11, 16}, {6, 9}, {9, 13}, {3, 1}, {16, 5}, {6, 5}})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // 经过精密的计算; 首尾使用次数一次; 出现最少的首位一定是第一次出现; 出现最少的末位一定是最后一次出现; 之后用递归的方式获取4
        // 以上纯属胡扯; 应该是一笔画联通的问题; 两头一定是一个奇数;
        // 如果有多个奇数则遍历所有情况; 如果没有奇数; 随便选一个就成
        int len = pairs.length;
        if (len <= 1) {
            return pairs;
        }
        if (len == 2) {
            if (pairs[0][1] != pairs[1][0]) {
                change(pairs, 0, 1);
            }
            return pairs;
        }
        execute(pairs, 0, len - 1);
        return pairs;
    }

    private boolean execute(int[][] pairs, int start, int end) {
        // System.out.println("(" + start + "," + end + ") >>> " + Arrays.deepToString(pairs));
        int len = pairs.length;
        if (start == end) {
            return (start == 0 || pairs[start][0] == pairs[start - 1][1])
                    && (end == len - 1 || pairs[end][1] == pairs[end + 1][0]);
        }
        if (start + 1 == end) {
            return (start == 0 || pairs[start][0] == pairs[start - 1][1])
                    && (pairs[start][1] == pairs[end][0])
                    && (end == len - 1 || pairs[end][1] == pairs[end + 1][0]);
        }
        Map<Integer, Integer> numberCount = new HashMap<>(16);
        for (int index = start; index <= end; index++) {
            addCount(numberCount, pairs[index][0]);
            addCount(numberCount, pairs[index][1]);
        }
        // 奇数(索引值; 数字)
        List<Integer> startOddIndexList = new ArrayList<>();
        List<Integer> endOddIndexList = new ArrayList<>();
        // 如果找不到奇数; 从偶数开始找
        List<Integer> startEvenIndexList = new ArrayList<>();
        List<Integer> endEvenIndexList = new ArrayList<>();
        int tempIndex;
        for (int i_start = start, i_end = end; i_start <= i_end; ) {
            startOddIndexList.clear();
            endOddIndexList.clear();
            startEvenIndexList.clear();
            endEvenIndexList.clear();
            // 找到和第一个交换的位置
            for (int j = i_start; j <= i_end; j++) {
                // (首位为奇数 且等于上一位的位置; 末位为奇数且等于后一位的位置); 全是偶数会出现失误
                if (i_start == 0 || pairs[i_start - 1][1] == pairs[j][0]) {
                    (numberCount.get(pairs[j][0]) % 2 == 1 ? startOddIndexList : startEvenIndexList).add(j);
                }
                if (i_end == len - 1 || pairs[i_end + 1][0] == pairs[j][1]) {
                    (numberCount.get(pairs[j][1]) % 2 == 1 ? endOddIndexList : endEvenIndexList).add(j);
                }
            }
            // 如果只有奇数 或者总共只有一个都可以走单分支; 其他情况只能走多分支
            if (startOddIndexList.size() == 1 || endOddIndexList.size() == 1
                    || (startOddIndexList.size() + startEvenIndexList.size() == 1)
                    || (endOddIndexList.size() + endEvenIndexList.size() == 1)) {
                // 首位右移
                boolean isStart;
                if (startOddIndexList.size() == 1) {
                    isStart = true;
                    tempIndex = startOddIndexList.get(0);
                } else if (endOddIndexList.size() == 1) {
                    isStart = false;
                    tempIndex = endOddIndexList.get(0);
                } else if (startEvenIndexList.size() == 1) {
                    isStart = true;
                    tempIndex = startEvenIndexList.get(0);
                } else {
                    isStart = false;
                    tempIndex = endEvenIndexList.get(0);
                }
                subCount(numberCount, pairs[tempIndex][0]);
                subCount(numberCount, pairs[tempIndex][1]);
                change(pairs, isStart ? i_start++ : i_end--, tempIndex);
            } else {
                // 如果两个都大; 选择较少的分支进行遍历
                boolean isStart;
                List<Integer> tempList;
                // 如果有奇数用奇数
                if (startOddIndexList.size() + endOddIndexList.size() > 0) {
                    if (endOddIndexList.size() == 0 || startOddIndexList.size() < endOddIndexList.size()) {
                        isStart = true;
                        tempList = startOddIndexList;
                    } else {
                        isStart = false;
                        tempList = endOddIndexList;
                    }

                } else if (startEvenIndexList.size() + endEvenIndexList.size() > 0) {
                    if (endEvenIndexList.size() == 0 || startEvenIndexList.size() < endEvenIndexList.size()) {
                        isStart = true;
                        tempList = startEvenIndexList;
                    } else {
                        isStart = false;
                        tempList = endEvenIndexList;
                    }
                } else {
                    return false;
                }
                for (int index : tempList) {
                    int[][] pairsCopy = pairs.clone();
                    change(pairsCopy, isStart ? i_start : i_end, index);
                    if (execute(pairsCopy, isStart ? i_start + 1 : i_start, isStart ? i_end : i_end - 1)) {
                        // 再补救一层校验
                        if ((i_start <= 0 || pairsCopy[i_start][0] == pairsCopy[i_start - 1][1])
                                && (i_end >= len - 1 || pairsCopy[i_end][1] == pairsCopy[i_end + 1][0])) {
                            // 复制
                            System.arraycopy(pairsCopy, 0, pairs, 0, len);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                // 如果走了多选路径还没正确答案返回错误(必有一条正确)
                return false;
            }
            // System.out.println("(" + i_start + "," + i_end + ") >>> " + Arrays.deepToString(pairs));
        }
        return true;
    }

    /**
     * 向计数器中新增一位
     */
    private void addCount(Map<Integer, Integer> map, int addNumber) {
        map.put(addNumber, map.containsKey(addNumber) ? map.get(addNumber) + 1 : 1);
    }

    /**
     * 向计数器中减少一位
     */
    private void subCount(Map<Integer, Integer> map, int subNumber) {
        map.put(subNumber, map.get(subNumber) - 1);
    }

    /**
     * 交换两个索引的位置
     */
    private void change(int[][] pairs, int pos1, int pos2) {
        if (pos1 == pos2) {
            return;
        }
        int[] temp = pairs[pos1];
        pairs[pos1] = pairs[pos2];
        pairs[pos2] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


