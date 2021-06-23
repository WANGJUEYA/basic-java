//爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。 
//
// 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。） 
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。 
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [1,1], B = [2,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：A = [1,2], B = [2,3]
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：A = [2], B = [1,3]
//输出：[2,3]
// 
//
// 示例 4： 
//
// 
//输入：A = [1,2,5], B = [2,4]
//输出：[5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= B.length <= 10000 
// 1 <= A[i] <= 100000 
// 1 <= B[i] <= 100000 
// 保证爱丽丝与鲍勃的糖果总量不同。 
// 答案肯定存在。 
// 
// Related Topics 数组 
// 👍 172 👎 0


package com.jue.java.learn.leetcode.editor.cn.FairCandySwap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author JUE
 * @number 888
 */
public class FairCandySwap {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
        System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{2}, new int[]{1, 3})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] result = new int[2];
        // 如果 a b 总量差值 为 x
        // 则选两个数, 小 + x = 大
        // 1. 计算总数及差值
        Set<Integer> bobSet = new HashSet<>();
        int aliceSum = 0, bobSum = 0, aliceLen = aliceSizes.length, bobLen = bobSizes.length;
        for (int index = 0; index < aliceLen || index < bobLen; index++) {
            if (index < aliceLen) {
                aliceSum += aliceSizes[index];
            }
            if (index < bobLen) {
                bobSum += bobSizes[index];
                bobSet.add(bobSizes[index]);
            }
        }
        // 保证有答案则差值必须为偶数
        int sub = (aliceSum - bobSum) / 2;
        for (int item : aliceSizes) {
            int bobItem = item - sub;
            if (bobSet.contains(bobItem)) {
                result[0] = item;
                result[1] = bobItem;
                return result;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
