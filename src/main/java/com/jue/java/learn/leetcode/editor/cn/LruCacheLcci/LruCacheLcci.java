//设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存
//被填满时，它应该删除最近最少使用的项目。 
//
// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新
//的数据值留出空间。 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计


package com.jue.java.learn.leetcode.editor.cn.LruCacheLcci;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 面试题 16.25
 */
public class LruCacheLcci {
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
}

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    /**
     * 思路: 每次 get put 操作重置操作数据, 其他数据时间延迟
     */
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)


class LRUCache_LinkedHashMap {

    /**
     * 利用有序的 LinkedHashMap 进行数据操作
     */
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