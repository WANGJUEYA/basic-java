//（这是一个 交互式问题 ） 
//
// 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 
//值。 
//
// 如果不存在这样的下标 index，就请返回 -1。 
//
// 
//
// 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件： 
//
// 首先，A.length >= 3 
//
// 其次，在 0 < i < A.length - 1 条件下，存在 i 使得： 
//
// 
// A[0] < A[1] < ... A[i-1] < A[i] 
// A[i] > A[i+1] > ... > A[A.length - 1] 
// 
//
// 
//
// 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据： 
//
// 
// MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始） 
// MountainArray.length() - 会返回该数组的长度 
// 
//
// 
//
// 注意： 
//
// 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。 
//
// 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请
//注意这 不是一个正确答案。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：array = [1,2,3,4,5,3,1], target = 3
//输出：2
//解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。 
//
// 示例 2： 
//
// 输入：array = [0,1,2,4,2,1], target = 3
//输出：-1
//解释：3 在数组中没有出现，返回 -1。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= mountain_arr.length() <= 10000 
// 0 <= target <= 10^9 
// 0 <= mountain_arr.get(index) <= 10^9 
// 
// Related Topics 二分查找


package com.jue.java.learn.leetcode.editor.cn.FindInMountainArray;

/**
 * @author JUE
 * @number 1095
 */
public class FindInMountainArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findInMountainArray(0, new MountainArray(new int[]{1, 5, 2})));
        System.out.println(solution.findInMountainArray(3, new MountainArray(new int[]{0, 5, 3, 1})));
        System.out.println(solution.findInMountainArray(1, new MountainArray(new int[]{3, 5, 3, 2, 0})));
        System.out.println(solution.findInMountainArray(2, new MountainArray(new int[]{0, 1, 2, 4, 2, 1})));
        System.out.println(solution.findInMountainArray(3, new MountainArray(new int[]{1, 2, 3, 5, 3})));
    }
}

class MountainArray {
    int[] array;

    public MountainArray(int[] array) {
        this.array = array;
    }

    int get(int index) {
        return array[index];
    }

    int length() {
        return array.length;
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 * public int get(int index) {}
 * public int length() {}
 * }
 */
class Solution {
    // 先查找山顶 再两次二分查找
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int high = mountainArr.length() - 1;
        int topIndex = topIndex(mountainArr, 0, high);

        int top = mountainArr.get(topIndex);
        if (target == top) {
            return topIndex;
        }

        if (target > top) {
            return -1;
        }

        int result = findInSortedArray(target, mountainArr, 0, high, true);
        if (result != -1) {
            return result;
        }

        return findInSortedArray(target, mountainArr, 0, high, false);
    }


    public int topIndex(MountainArray mountainArr, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int findInSortedArray(int target, MountainArray mountainArr, int low, int high, boolean sorted) {
        while (low < high) {
            int mid = low + (high - low + (sorted ? 0 : 1)) / 2;
            if (target > mountainArr.get(mid)) {
                if (sorted) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (sorted) {
                    high = mid;
                } else {
                    low = mid;
                }
            }
        }
        if (target == mountainArr.get(low)) {
            return low;
        }
        return -1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
class Solution_TooMany2 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        return findInMountainArray(target, mountainArr, 0, mountainArr.length() - 1);
    }


    public int findInMountainArray(int target, MountainArray mountainArr, int low, int high) {
        if (high < low) {
            return -1;
        }
        int mid = (low + high) / 2;
        int result = findInMountainArray(target, mountainArr, low, mid - 1);
        if (result != -1) {
            return result;
        }

        int midValue = mountainArr.get(mid);
        return target == midValue ? mid : findInMountainArray(target, mountainArr, mid + 1, high);
    }
}

class Solution_TooMany {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int high = mountainArr.length() - 1;
        if (target == mountainArr.get(0)) {
            return 0;
        }

        int result = findInMountainArray(target, mountainArr, 0, high);
        if (result == -1 && target == mountainArr.get(high)) {
            return high;
        } else {
            return result;
        }
    }


    public int findInMountainArray(int target, MountainArray mountainArr, int low, int high) {
        int mid, result = -1;
        while (low < high - 1) {
            mid = (low + high) / 2;
            int midValue = mountainArr.get(mid);
            if (target == midValue) {
                if (midValue < mountainArr.get(mid + 1)) {
                    return mid;
                } else {
                    result = mid;
                    high = mid - 1;
                }
            } else {
                int midValue_1 = mountainArr.get(mid - 1);
                if (midValue_1 == target) {
                    return mid - 1;
                }
                if (midValue > midValue_1) {
                    if (target > midValue) {
                        return findInMountainArray(target, mountainArr, mid, high);
                    } else {
                        result = findInMountainArray(target, mountainArr, low, mid - 1);
                        if (result == -1) {
                            return findInMountainArray(target, mountainArr, mid, high);
                        } else {
                            return result;
                        }
                    }
                } else {
                    if (target > mid) {
                        return findInMountainArray(target, mountainArr, low, mid - 1);
                    } else {
                        result = findInMountainArray(target, mountainArr, low, mid - 1);
                        if (result == -1) {
                            return findInMountainArray(target, mountainArr, mid, high);
                        } else {
                            return result;
                        }
                    }
                }

            }
        }
        return result;
    }
}
