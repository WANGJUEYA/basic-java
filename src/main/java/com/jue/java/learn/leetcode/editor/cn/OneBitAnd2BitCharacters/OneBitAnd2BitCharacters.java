//有两种特殊字符： 
//
// 
// 第一种字符可以用一个比特 0 来表示 
// 第二种字符可以用两个比特(10 或 11)来表示、 
// 
//
// 给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。 
//
// 
//
// 示例 1: 
//
// 
//输入: bits = [1, 0, 0]
//输出: true
//解释: 唯一的编码方式是一个两比特字符和一个一比特字符。
//所以最后一个字符是一比特字符。
// 
//
// 示例 2: 
//
// 
//输入: bits = [1, 1, 1, 0]
//输出: false
//解释: 唯一的编码方式是两比特字符和两比特字符。
//所以最后一个字符不是一比特字符。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= bits.length <= 1000 
// bits[i] == 0 or 1 
// 
// Related Topics 数组 👍 252 👎 0


package com.jue.java.learn.leetcode.editor.cn.OneBitAnd2BitCharacters;

/**
 * @author JUE
 * @number 717
 */
public class OneBitAnd2BitCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isOneBitCharacter(new int[]{1, 0, 0})); // true
        System.out.println(solution.isOneBitCharacter(new int[]{1, 1, 1, 0})); // false
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if (len == 1) {
            return true;
        }
        return right(bits, len - 2);
    }

    private boolean right(int[] bits, int index) {
        if (index < 0) {
            return true;
        }
        if (bits[index] == 1) {
            return index - 1 >= 0 && bits[index - 1] == 1 && right(bits, index - 2);
        } else {
            if (index == 0) {
                return true;
            }
            if (bits[index - 1] == 0) {
                return right(bits, index - 1);
            } else {
                return right(bits, index - 1) || right(bits, index - 2);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
