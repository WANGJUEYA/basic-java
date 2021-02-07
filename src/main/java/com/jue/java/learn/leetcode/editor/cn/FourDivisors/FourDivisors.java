//给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。 
//
// 如果数组中不存在满足题意的整数，则返回 0 。 
//
// 
//
// 示例： 
//
// 输入：nums = [21,4,7]
//输出：32
//解释：
//21 有 4 个因数：1, 3, 7, 21
//4 有 3 个因数：1, 2, 4
//7 有 2 个因数：1, 7
//答案仅为 21 的所有因数的和。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^4 
// 1 <= nums[i] <= 10^5 
// 
// Related Topics 数学


package com.jue.java.learn.leetcode.editor.cn.FourDivisors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 1390
 */
public class FourDivisors {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {4, 7, 21};
        int[] array1 = {90779, 36358, 90351, 75474, 32986};
        System.out.println(solution.sumFourDivisors(array1));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[] primeList = new boolean[(int) (1E5) + 1]; // false 为质数

    {
        countPrime();
    }

    public void countPrime() {
        int len = (int) (1E5) + 1;
        primeList[0] = true;
        primeList[1] = true;
        for (int index = 2; index < len; index++) {
            if (!primeList[index]) {
                // 将所有相关的合数标记
                int mul = 2;
                while (index * mul < len) {
                    primeList[index * mul] = true;
                    mul++;
                }
            }
        }
    }


    public int sumFourDivisors(int[] nums) {
        int len = (int) (1E5) + 1;
        Map<Integer, Integer> sumWithKey = new HashMap<>();
        int sum = 0;
        for (int num : nums) {
            if (sumWithKey.containsKey(num)) {
                sum += sumWithKey.get(num);
                continue;
            }
            int tempSum = 0;
            if (primeList[num]) {
                for (int index = 2; index < len; index++) {
                    if (!primeList[index]) {
                        if (index * index > num) {
                            break;
                        } else if (num % index == 0) {
                            int sub = num / index;
                            if (sub != index && (!primeList[sub] || sub == index * index)) {
                                tempSum = tempSum + 1 + num + index + sub;
                            }
                            break;
                        }
                    }
                }
            }
            sumWithKey.put(num, tempSum);
            sum += tempSum;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
