package com.jue.java.learntest.leetcode.solution_m_16_25;


/**
 * LRU是最近最少使用页面置换算法(Least Recently Used),也就是首先淘汰最长时间未被使用的页面!
 * <p>
 * LFU是最近最不常用页面置换算法(Least Frequently Used),也就是淘汰一定时期内被访问次数最少的页!
 * <p>
 * LRU关键是看页面最后一次被使用到发生调度的时间长短；
 * <p>
 * 而LFU关键是看一定时间段内页面被使用的频率!
 */
// 方案1: 用map存储计数值

// 方案2: 用数组存储计数值

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
    /**
     * 思路: 每次 get put 操作重置操作数据, 其他数据时间延迟
     */
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4); // ps: replace 1
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    // 新建数组用于存储数据及次数
    private int[][] cache = null;
    // 当前的数据长度
    private int num = 0;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("the capacity must be more than zero!");
        }
        // we could use hashmap, but it spand more space?
        cache = new int[3][capacity]; // 0-key 1-value 2-count
    }

    public int get(int key) {
        int value = -1;
        // 除操作数据所有数据加一
        for (int index = 0; index < num; index++) {
            if (cache[0][index] == key) {
                value = cache[1][index];
                cache[2][index] = 0;
            } else {
                cache[2][index]++;
            }
        }
        return value;
    }

    public void put(int key, int value) {
        boolean hasKey = false;
        int longestIndex = 0;
        for (int index = 0; index < num; index++) {
            if (cache[0][index] == key) {
                hasKey = true;
                cache[1][index] = value;
                cache[2][index] = 0;
            } else {
                cache[2][index]++;
                if (cache[2][index] > cache[2][longestIndex]) {
                    longestIndex = index;
                }
            }
        }
        if (!hasKey) {
            if (num >= cache[0].length) {
                cache[0][longestIndex] = key;
                cache[1][longestIndex] = value;
                cache[2][longestIndex] = 0;
            } else {
                cache[0][num] = key;
                cache[1][num] = value;
                cache[2][num] = 0;
                num++;
            }
        }
    }
}

class LRUCache_LinkedHashMap {

    /**
     * 利用有序的 LinkedHashMap 进行数据操作
     */
    public static void main(String[] args) {
        LRUCache_LinkedHashMap cache = new LRUCache_LinkedHashMap(2);
        // 1
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        // 2
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));
//        cache.put(3, 3);
//        System.out.println(cache.get(2));
//        cache.put(4, 4);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

    }

    // 缓存容量
    private int capacity = 0;
    private LinkedHashMap<Integer, Integer> map = null;

    public LRUCache_LinkedHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("the capacity must be more than zero!");
        }
        this.capacity = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
        // ps: LinkedHashMap 并没有修改map的插入方式, 直接位于末尾
        // 如果超出限制
        if (map.size() > capacity) {
            Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
            map.remove(entry.getKey());
        }
    }
}