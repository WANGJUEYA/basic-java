//一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [
//passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。 
//
// 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 
//extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。 
//
// 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。 
//
// 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10⁻⁵ 以内的结果都会视为正确结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
//输出：0.78333
//解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
// 
//
// 示例 2： 
//
// 
//输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
//输出：0.53485
// 
//
// 
//
// 提示： 
//
// 
// 1 <= classes.length <= 10⁵ 
// classes[i].length == 2 
// 1 <= passi <= totali <= 10⁵ 
// 1 <= extraStudents <= 10⁵ 
// 
//
// Related Topics 贪心 数组 堆（优先队列） 👍 81 👎 0


package com.jue.java.learn.leetcode.editor.cn.MaximumAveragePassRatio;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author JUE
 * @number 1792
 */
public class MaximumAveragePassRatio {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 尝试使用动态规划, 贪心算法，局部最优认为整体最优; 每一步分配都认为是最优的
        // 方法没错, 但是超时了, 用优先队列存储, 最次出栈一个最大的再补上一个该点的新值
        // 班级数量
        int len = classes.length;
        Queue<AvgItem> avgItemQueue = new PriorityQueue<>(Comparator.comparingDouble((a) -> -a.addAvg));
        // 当前每个班的平均值
        double[] classAvg = new double[len];
        for (int index = 0; index < len; index++) {
            int[] item = classes[index];
            classAvg[index] = (item[0] * 1.0) / item[1];
            double currentSub = (item[0] + 1.0) / (item[1] + 1.0) - classAvg[index];
            avgItemQueue.add(new AvgItem(index, currentSub));
        }
        while (extraStudents-- > 0) {
            AvgItem max = avgItemQueue.poll();
            classes[max.index][0]++;
            classes[max.index][1]++;
            classAvg[max.index] += max.addAvg;
            int[] item = classes[max.index];
            double currentSub = (item[0] + 1.0) / (item[1] + 1.0) - classAvg[max.index];
            avgItemQueue.add(new AvgItem(max.index, currentSub));
        }
        return Arrays.stream(classAvg).sum() / len;
    }

    class AvgItem {
        private final int index;
        private final double addAvg;

        public AvgItem(int index, double addAvg) {
            this.index = index;
            this.addAvg = addAvg;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
class Solution_TimeOut {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 尝试使用动态规划, 贪心算法，局部最优认为整体最优; 每一步分配都认为是最优的
        // 班级数量
        int len = classes.length;
        // 当前每个班的平均值
        double[] classAvg = new double[len];
        for (int index = 0; index < len; index++) {
            int[] item = classes[index];
            classAvg[index] = (item[0] * 1.0) / item[1];
        }
        while (extraStudents > 0) {
            double maxSub = 0;
            int maxIndex = 0;
            for (int index = 0; index < len; index++) {
                int[] item = classes[index];
                double currentSub = (item[0] + 1.0) / (item[1] + 1.0) - classAvg[index];
                if (currentSub > maxSub) {
                    maxSub = currentSub;
                    maxIndex = index;
                }
            }
            classes[maxIndex][0]++;
            classes[maxIndex][1]++;
            classAvg[maxIndex] += maxSub;
            extraStudents--;
        }
        return Arrays.stream(classAvg).sum() / len;
    }
}
