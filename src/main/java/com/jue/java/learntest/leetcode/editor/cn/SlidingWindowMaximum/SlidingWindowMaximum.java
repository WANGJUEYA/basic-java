//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 693 👎 0


package com.jue.java.learntest.leetcode.editor.cn.SlidingWindowMaximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author JUE
 * @number 239
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{9, 11}, 2)));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int rLen = len - k + 1;
        if (rLen <= 0) {
            return new int[0];
        }
        int rIndex = 0;
        int[] result = new int[rLen];
        Deque<Integer> doubleArray = new LinkedList<>();
        for (int index = 0; index < k; index++) {
            while (!doubleArray.isEmpty() && nums[index] > nums[doubleArray.peekLast()]) {
                doubleArray.pollLast();
            }
            doubleArray.offerLast(index);
        }
        result[rIndex++] = nums[doubleArray.peekFirst()];
        for (int index = k; index < len; index++) {
            while (!doubleArray.isEmpty() && nums[index] > nums[doubleArray.peekLast()]) {
                doubleArray.pollLast();
            }
            doubleArray.offerLast(index);
            while (!doubleArray.isEmpty() && doubleArray.peekFirst() <= index - k) {
                doubleArray.pollFirst();
            }
            result[rIndex++] = nums[doubleArray.peekFirst()];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_Heep_Perfect {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 经典! 同时记住位置
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            // 关键一步! 如果最大数的坐标比较小直接统一删除, 免去了每次重复遍历!
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}

class Solution_Heep {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 最笨的办法
        // 判断结果数组长度
        int len = nums.length;
        int rLen = len - k + 1;
        if (rLen <= 0) {
            return new int[0];
        }
        int rIndex = 0;
        int[] result = new int[rLen];
        // 使用堆进行优化
        // 大顶堆
        PriorityQueue<Integer> currentHeep = new PriorityQueue<>(len, (i1, i2) -> i2 - i1);
        for (int index = 0; index < len; index++) {
            currentHeep.add(nums[index]);
            if (index >= k) {
                currentHeep.remove(nums[index - k]);
            }

            if (index >= k - 1) {
                assert currentHeep.size() > 0;
                result[rIndex++] = currentHeep.peek();
            }
        }
        return result;
    }
}

class Solution_Timeout {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 最笨的办法
        // 判断结果数组长度
        int len = nums.length;
        int rLen = len - k + 1;
        if (rLen <= 0) {
            return new int[0];
        }
        int rIndex = 0;
        int[] result = new int[rLen];
        int currentMax = Integer.MIN_VALUE;
        for (int index = 0; index < len; index++) {
            if (index < k) {
                currentMax = Math.max(currentMax, nums[index]);
            } else {
                if (nums[index] > currentMax) {
                    currentMax = nums[index];
                } else if (nums[index - k] >= currentMax) {
                    // 最大值离开了, 重新计算
                    currentMax = Integer.MIN_VALUE;
                    // 不能使用二分(无序) 但可以使用双指针
                    for (int tempIndex = (index - k + 1); tempIndex <= index; tempIndex++) {
                        currentMax = Math.max(currentMax, nums[tempIndex]);
                    }
                }
            }

            if (index >= k - 1) {
                result[rIndex++] = currentMax;
            }
        }
        return result;
    }
}

