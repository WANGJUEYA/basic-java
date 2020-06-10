//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找


package com.jue.java.learntest.leetcode.editor.cn.SearchInRotatedSortedArray;

/**
 * @author JUE
 * @number 33
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution.search(new int[]{1, 3}, 0));
        System.out.println(solution.search(new int[]{5, 6, 0, 2}, 0));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 二分查找 时间复杂度为O(n log n)
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1, mid;
        if (nums[low] == target) {
            return low;
        }
        if (nums[high] == target) {
            return high;
        }
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_OutTime {
    // 暴力循环的解法 时间复杂度为 O(n) 空间复杂度为O(1)
    public int search(int[] nums, int target) {
        for (int index = 0, len = nums.length; index < len; index++) {
            if (nums[index] == target) {
                return index;
            }
        }
        return -1;
    }
}
