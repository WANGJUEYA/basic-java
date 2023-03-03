//给你一个长度为 n 的字符串数组 names 。你将会在文件系统中创建 n 个文件夹：在第 i 分钟，新建名为 names[i] 的文件夹。
//
// 由于两个文件 不能 共享相同的文件名，因此如果新建文件夹使用的文件名已经被占用，系统会以 (k) 的形式为新文件夹的文件名添加后缀，其中 k 是能保证文件
//名唯一的 最小正整数 。
//
// 返回长度为 n 的字符串数组，其中 ans[i] 是创建第 i 个文件夹时系统分配给该文件夹的实际名称。
//
//
//
// 示例 1：
//
// 输入：names = ["pes","fifa","gta","pes(2019)"]
//输出：["pes","fifa","gta","pes(2019)"]
//解释：文件系统将会这样创建文件名：
//"pes" --> 之前未分配，仍为 "pes"
//"fifa" --> 之前未分配，仍为 "fifa"
//"gta" --> 之前未分配，仍为 "gta"
//"pes(2019)" --> 之前未分配，仍为 "pes(2019)"
//
//
// 示例 2：
//
// 输入：names = ["gta","gta(1)","gta","avalon"]
//输出：["gta","gta(1)","gta(2)","avalon"]
//解释：文件系统将会这样创建文件名：
//"gta" --> 之前未分配，仍为 "gta"
//"gta(1)" --> 之前未分配，仍为 "gta(1)"
//"gta" --> 文件名被占用，系统为该名称添加后缀 (k)，由于 "gta(1)" 也被占用，所以 k = 2 。实际创建的文件名为 "gta(2)"
//。
//"avalon" --> 之前未分配，仍为 "avalon"
//
//
// 示例 3：
//
// 输入：names = ["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]
//输出：["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"]
//解释：当创建最后一个文件夹时，最小的正有效 k 为 4 ，文件名变为 "onepiece(4)"。
//
//
// 示例 4：
//
// 输入：names = ["wano","wano","wano","wano"]
//输出：["wano","wano(1)","wano(2)","wano(3)"]
//解释：每次创建文件夹 "wano" 时，只需增加后缀中 k 的值即可。
//
// 示例 5：
//
// 输入：names = ["kaido","kaido(1)","kaido","kaido(1)"]
//输出：["kaido","kaido(1)","kaido(2)","kaido(1)(1)"]
//解释：注意，如果含后缀文件名被占用，那么系统也会按规则在名称后添加新的后缀 (k) 。
//
//
//
//
// 提示：
//
//
// 1 <= names.length <= 5 * 10^4
// 1 <= names[i].length <= 20
// names[i] 由小写英文字母、数字和/或圆括号组成。
//
//
// Related Topics 数组 哈希表 字符串 👍 53 👎 0


package com.jue.java.learn.leetcode.editor.cn.MakingFileNamesUnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author JUE
 * @number 1487
 */
public class MakingFileNamesUnique {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getFolderNames(new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"})));
        System.out.println(Arrays.toString(solution.getFolderNames(new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"})));
        System.out.println(Arrays.toString(solution.getFolderNames(new String[]{"kingston(0)", "kingston", "kingston"})));
        System.out.println(Arrays.toString(solution.getFolderNames(new String[]{"e", "g", "s(4)(2)", "a", "u", "b(2)", "s(2)", "h(2)", "g", "s", "h", "d", "v", "a(2)", "a", "s(4)", "y", "c", "l(1)(4)", "q", "m", "z", "j", "u", "b", "x", "n", "e", "m(1)(3)", "b", "n(1)(3)", "f", "n", "j", "e", "v", "d(1)", "e", "v(2)(4)", "c", "f", "v", "i", "p", "i(4)", "f", "k", "n", "c", "u"})));
        System.out.println(Arrays.toString(solution.getFolderNames(new String[]{"a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"})));
        System.out.println(Arrays.toString(solution.getFolderNames(new String[]{"q(4)", "v", "m", "o(4)", "d", "b(3)", "a", "o(2)", "q", "s(2)(1)", "p", "s(1)", "s", "a", "a", "y(4)(3)", "f", "u(4)", "a", "j", "u", "m(3)", "h", "o", "r", "a(2)(2)", "o(1)", "k(4)", "r", "p", "s", "a", "q", "f", "g(4)", "d", "p", "q", "z", "g", "t(1)(3)", "h", "n(4)", "g(3)", "t", "k", "d", "j", "j", "t(2)(2)", "d", "q", "r(4)", "i", "i", "i(4)(3)", "l(4)(4)", "w", "g", "i(4)(4)", "w(3)", "z", "r", "h", "d", "h", "z", "s(2)", "n", "p(3)(3)", "j", "y", "w(3)(3)", "y", "y(3)(1)", "l", "c(1)(3)", "b(3)", "p(3)", "n", "l", "m(4)", "n", "b(3)(3)", "x(3)(2)", "m", "k", "v(2)(2)", "h(2)", "q", "n(4)(4)", "f", "b", "o", "h", "n", "d(2)", "d", "d(1)(4)", "n(2)", "n", "n", "a", "m", "k", "d(3)", "b(2)(3)", "s", "j", "x(4)", "k", "c", "e(2)", "y(4)(1)", "u", "g", "v", "l", "f(4)(1)", "e", "r", "j", "g", "o(3)(2)", "w", "u(3)", "h(4)(2)", "w(4)(1)", "f(2)", "j", "x", "t", "b", "w", "y(4)", "p", "p", "o", "b", "g(4)", "o", "b(3)", "s(2)", "o", "z(4)", "d", "v(2)(3)", "t", "i", "l", "z", "y(2)", "y", "a(4)(3)", "c", "a", "x", "i", "d(4)", "y", "c", "u", "y(1)(4)", "v", "k(4)(1)", "d", "k(2)", "p", "f(4)(1)", "x(2)(2)", "j(1)", "n(3)", "z", "m(3)(3)", "y(3)", "u", "h", "c", "a", "v", "c", "w", "d(3)", "u", "j", "w", "t", "o", "r(1)", "l", "l(2)(2)", "a", "d(4)", "u", "k", "n", "h", "p(3)(3)", "l(1)(2)", "y", "z(3)", "h", "r", "g", "m(3)", "f", "u(4)(3)", "x", "z(3)", "x(4)", "s", "g", "q(3)", "o", "z", "x(3)(4)", "e(1)", "y", "h", "o(4)(2)", "u", "y", "d", "j", "n", "s(2)", "z(1)", "v", "y", "g", "r", "q", "d", "w", "l(1)(4)", "g", "j", "e(3)(4)", "b", "m", "p", "m(2)(4)", "b", "y", "f", "t(4)", "a", "g", "a", "b(2)", "v", "k", "m", "q(1)(3)", "t", "p(1)(3)", "k", "g(3)", "n", "e", "f", "v(2)(4)", "d(2)(3)", "a", "c", "a", "x", "z", "j", "j(2)", "m", "w", "f", "k", "d", "f(1)", "q", "n(3)(4)", "m", "w", "a", "b", "g", "g", "g(3)", "k", "b", "k(3)", "k", "l", "s(4)(3)", "u", "t", "l(3)", "w(4)", "z(4)(3)", "v(2)", "a", "u", "s(2)(1)", "b", "p(1)(2)", "g(4)(2)", "l", "k", "e", "j(3)(1)", "g", "r", "k(4)", "c", "w(2)(3)", "c(4)", "c", "w(3)(3)", "e", "p", "k(3)(2)", "a(3)(2)", "x", "u(3)(1)", "u(2)(2)", "d(1)(1)", "r", "f", "z", "l", "g(4)", "n", "u", "j", "h(1)(1)", "u", "d", "f", "w(1)(1)", "u(3)(2)", "s", "e", "f(2)(2)", "u(3)(2)", "k", "z", "y", "w(4)", "n", "i", "n", "j(1)(1)", "z(3)", "d", "h(2)", "u", "b", "i", "s(2)(3)", "v", "w", "m(1)(2)"})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

class Solution {
    Pattern pattern = Pattern.compile("^\\((\\d+)\\)$");
    Pattern patternCompare = Pattern.compile("(\\((\\d+)\\))*$");
    Pattern patternItem = Pattern.compile("\\((\\d+)\\)");

    public int compareTo(String a, String b) {
        if (a.equals(b)) {
            return 0;
        }
        // 问题 不能简单的处理一级, 必须层层遍历
        Matcher matcherA = patternCompare.matcher(a);
        Matcher matcherB = patternCompare.matcher(b);

        Matcher subA = patternItem.matcher(matcherA.find() ? matcherA.group(0) : "");
        Matcher subB = patternItem.matcher(matcherB.find() ? matcherB.group(0) : "");
        String remainA = matcherA.replaceAll("");
        String remainB = matcherB.replaceAll("");
        if (remainA.equals(remainB)) {
            int index = 0;
            // find(index) 重置匹配对象, 并在匹配对象中查找下一个匹配的子串
            while (subA.find(index) || subB.find(index)) {
                String itemA = subA.find(index) ? subA.group(1) : "-1";
                String itemB = subB.find(index) ? subB.group(1) : "-1";
                if (itemA.equals(itemB) && !"0".equals(itemA)) {
                    index += itemA.length();
                } else {
                    return Integer.parseInt(itemA) - Integer.parseInt(itemB);
                }
            }
        }
        return remainA.compareTo(remainB);
    }

    /**
     * @param list 有序列表
     * @param item 新增数据
     *             二分法有序插入
     */
    public void orderAdd(List<String> list, String item) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (compareTo(list.get(mid), item) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        list.add(low, item);
    }

    public String[] getFolderNames(String[] names) {
        // 优先队列, 从小到大排序 注意: 堆排序只能保证根是最大（最小），整个堆并不是有序的
        // PriorityQueue<String> existName = new PriorityQueue<>(Comparator.naturalOrder());
        // 手动实现插入排序: 问-没有现成的数据结构吗
        List<String> existName = new ArrayList<>();
        int len = names.length;
        String[] result = new String[len];
        for (int index = 0; index < len; index++) {
            String originName = names[index];
            // 二分法查找
            int find = -1, low = 0, high = index - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                int compare = compareTo(existName.get(mid), originName);
                if (compare == 0) {
                    find = mid;
                    break;
                } else if (compare < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (find >= 0) {
                int number = 1;
                int beginIndex = originName.length();
                for (int i = find; i < index; i++) {
                    String item = existName.get(i);
                    if (item.startsWith(originName)) {
                        Matcher matcher = pattern.matcher(item.substring(beginIndex));
                        if (matcher.find()) {
                            if (Objects.equals(matcher.group(1), Integer.toString(number))) {
                                number++;
                            }
                        }
                    } else {
                        break;
                    }
                }
                originName = originName + "(" + number + ")";
            }
            result[index] = originName;
            orderAdd(existName, originName);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
