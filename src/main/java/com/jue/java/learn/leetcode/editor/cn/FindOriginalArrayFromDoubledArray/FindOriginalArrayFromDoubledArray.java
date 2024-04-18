//一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有
//元素 随机打乱 。 
//
// 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 
//任意 顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：changed = [1,3,4,2,6,8]
//输出：[1,3,4]
//解释：一个可能的 original 数组为 [1,3,4] :
//- 将 1 乘以 2 ，得到 1 * 2 = 2 。
//- 将 3 乘以 2 ，得到 3 * 2 = 6 。
//- 将 4 乘以 2 ，得到 4 * 2 = 8 。
//其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
// 
//
// 示例 2： 
//
// 输入：changed = [6,3,0,1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 示例 3： 
//
// 输入：changed = [1]
//输出：[]
//解释：changed 不是一个双倍数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= changed.length <= 10⁵ 
// 0 <= changed[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 哈希表 排序 👍 59 👎 0


package com.jue.java.learn.leetcode.editor.cn.FindOriginalArrayFromDoubledArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 2007
 */
public class FindOriginalArrayFromDoubledArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{0, 0, 0, 0}))); // [0, 0]
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{1, 3, 4, 2, 6, 8}))); // [4, 3, 1]
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{6, 3, 0, 1}))); // []
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{1}))); // []
        System.out.println(Arrays.toString(solution.findOriginalArray(new int[]{4, 4}))); // []
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if (len % 2 == 1) {
            return new int[0];
        }
        int index = -1;
        int[] result = new int[len / 2];

        // 奇数
        Map<Integer, Integer> odd = new HashMap<>();
        // 偶数
        Map<Integer, Integer> even = new HashMap<>();
        for (int i : changed) {
            if (i % 2 == 1) {
                odd.put(i, odd.getOrDefault(i, 0) + 1);
            } else {
                even.put(i, even.getOrDefault(i, 0) + 1);
            }
        }
        Integer[] evenArr = even.keySet().toArray(new Integer[0]);
        Arrays.sort(evenArr);
        for (int i = evenArr.length - 1; i >= 0; ) {
            int max = evenArr[i];
            // 如果没有被删除
            if (even.get(max) > 0) {
                even.put(max, even.get(max) - 1);
                int div = max / 2;
                int count;
                if (div % 2 == 1) {
                    if (odd.containsKey(div) && (count = odd.get(div)) > 0) {
                        odd.put(div, count - 1);
                    } else {
                        return new int[0];
                    }
                } else {
                    if (even.containsKey(div) && (count = even.get(div)) > 0) {
                        even.put(div, count - 1);
                    } else {
                        return new int[0];
                    }
                }
                result[++index] = div;
            } else {
                i--;
            }
        }
        return index != (len / 2 - 1) ? new int[0] : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
