//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


package com.jue.java.learn.leetcode.editor.cn.MedianOfTwoSortedArrays;

/**
 * @author JUE
 * @number 4
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
        System.out.println(solution.findMedianSortedArrays(nums3, nums4));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1 == null ? 0 : nums1.length;
        int len2 = nums2 == null ? 0 : nums2.length;
        int len = len1 + len2;
        int medianIndex = len / 2;
        // 判断是否为奇数
        boolean odd = (len % 2) > 0;
        // 排除两者均为空的情况
        if (nums1 == null && nums2 != null) {
            if (odd) {
                return nums2[medianIndex];
            } else {
                return (nums2[medianIndex - 1] + nums2[medianIndex]) / 2D;
            }
        }
        if (nums1 != null && nums2 == null) {
            if (odd) {
                return nums1[medianIndex];
            } else {
                return (nums1[medianIndex - 1] + nums1[medianIndex]) / 2D;
            }
        }
        int index1 = 0, index2 = 0;
        Integer sum = null;
        while (index1 < len1 && index2 < len2) {
            if (!odd && index1 + index2 == medianIndex - 1) {
                sum = Math.min(nums1[index1], nums2[index2]);
            }
            if (index1 + index2 == medianIndex) {
                int num = Math.min(nums1[index1], nums2[index2]);
                if (odd) {
                    return num;
                } else {
                    return (sum + num) / 2D;
                }
            }
            if (nums1[index1] <= nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        assert nums2 != null;
        int num = index1 < len1 ? nums1[medianIndex - index2] : nums2[medianIndex - index1];
        if (odd) {
            return num;
        } else {
            if (sum == null) {
                sum = index1 < len1 ? nums1[medianIndex - 1 - index2] : nums2[medianIndex - 1 - index1];
            }
            return (sum + num) / 2D;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class SolutionPerfect {
    // 方法1: 二分法之求第k小的数
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    // 方法2： 递归方法求最小值
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays2(B, A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && B[j - 1] > A[i]) { // i 需要增大
                iMin = i + 1;
            } else if (i != 0 && j != n && A[i - 1] > B[j]) { // i 需要减小
                iMax = i - 1;
            } else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
    }
}