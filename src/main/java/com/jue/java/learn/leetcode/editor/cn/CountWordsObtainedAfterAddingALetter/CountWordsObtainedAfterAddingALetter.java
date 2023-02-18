//给你两个下标从 0 开始的字符串数组 startWords 和 targetWords 。每个字符串都仅由 小写英文字母 组成。 
//
// 对于 targetWords 中的每个字符串，检查是否能够从 startWords 中选出一个字符串，执行一次 转换操作 ，得到的结果与当前 
//targetWords 字符串相等。 
//
// 转换操作 如下面两步所述： 
//
// 
// 追加 任何 不存在 于当前字符串的任一小写字母到当前字符串的末尾。
//
// 
// 例如，如果字符串为 "abc" ，那么字母 'd'、'e' 或 'y' 都可以加到该字符串末尾，但 'a' 就不行。如果追加的是 'd' ，那么结果字符串
//为 "abcd" 。 
// 
// 
// 重排 新字符串中的字母，可以按 任意 顺序重新排布字母。
// 
// 例如，"abcd" 可以重排为 "acbd"、"bacd"、"cbda"，以此类推。注意，它也可以重排为 "abcd" 自身。 
// 
// 
// 
//
// 找出 targetWords 中有多少字符串能够由 startWords 中的 任一 字符串执行上述转换操作获得。返回 targetWords 中这类 字
//符串的数目 。 
//
// 注意：你仅能验证 targetWords 中的字符串是否可以由 startWords 中的某个字符串经执行操作获得。startWords 中的字符串在这一
//过程中 不 发生实际变更。 
//
// 
//
// 示例 1： 
//
// 
//输入：startWords = ["ant","act","tack"], targetWords = ["tack","act","acti"]
//输出：2
//解释：
//- 为了形成 targetWords[0] = "tack" ，可以选用 startWords[1] = "act" ，追加字母 'k' ，并重排 
//"actk" 为 "tack" 。
//- startWords 中不存在可以用于获得 targetWords[1] = "act" 的字符串。
//  注意 "act" 确实存在于 startWords ，但是 必须 在重排前给这个字符串追加一个字母。
//- 为了形成 targetWords[2] = "acti" ，可以选用 startWords[1] = "act" ，追加字母 'i' ，并重排 
//"acti" 为 "acti" 自身。
// 
//
// 示例 2： 
//
// 
//输入：startWords = ["ab","a"], targetWords = ["abc","abcd"]
//输出：1
//解释：
//- 为了形成 targetWords[0] = "abc" ，可以选用 startWords[0] = "ab" ，追加字母 'c' ，并重排为 
//"abc" 。
//- startWords 中不存在可以用于获得 targetWords[1] = "abcd" 的字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= startWords.length, targetWords.length <= 5 * 10⁴ 
// 1 <= startWords[i].length, targetWords[j].length <= 26 
// startWords 和 targetWords 中的每个字符串都仅由小写英文字母组成 
// 在 startWords 或 targetWords 的任一字符串中，每个字母至多出现一次 
// 
// 👍 10 👎 0


package com.jue.java.learn.leetcode.editor.cn.CountWordsObtainedAfterAddingALetter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author JUE
 * @number 2135
 */
public class CountWordsObtainedAfterAddingALetter {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordCount(new String[]{"ant", "act", "tack"}, new String[]{"tack", "act", "acti"})); // 2
        System.out.println(solution.wordCount(new String[]{"ab", "a"}, new String[]{"abc", "abcd"})); // 1
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        // 关键条件: 至多出现一次, 不需要检验重复出现!
        // 异或结果是2的n次方
        int result = 0;
        HashSet<Integer> situation = new HashSet<>(); // 提高检索速度
        for (String s : startWords) {
            int origin = getMockInteger(s);
            for (int i = 0; i < 26; ++i) {
                // 不包含某个字母
                if (((origin >> i) & 1) == 0) {
                    // 一定不会进位!
                    situation.add(origin | (1 << i));
                }
            }
        }
        for (String targetWord : targetWords) {
            if (situation.contains(getMockInteger(targetWord))) {
                result++;
            }
        }
        return result;
    }

    private int getMockInteger(String str) {
        int res = 0;
        for (char ch : str.toCharArray()) {
            res |= 1 << (ch - 'a');
        }
        return res;
    }

}

//leetcode submit region end(Prohibit modification and deletion)
class Solution_TimeOut2 {
    public int wordCount(String[] startWords, String[] targetWords) {
        // 只能进行一次转换操作; 追加一个字符(不存在); 排序
        int result = 0;
        List<char[]> startList = Arrays.stream(startWords).map(item -> {
            char[] itemChar = item.toCharArray();
            Arrays.sort(itemChar);
            return itemChar;
        }).collect(Collectors.toList());
        for (String target : targetWords) {
            char[] itemChar = target.toCharArray();
            Arrays.sort(itemChar);
            for (char[] start : startList) {
                if (canConvert(start, itemChar)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    private boolean canConvert(char[] start, char[] target) {
        int sl = start.length, tl = target.length;
        // 注意: 必须追加字母
        if (sl + 1 == tl) {
            // 中间缺失字母 故使用双指针
            int l = 0, h = sl;
            while (l <= h) {
                if (l == h) {
                    // 有序的, 查不相等即左右不相等即可
                    if ((l == 0 || target[l] != target[l - 1]) && (h == sl || target[h] != target[h + 1])) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (target[l] == start[l]) {
                        l++;
                    } else if (target[h] == start[h - 1]) {
                        h--;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}

class Solution_TimeOut {
    // TODO 超时
    public int wordCount(String[] startWords, String[] targetWords) {
        int lenStart = startWords.length, lenTarget = targetWords.length;
        List<Map<Character, Integer>> countStart = new ArrayList<>();
        List<Map<Character, Integer>> countTarget = new ArrayList<>();
        for (String startWord : startWords) {
            countStart.add(countNum(startWord));
        }
        for (String targetWord : targetWords) {
            countTarget.add(countNum(targetWord));
        }
        int result = 0;
        for (int i = 0; i < lenTarget; i++) {
            boolean add = false;
            for (int j = 0; j < lenStart; j++) {
                // 只要有一个成功即可
                if (canConvert(new HashMap<>(countStart.get(j)), new HashMap<>(countTarget.get(i)))) {
                    add = true;
                    break;
                }
            }
            if (add) {
                result++;
            }
        }
        return result;
    }

    /**
     * 为字符串做单词计数
     */
    private Map<Character, Integer> countNum(String word) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : word.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return count;
    }

    private boolean canConvert(Map<Character, Integer> start, Map<Character, Integer> target) {
        // 如果全部相同也不算做转换; 转换只能做一次
        int count = 0;
        // 在接口调用外克隆后进入
        for (Map.Entry<Character, Integer> item : target.entrySet()) {
            // 如果 start的字母更多, 则直接无法替换
            int startCount = start.getOrDefault(item.getKey(), 0);
            if (startCount > item.getValue()) {
                return false;
            } else if (startCount == item.getValue()) {
                start.remove(item.getKey());
            } else {
                // 重复的字母更小则不允许追加相同字母
                if (startCount != 0 || item.getValue() > 1 || count > 0) {
                    return false;
                }
                start.remove(item.getKey());
                count = 1;
            }
        }
        return start.size() == 0 && count == 1;
    }
}
