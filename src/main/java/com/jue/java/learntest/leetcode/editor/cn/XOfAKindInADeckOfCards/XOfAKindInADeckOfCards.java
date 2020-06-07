//给定一副牌，每张牌上都写着一个整数。 
//
// 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组： 
//
// 
// 每组都有 X 张牌。 
// 组内所有的牌上都写着相同的整数。 
// 
//
// 仅当你可选的 X >= 2 时返回 true。 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,3,4,4,3,2,1]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
// 
//
// 示例 2： 
//
// 输入：[1,1,1,2,2,2,3,3]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 示例 3： 
//
// 输入：[1]
//输出：false
//解释：没有满足要求的分组。
// 
//
// 示例 4： 
//
// 输入：[1,1]
//输出：true
//解释：可行的分组是 [1,1]
// 
//
// 示例 5： 
//
// 输入：[1,1,2,2,2,2]
//输出：true
//解释：可行的分组是 [1,1]，[2,2]，[2,2]
// 
//
// 
//提示： 
//
// 
// 1 <= deck.length <= 10000 
// 0 <= deck[i] < 10000 
// 
//
// 
// Related Topics 数组 数学


package com.jue.java.learntest.leetcode.editor.cn.XOfAKindInADeckOfCards;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 914
 */
public class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] array1 = {1, 1};
        System.out.println(solution.hasGroupsSizeX(array1));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        if (len <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : deck) {
            if (map.containsKey(d)) {
                map.put(d, map.get(d) + 1);
            } else {
                map.put(d, 1);
            }
        }
        for (int index = 2; index <= len; index++) {
            boolean result = true;
            for (Integer v : map.values()) {
                if (!result) {
                    break;
                }
                result = v % index == 0;
            }
            if (result) {
                return true;
            }
        }
        return false;

// 若 X 在输入数组中
//        for (Integer value : map.values()) {
//            if (value >= 2 && map.containsKey(value)) {
//                boolean result = true;
//                for (Integer v : map.values()) {
//                    if (!result) {
//                        break;
//                    }
//                    result = v % value == 0;
//                }
//                if (result) {
//                    return true;
//                }
//            }
//        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
