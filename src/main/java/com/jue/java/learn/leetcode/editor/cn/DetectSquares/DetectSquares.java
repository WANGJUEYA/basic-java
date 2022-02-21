//给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法： 
//
// 
// 添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。 
// 给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。 
// 
//
// 轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。 
//
// 实现 DetectSquares 类： 
//
// 
// DetectSquares() 使用空数据结构初始化对象 
// void add(int[] point) 向数据结构添加一个新的点 point = [x, y] 
// int count(int[] point) 统计按上述方式与点 point = [x, y] 共同构造 轴对齐正方形 的方案数。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
//[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 1
//0]]]
//输出：
//[null, null, null, null, 1, 0, null, 2]
//
//解释：
//DetectSquares detectSquares = new DetectSquares();
//detectSquares.add([3, 10]);
//detectSquares.add([11, 2]);
//detectSquares.add([3, 2]);
//detectSquares.count([11, 10]); // 返回 1 。你可以选择：
//                               //   - 第一个，第二个，和第三个点
//detectSquares.count([14, 8]);  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
//detectSquares.add([11, 2]);    // 允许添加重复的点。
//detectSquares.count([11, 10]); // 返回 2 。你可以选择：
//                               //   - 第一个，第二个，和第三个点
//                               //   - 第一个，第三个，和第四个点
// 
//
// 
//
// 提示： 
//
// 
// point.length == 2 
// 0 <= x, y <= 1000 
// 调用 add 和 count 的 总次数 最多为 5000 
// 
// Related Topics 设计 数组 哈希表 计数 👍 78 👎 0


package com.jue.java.learn.leetcode.editor.cn.DetectSquares;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @number 2013
 */
class DetectSquaresTest {
    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println(detectSquares.count(new int[]{11, 10})); // 1
        System.out.println(detectSquares.count(new int[]{14, 8})); // 0
        detectSquares.add(new int[]{11, 2});
        System.out.println(detectSquares.count(new int[]{11, 10})); // 2
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class DetectSquares {

    // 存储所有的坐标
    Map<Integer, Map<Integer, Integer>> countXY;

    public DetectSquares() {
        countXY = new HashMap<>();
    }

    public void add(int[] point) {
        Map<Integer, Integer> map = countXY.getOrDefault(point[0], new HashMap<>());
        map.put(point[1], map.getOrDefault(point[1], 0) + 1);
        countXY.put(point[0], map);
    }

    public int count(int[] point) {
        int result = 0;
        // 遍历同x坐标的数据
        if (countXY.containsKey(point[0])) {
            Map<Integer, Integer> yMap = countXY.get(point[0]);
            for (Map.Entry<Integer, Integer> item : yMap.entrySet()) {
                if (item.getKey() != point[1]) {
                    int len = point[1] - item.getKey();
                }
            }

//            for (int idx : idxOfX.get(point[0])) {
//                int[] one = points.get(idx);
//                if (one[1] == point[1]) {
//                    // 去除自己本身
//                    continue;
//                }
//                int len = Math.abs(point[1] - one[1]);
//                result += find(point, one, point[0] - len);
//                result += find(point, one, point[0] + len);
//            }
        }
        return result;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
//leetcode submit region end(Prohibit modification and deletion)

class DetectSquares_Timeout {

    // 存储所有的坐标
    List<int[]> points;
    Map<Integer, List<Integer>> idxOfX;

    public DetectSquares_Timeout() {
        points = new ArrayList<>();
        idxOfX = new HashMap<>();
    }

    public void add(int[] point) {
        if (!idxOfX.containsKey(point[0])) {
            idxOfX.put(point[0], new ArrayList<>());
        }
        idxOfX.get(point[0]).add(points.size());
        points.add(point);
    }

    public int count(int[] point) {
        int result = 0;
        // 遍历同x坐标的数据
        if (idxOfX.containsKey(point[0])) {
            for (int idx : idxOfX.get(point[0])) {
                int[] one = points.get(idx);
                if (one[1] == point[1]) {
                    // 去除自己本身
                    continue;
                }
                int len = Math.abs(point[1] - one[1]);
                result += find(point, one, point[0] - len);
                result += find(point, one, point[0] + len);
            }
        }
        return result;
    }

    private int find(int[] point, int[] one, int x) {
        int result = 0;
        if (idxOfX.containsKey(x)) {
            for (int twoIndex : idxOfX.get(x)) {
                int[] two = points.get(twoIndex);
                if (two[1] == one[1]) {
                    result += find(two[0], point[1]);
                }
            }
        }
        return result;
    }

    private int find(int x, int y) {
        int result = 0;
        for (int[] point : points) {
            if (x == point[0] && y == point[1]) {
                result++;
            }
        }
        return result;
    }

}