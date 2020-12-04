package com.jue.java.learntest.leetbook.hashtable;

import java.util.Arrays;

/**
 * @author JUE
 * @date 2020/10/17
 */
class MyHashSet {

    private final int hashNumber;
    /**
     * 这里使用数组集合来进行模拟hash表 由于操作10000次, 故设置初始容量大小为 100 * 100
     * 第0位存储索引值
     */
    private final int[][] memory;
    private final int[] count;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        int hashNumber = 2;
        int capacity = 2;
        // 此处可以配置动态的大小
        this.hashNumber = hashNumber;
        this.memory = new int[hashNumber][capacity];
        this.count = new int[hashNumber];
    }

    public void add(int key) {
        // 注意 hashSet需要先判断是否存在
        if (contains(key)) {
            return;
        }
        int addr = hash(key);
        if (count[addr] >= memory[addr].length) {
            memory[addr] = expand(memory[addr]);
        }
        memory[addr][count[addr]++] = key;
    }

    public void remove(int key) {
        // 目前移除方法会很慢, 因为不是使用的指针
        int addr = hash(key);
        for (int index = 0; index < count[addr]; index++) {
            if (memory[addr][index] == key) {
                remove(addr, index);
                return;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int addr = hash(key);
        for (int index = 0; index < count[addr]; index++) {
            if (memory[addr][index] == key) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param key 键值
     * @return 计算对应的hash值
     */
    private int hash(int key) {
        // 目前使用最简单的hash方法
        return key % hashNumber;
    }

    /**
     * @param array 原数组
     * @return 对数据进行扩展
     */
    private int[] expand(int[] array) {

        return Arrays.copyOf(array, array.length * 2);
    }

    private void remove(int addr, int index) {
        // 移除数组中的index元素
        if (index > 0) {
            for (int i = index + 1; i < count[addr] && i < memory[addr].length; i++) {
                memory[addr][i - 1] = memory[addr][i];
            }
        }
        count[addr]--;
    }

    public static void main(String[] args) {
        int[] array = {1, 2};
//        System.out.println(
//                Arrays.toString(Arrays.copyOf(array, array.length * 2)));

        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        obj.add(5);
        obj.add(6);
        obj.add(7);
        System.out.println(obj.contains(3));
        obj.remove(3);
        System.out.println(obj.contains(3));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */