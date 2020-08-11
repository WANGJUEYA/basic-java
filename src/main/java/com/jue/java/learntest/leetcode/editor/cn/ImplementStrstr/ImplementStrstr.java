//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 527 👎 0


package com.jue.java.learntest.leetcode.editor.cn.ImplementStrstr;

/**
 * @author JUE
 * @number 28
 */
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("321", "1"));
        System.out.println(solution.strStr("123", "1"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        // 子串匹配算法
        // 1. BF 暴力匹配 O(mn)
        // 2. RK 按长度截取子串先匹配hash值
        // 3. KMP
        // 4. BM
        // 5. Sunday

        int leni = haystack.length();
        int lenj = needle.length();
        int hashj = needle.hashCode();
        for (int i = 0; i <= leni - lenj; i++) {
            String h = haystack.substring(i, i + lenj);
            if (h.hashCode() == hashj && h.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
