//为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。 
//
// 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符
//构成。 
//
// 如果可以构成，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 233 👎 0


package com.jue.java.learn.leetcode.editor.cn.RansomNote;

/**
 * @author JUE
 * @number 383
 */
public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a", "b"));
        System.out.println(solution.canConstruct("aa", "ab"));
        System.out.println(solution.canConstruct("aa", "aab"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] magazineCount = new int[26];
        // 小写英文字母; 就应该是套路字母数组了
        for (char c : magazine.toCharArray()) {
            magazineCount[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (magazineCount[c - 'a'] == 0) {
                return false;
            }
            magazineCount[c - 'a']--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class SolutionMine {

    /**
     * 计算字符串每个字母的个数
     */
    private int[] count(String str) {
        int[] result = new int[26];
        // 小写英文字母; 就应该是套路字母数组了
        for (char c : str.toCharArray()) {
            result[c - 'a']++;
        }
        return result;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        // FIXME 官方: 先直接比较字符串长度
        int[] ransomNoteCount = count(ransomNote);
        // FIXME 官方: 第二次遍历同时比较字母是否够用! 减少极多的速度
        int[] magazineCount = count(magazine);
        // 比较数据
        for (int index = 0; index < 26; index++) {
            if (ransomNoteCount[index] > magazineCount[index]) {
                return false;
            }
        }
        return true;
    }
}


