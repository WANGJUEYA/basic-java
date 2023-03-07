//如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。
//
// 花括号展开的表达式可以看作一个由 花括号、逗号 和 小写英文字母 组成的字符串，定义下面几条语法规则：
//
//
// 如果只给出单一的元素 x，那么表达式表示的字符串就只有 "x"。R(x) = {x}
//
//
//
// 例如，表达式 "a" 表示字符串 "a"。
// 而表达式 "w" 就表示字符串 "w"。
//
//
// 当两个或多个表达式并列，以逗号分隔，我们取这些表达式中元素的并集。R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
//
// 例如，表达式 "{a,b,c}" 表示字符串 "a","b","c"。
// 而表达式 "{{a,b},{b,c}}" 也可以表示字符串 "a","b","c"。
//
//
// 要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。R(e_1 + e_2) = {a + b for (a,
//b) in R(e_1) × R(e_2)}
//
// 例如，表达式 "{a,b}{c,d}" 表示字符串 "ac","ad","bc","bd"。
//
//
// 表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
//
// 例如，表达式 "a{b,c,d}" 表示字符串 "ab","ac","ad"。
// 例如，表达式 "a{b,c}{d,e}f{g,h}" 可以表示字符串 "abdfg", "abdfh", "abefg", "abefh",
//"acdfg", "acdfh", "acefg", "acefh"。
//
//
//
//
// 给出表示基于给定语法规则的表达式 expression，返回它所表示的所有字符串组成的有序列表。
//
// 假如你希望以「集合」的概念了解此题，也可以通过点击 “显示英文描述” 获取详情。
//
//
//
// 示例 1：
//
//
//输入：expression = "{a,b}{c,{d,e}}"
//输出：["ac","ad","ae","bc","bd","be"]
//
// 示例 2：
//
//
//输入：expression = "{{a,z},a{b,c},{ab,z}}"
//输出：["a","ab","ac","z"]
//解释：输出中 不应 出现重复的组合结果。
//
//
//
//
// 提示：
//
//
// 1 <= expression.length <= 60
// expression[i] 由 '{'，'}'，',' 或小写英文字母组成
// 给出的表达式 expression 用以表示一组基于题目描述中语法构造的字符串
//
//
// Related Topics 栈 广度优先搜索 字符串 回溯 👍 146 👎 0


package com.jue.java.learn.leetcode.editor.cn.BraceExpansionIi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author JUE
 * @number 1096
 */
public class BraceExpansionIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.braceExpansionII("{a,b}{c,{d,e}}")); // ["ac","ad","ae","bc","bd","be"]
        System.out.println(solution.braceExpansionII("{{a,z},a{b,c},{ab,z}}")); // ["a","ab","ac","z"]
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> braceExpansionII(String expression) {
        // 需要用栈(类似计算器), ` `视作乘法, `,`视作加法, 优先级乘法优先级大于加法
        Stack<Object> options = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '{') {
                options.push(c);
            } else if (c == '}') {
                // 抵消一个开头
                List<String> current = null;
                while (!Objects.equals(options.peek(), '{')) {
                    Object pre = options.pop();
                    if (pre instanceof List) {
                        // 直接出栈对象做乘法
                        current = current == null ? (List<String>) pre : multi((List<String>) pre, current);
                    } else {
                        // 出栈是逗号做加法
                        pre = options.pop();
                        current = current == null ? (List<String>) pre : addAppend((List<String>) pre, current);
                    }
                }
                options.pop();
                assert current != null;
                // 计算乘法
                while (!options.empty() && !Objects.equals(options.peek(), ',') && !Objects.equals(options.peek(), '{')) {
                    Object pre = options.pop();
                    if (pre instanceof List) {
                        // 直接出栈对象做乘法
                        current = multi((List<String>) pre, current);
                    }
                }
                options.push(current);
            } else if (c == ',') {
                // 逗号直接入栈
                options.push(c);
            } else {
                if (Objects.equals(options.peek(), '{') || Objects.equals(options.peek(), ',')) {
                    List<String> current = new ArrayList<>();
                    current.add(c + "");
                    options.push(current);
                } else {
                    // 普通字符
                    Object pre = options.pop();
                    assert pre instanceof List;
                    // 直接出栈对象做乘法
                    options.push(multi((List<String>) pre, c + ""));
                }
            }
        }
        List<String> current = null;
        while (!options.empty()) {
            Object pre = options.pop();
            if (pre instanceof List) {
                // 直接出栈对象做乘法
                current = current == null ? (List<String>) pre : multi((List<String>) pre, current);
            } else {
                // 出栈是逗号做加法
                pre = options.pop();
                current = current == null ? (List<String>) pre : add((List<String>) pre, current);
            }
        }
        assert current != null;
        return current;
    }

    private List<String> add(List<String> a, List<String> b) {
        for (String item : b) {
            if (!a.contains(item)) {
                a.add(item);
            }
        }
        return a;
    }

    private List<String> addAppend(List<String> a, List<String> b) {
        for (String item : b) {
            a.remove(item);
            a.add(item);
        }
        return a;
    }

    private List<String> multi(List<String> a, String b) {
        List<String> result = new ArrayList<>();
        for (String itemA : a) {
            String key = itemA + b;
            result.remove(key);
            result.add(key);
        }
        return result;
    }

    private List<String> multi(List<String> a, List<String> b) {
        List<String> result = new ArrayList<>();
        for (String itemA : a) {
            for (String itemB : b) {
                String key = itemA + itemB;
                result.remove(key);
                result.add(key);
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
