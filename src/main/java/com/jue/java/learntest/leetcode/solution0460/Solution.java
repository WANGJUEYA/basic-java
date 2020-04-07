package com.jue.java.learntest.leetcode.solution0460;


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LFUCache {

    /**
     * 最近最少使用: 注意有使用顺序(增加一个时间戳)
     */
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