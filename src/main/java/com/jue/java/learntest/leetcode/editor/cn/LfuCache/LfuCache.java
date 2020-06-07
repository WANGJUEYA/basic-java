//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。 
//
// 
// get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。 
// put(key, value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效
//。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最久未使用的键。 
// 
//
// 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
//
// 
//
// 进阶： 
//你是否可以在 O(1) 时间复杂度内执行两项操作？ 
//
// 
//
// 示例： 
//
// LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回 1
//cache.put(3, 3);    // 去除 key 2
//cache.get(2);       // 返回 -1 (未找到key 2)
//cache.get(3);       // 返回 3
//cache.put(4, 4);    // 去除 key 1
//cache.get(1);       // 返回 -1 (未找到 key 1)
//cache.get(3);       // 返回 3
//cache.get(4);       // 返回 4 
// Related Topics 设计


package com.jue.java.learntest.leetcode.editor.cn.LfuCache;

/**
 * @author JUE
 * @number 460
 */
public class LfuCache {
    public static void main(String[] args) {
        // 1
//        LFUCache cache = new LFUCache(2);
//        System.out.println(cache.get(2));
//        cache.put(2, 6);
//        System.out.println(cache.get(1));
//        cache.put(1, 5);
//        cache.put(1, 2);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
        // 2
//        LFUCache cache = new LFUCache(3);
//        cache.put(2, 2);
//        cache.put(1, 1);
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));
//        cache.put(3, 3);
//        cache.put(4, 4);
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(4));
        // 3
//        LFUCache cache = new LFUCache(1);
//        cache.put(0, 0);
//        System.out.println(cache.get(0));
        // 4
        LFUCache cache = new LFUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {

    // 缓存容量
    int[][] cache;
    int top = -1;

    public LFUCache(int capacity) {
        cache = new int[4][capacity]; // 0-key 1-value 2-count 4-time
    }

    public int get(int key) {
        if (cache[0].length <= 0) {
            return -1;
        }

        int result = -1;
        for (int index = 0; index <= top; index++) {
            if (key == cache[0][index]) {
                cache[2][index]++;
                cache[3][index] = 0;
                result = cache[1][index];
            } else {
                cache[3][index]++;
            }
        }
        return result;
    }

    public void put(int key, int value) {
        int len = cache[0].length;
        if (len <= 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i <= top; i++) {
            if (cache[2][i] < cache[2][index] || (cache[2][i] == cache[2][index] && cache[3][i] > cache[3][index])) {
                index = i;
            }
            if (key == cache[0][i]) {
                cache[1][i] = value;
                cache[2][i]++;
                cache[3][i] = 0;
                return;
            }
        }
        if (top < len - 1) {
            index = ++top;
        }
        cache[0][index] = key;
        cache[1][index] = value;
        cache[2][index] = 0;
        cache[3][index] = 0;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
