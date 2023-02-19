//给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。
//
// 漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[
//j]) <= high 。
//
//
//
// 示例 1：
//
// 输入：nums = [1,4,2,7], low = 2, high = 6
//输出：6
//解释：所有漂亮数对 (i, j) 列出如下：
//    - (0, 1): nums[0] XOR nums[1] = 5
//    - (0, 2): nums[0] XOR nums[2] = 3
//    - (0, 3): nums[0] XOR nums[3] = 6
//    - (1, 2): nums[1] XOR nums[2] = 6
//    - (1, 3): nums[1] XOR nums[3] = 3
//    - (2, 3): nums[2] XOR nums[3] = 5
//
//
// 示例 2：
//
// 输入：nums = [9,8,4,2,1], low = 5, high = 14
//输出：8
//解释：所有漂亮数对 (i, j) 列出如下：
//​​​​​    - (0, 2): nums[0] XOR nums[2] = 13
//    - (0, 3): nums[0] XOR nums[3] = 11
//    - (0, 4): nums[0] XOR nums[4] = 8
//    - (1, 2): nums[1] XOR nums[2] = 12
//    - (1, 3): nums[1] XOR nums[3] = 10
//    - (1, 4): nums[1] XOR nums[4] = 9
//    - (2, 3): nums[2] XOR nums[3] = 6
//    - (2, 4): nums[2] XOR nums[4] = 5
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 10⁴
// 1 <= nums[i] <= 2 * 10⁴
// 1 <= low <= high <= 2 * 10⁴
//
//
// Related Topics 位运算 字典树 数组 👍 89 👎 0


package com.jue.java.learn.leetcode.editor.cn.CountPairsWithXorInARange;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @number 1803
 */
public class CountPairsWithXorInARange {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPairs(new int[]{1, 4, 2, 7}, 2, 6)); // 6
        System.out.println(solution.countPairs(new int[]{9, 8, 4, 2, 1}, 5, 14)); // 8
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int countPairs(int[] nums, int low, int high) {
        // 字典树方式 2 * 10⁴ < 2^15, 树的高度是15
        return getNumber(nums, high) - getNumber(nums, low - 1);
    }

    /**
     * 计算小于等于x的异或对数
     */
    public int getNumber(int[] nums, int x) {
        return 0;
    }

    public int add(MyTree tree, int num) {
        return 0;
    }


}

class MyTree {
    public int sum;
    public MyTree[] children; // 0是左节点, 左节点值也为0; 同理得右节点

    public MyTree() {
        this.children = new MyTree[2];
    }

    public MyTree addChildren(int num) {
        // num=0是左树, num=1是右数
        if (children[num] == null) {
            children[num] = new MyTree();
        }
        sum++;
        return children[num];
    }
}

//leetcode submit region end(Prohibit modification and deletion)
class Solution_TimeOut {
    public int countPairs(int[] nums, int low, int high) {
        // 名词解释: 异或: 位运算, 值相同为0, 值不同为1
        // 方案1: 使用模拟法处理数据 - 该方法面临运行超时的问题（PS: 测试结果, 超时!）
        return countPairsMock(nums, low, high);
    }

    private List<Integer> toByteList(int num) {
        List<Integer> result = new ArrayList<>();
        while (num > 0) {
            result.add(0, num % 2);
            num /= 2;
        }
        return result;
    }

    private int xor(List<Integer> num1, List<Integer> num2) {
        int size1 = num1.size(), size2 = num2.size();
        int total = Math.max(size1, size2);
        int result = 0;
        for (int index = 0; index < total; index++) {
            int index1 = size1 - total + index;
            int index2 = size2 - total + index;
            int a = index1 >= 0 ? num1.get(index1) : 0;
            int b = index2 >= 0 ? num2.get(index2) : 0;
            int item = a == b ? 0 : 1;
            result = result * 2 + item;
        }
        return result;
    }

    private int countPairsMock(int[] nums, int low, int high) {
        List<List<Integer>> byteList = new ArrayList<>();
        for (int num : nums) {
            byteList.add(toByteList(num));
        }
        int size = nums.length;
        int count = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int xor = xor(byteList.get(i), byteList.get(j));
                if (xor >= low && xor <= high) {
                    count++;
                }
            }
        }
        return count;
    }
}
