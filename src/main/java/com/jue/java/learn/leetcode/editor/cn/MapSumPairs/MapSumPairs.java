//实现一个 MapSum 类里的两个方法，insert 和 sum。 
//
// 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。 
//
// 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。 
//
// 示例 1: 
//
// 输入: insert("apple", 3), 输出: Null
//输入: sum("ap"), 输出: 3
//输入: insert("app", 2), 输出: Null
//输入: sum("ap"), 输出: 5
// 
// Related Topics 字典树


package com.jue.java.learn.leetcode.editor.cn.MapSumPairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 677
 */
public class MapSumPairs {
    public static void main(String[] args) {
        MapSum sum = new MapSum();
        sum.insert("apple", 3);
        System.out.println(sum.sum("ap"));
        sum.insert("app", 2);
        System.out.println(sum.sum("ap"));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
// 方案一: 用hashmap 存储键值对
class MapSum {
    Map<String, Integer> map = null;
    Map<String, Integer> key = null; // PS: the key of map may be replace

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        map = new HashMap<>();
        key = new HashMap<>();
    }

    public void insert(String key, int val) {
        if (this.key.containsKey(key)) {
            val = val - this.key.get(key);
        }
        for (int index = 0, num = key.length(); index < num; index++) {
            String temp = key.substring(0, index + 1);
            int value = val;
            if (map.containsKey(temp)) {
                value += map.get(temp);
            }
            map.put(temp, value);
        }
        this.key.put(key, val);
    }

    public int sum(String prefix) {
        return map.getOrDefault(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
