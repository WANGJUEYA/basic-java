//给你一个整数数组 nums ，返回其中 按位与三元组 的数目。 
//
// 按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件： 
//
// 
// 0 <= i < nums.length 
// 0 <= j < nums.length 
// 0 <= k < nums.length 
// nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,3]
//输出：12
//解释：可以选出如下 i, j, k 三元组：
//(i=0, j=0, k=1) : 2 & 2 & 1
//(i=0, j=1, k=0) : 2 & 1 & 2
//(i=0, j=1, k=1) : 2 & 1 & 1
//(i=0, j=1, k=2) : 2 & 1 & 3
//(i=0, j=2, k=1) : 2 & 3 & 1
//(i=1, j=0, k=0) : 1 & 2 & 2
//(i=1, j=0, k=1) : 1 & 2 & 1
//(i=1, j=0, k=2) : 1 & 2 & 3
//(i=1, j=1, k=0) : 1 & 1 & 2
//(i=1, j=2, k=0) : 1 & 3 & 2
//(i=2, j=0, k=1) : 3 & 2 & 1
//(i=2, j=1, k=0) : 3 & 1 & 2
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0]
//输出：27
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] < 2¹⁶ 
// 
//
// Related Topics 位运算 数组 哈希表 👍 128 👎 0


package com.jue.java.learn.leetcode.editor.cn.TriplesWithBitwiseAndEqualToZero;

/**
 * @author JUE
 * @number 982
 */
public class TriplesWithBitwiseAndEqualToZero {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.countTriplets(new int[]{2, 1, 3}));
        System.out.println(solution.countTriplets(new int[]{2, 4, 7, 3})); // 30
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countTriplets(int[] nums) {
        // 0 <= nums[i] < 2¹⁶
        // 全部数量 len ^ 3;
        // 不可能的数量 必须三个数某一位全为1, 采用动态规划, 第i位能三元组等于 i-1位能三元组且第i位能三元组
        int len = nums.length;
        int[][] bitNums = new int[len][17];
        int bitIndex = 0;
        boolean hasPositive = true;
        while (hasPositive) {
            hasPositive = false;
            for (int index = 0; index < len; index++) {
                bitNums[index][bitIndex] = nums[index] % 2;
                nums[index] /= 2;
                if (nums[index] > 0) {
                    // 如果有一个正数 继续循环
                    hasPositive = true;
                }
            }
            bitIndex++;
        }
        // 内存超出限制, 只存储未淘汰的数据; 时间超出限制, 只遍历队列
        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    boolean add = true;
                    for (int index = 0; index <= bitIndex; index++) {
                        if (bitNums[i][index] == 1 && bitNums[j][index] == 1 && bitNums[k][index] == 1) {
                            add = false;
                            break;
                        }
                    }
                    if (add) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
