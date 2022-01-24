//给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。 
//
// 每一步，你可以从下标 i 跳到下标： 
//
// 
// i + 1 满足：i + 1 < arr.length 
// i - 1 满足：i - 1 >= 0 
// j 满足：arr[i] == arr[j] 且 i != j 
// 
//
// 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。 
//
// 注意：任何时候你都不能跳到数组外面。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
//输出：3
//解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
// 
//
// 示例 2： 
//
// 输入：arr = [7]
//输出：0
//解释：一开始就在最后一个元素处，所以你不需要跳跃。
// 
//
// 示例 3： 
//
// 输入：arr = [7,6,9,6,9,6,9,7]
//输出：1
//解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
// 
//
// 示例 4： 
//
// 输入：arr = [6,1,9]
//输出：2
// 
//
// 示例 5： 
//
// 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 5 * 10^4 
// -10^8 <= arr[i] <= 10^8 
// 
// Related Topics 广度优先搜索 数组 哈希表 👍 157 👎 0


package com.jue.java.learn.leetcode.editor.cn.JumpGameIv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @number 1345
 */
public class JumpGameIv {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404})); // 3
        System.out.println(solution.minJumps(new int[]{7})); // 0
        System.out.println(solution.minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7})); // 1
        System.out.println(solution.minJumps(new int[]{6, 1, 9})); // 2
        System.out.println(solution.minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13})); // 3
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int minJumps(int[] arr) {
        int lastIdx = arr.length - 1;
        if (lastIdx <= 0) {
            return 0;
        }
        // 无权重无序图 广度遍历
        Map<Integer, List<Integer>> idxOfSame = new HashMap<>();
        for (int idx = 0; idx <= lastIdx; idx++) {
            if (idxOfSame.containsKey(arr[idx])) {
                idxOfSame.get(arr[idx]).add(idx);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(idx);
                idxOfSame.put(arr[idx], value);
            }
        }
        // 记录是否访问过
        boolean[] gone = new boolean[lastIdx];
        gone[0] = true;
        List<int[]> idxOfStep = new ArrayList<>();
        idxOfStep.add(new int[]{0, 0});
        while (!idxOfStep.isEmpty()) {
            int[] item = idxOfStep.remove(0);
            int currentIdx = item[0];
            List<Integer> idxes = new ArrayList<>();
            if (idxOfSame.containsKey(arr[currentIdx])) {
                idxes = idxOfSame.get(arr[currentIdx]);
                idxOfSame.remove(arr[currentIdx]);
            }
            idxes.add(currentIdx - 1);
            idxes.add(currentIdx + 1);
            gone[currentIdx] = true;
            for (Integer itemIdx : idxes) {
                if (itemIdx == lastIdx) {
                    return item[1] + 1;
                }
                if (currentIdx != itemIdx && itemIdx >= 0 && itemIdx <= lastIdx && !gone[itemIdx]) {
                    idxOfStep.add(new int[]{itemIdx, item[1] + 1});
                }
            }
        }
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
