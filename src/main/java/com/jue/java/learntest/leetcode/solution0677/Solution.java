package com.jue.java.learntest.leetcode.solution0677;

import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        MapSum sum = new MapSum();
        sum.insert("apple", 3);
        System.out.println(sum.sum("ap"));
        sum.insert("app", 2);
        System.out.println(sum.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */