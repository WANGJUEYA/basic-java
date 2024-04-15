//不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
//
// 实现 MyHashMap 类：
//
//
// MyHashMap() 用空映射初始化对象
// void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，
//则更新其对应的值 value 。
// int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
// void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
//
//
//
//
// 示例：
//
//
//输入：
//["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
//[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
//输出：
//[null, null, null, 1, -1, null, 1, null, -1]
//
//解释：
//MyHashMap myHashMap = new MyHashMap();
//myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
//myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
//myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
//myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
//myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
//myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
//
//
//
//
// 提示：
//
//
// 0 <= key, value <= 10⁶
// 最多调用 10⁴ 次 put、get 和 remove 方法
//
//
// Related Topics 设计 数组 哈希表 链表 哈希函数 👍 405 👎 0


package com.jue.java.learn.leetcode.editor.cn.DesignHashmap;

/**
 * @author JUE
 * @number 706
 */
public class DesignHashmap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        System.out.println(myHashMap.get(2));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMap.get(2));    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class MyHashMap {

    /**
     * 采用链表存储移除的数据，不进行扩容; 使用一个大素数取余
     */
    private static final int CAPACITY = 2999;

    static class Item {
        Integer key;
        Integer value;

        public Item(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public static Integer hash(int key) {
            return key % CAPACITY;
        }
    }

    static class Node {
        public Node(Item value) {
            this.value = value;
        }

        Item value;
        Node next;
    }

    private Node[] store = new Node[CAPACITY];

    /**
     * 此时不应该摆出什么红黑树来处理整个Hash表的嘛，算了，我放弃了
     */
    public MyHashMap() {

    }

    public void put(int key, int value) {
        Node node = new Node(new Item(key, value));
        // 判断元素是否存在
        int hash = Item.hash(key);
        if (store[hash] == null) {
            store[hash] = node;
        } else {
            Node index = store[hash];
            while (index != null) {
                // 找到一个相同的key值更新
                if (index.value.key == key) {
                    index.value.value = value;
                    return;
                }
                if (index.next == null) {
                    index.next = node;
                }
                index = index.next;
            }
        }
    }

    public int get(int key) {
        // 判断元素是否存在
        int hash = Item.hash(key);
        if (store[hash] != null) {
            Node index = store[hash];
            while (index != null) {
                // 找到一个相同的key值更新
                if (index.value.key == key) {
                    return index.value.value;
                }
                index = index.next;
            }
        }
        return -1;
    }

    public void remove(int key) {
        // 判断元素是否存在
        int hash = Item.hash(key);
        if (store[hash] != null) {
            Node pre = null;
            Node index = store[hash];
            while (index != null) {
                // 找到一个相同的key值更新
                if (index.value.key == key) {
                    if (pre == null) {
                        store[hash] = index.next;
                    } else {
                        pre.next = index.next;
                    }
                }
                pre = index;
                index = index.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
