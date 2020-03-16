package com.jue.java.learntest.leetcode.solution0673;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int[] size = new int[len]; // 用于记录每个位置的长度(最长)
        int[] count = new int[len]; // 用于计数每种长度的个数

        int maxSize = Integer.MIN_VALUE;
        for (int index = 0; index < len; index++) {
            int thisSize = 1;
            int thisCount = 1;
            for (int j = 0; j < index; j++) {
                if (nums[index] > nums[j]) {
                    if (size[j] + 1 > thisSize) {
                        thisSize = size[j] + 1;
                        thisCount = count[j];
                    } else if (size[j] + 1 == thisSize) {
                        thisCount += count[j];
                    }
                }
            }
            maxSize = Math.max(maxSize, thisSize);
            size[index] = thisSize;
            count[index] = thisCount;
        }
        int result = 0;
        for (int index = 0; index < len; index++) {
            if (size[index] == maxSize) {
                result += count[index];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 4, 7};
        int[] array1 = new int[]{2, 2, 2, 2, 2};
        int[] array2 = new int[]{2, 3, 3, 3, 3};
        int[] array3 = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
        int[] array4 = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println((new Solution()).findNumberOfLIS(array4));
    }
}

class Solution_CustomTree {
    class CustomTree {
        int val;
        List<CustomTree> trees = new ArrayList<>();
    }

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        Map<Integer, Integer> sizeCount = new HashMap<>();
        // 根节点
        CustomTree root = new CustomTree();
        root.val = Integer.MIN_VALUE;
        for (Integer num : nums) {
            add(root, num, sizeCount, 0);
        }
        int max = Integer.MIN_VALUE;
        for (Integer key : sizeCount.keySet()) {
            max = Math.max(max, key);
        }
        return sizeCount.get(max);
    }

    public void add(CustomTree tree, Integer num, Map<Integer, Integer> sizeCount, Integer deep) {
        CustomTree self = new CustomTree();
        self.val = num;
        List<CustomTree> add = new ArrayList<>();
        for (CustomTree child : tree.trees) {
            add(child, num, sizeCount, deep + 1);
        }
        // 如果比当前节点大，就应该放进孩子队列
        if (num > tree.val) {
            tree.trees.add(self);
            if (sizeCount.containsKey(deep + 1)) {
                sizeCount.put(deep + 1, sizeCount.get(deep + 1) + 1);
            } else {
                sizeCount.put(deep + 1, 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 4, 7};
        int[] array1 = new int[]{2, 2, 2, 2, 2};
        int[] array2 = new int[]{2, 3, 3, 3, 3};
        int[] array3 = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
        int[] array4 = new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println((new Solution_CustomTree()).findNumberOfLIS(array4));
    }
}


class Solution_OutTime {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        Map<Integer, List<List<Integer>>> indexList = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int count = 0;
        // 找到所有的上升子串
        for (int index = 0; index < len; index++) {
            List<List<Integer>> all = new ArrayList<>();
            for (int j = 0; j < index; j++) {
                if (nums[index] > nums[j]) {
                    for (List<Integer> last : indexList.get(j)) {
                        List<Integer> temp = new ArrayList<>(last);
                        temp.add(nums[index]);
                        all.add(temp);
                        if (temp.size() > max) {
                            max = temp.size();
                            count = 1;
                        } else if (temp.size() == max) {
                            count++;
                        }
                    }
                }
            }
            if (all.isEmpty()) {
                List<Integer> self = new ArrayList<>();
                self.add(nums[index]);
                all.add(self);
                if (self.size() > max) {
                    max = self.size();
                    count = 1;
                } else if (self.size() == max) {
                    count++;
                }
            }
            indexList.put(index, all);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 4, 7};
        int[] array1 = new int[]{2, 2, 2, 2, 2};
        int[] array2 = new int[]{2, 3, 3, 3, 3};
        int[] array3 = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println((new Solution_OutTime()).findNumberOfLIS(array3));
    }
}