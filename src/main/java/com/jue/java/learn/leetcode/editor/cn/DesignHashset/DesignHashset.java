//不使用任何内建的哈希表库设计一个哈希集合（HashSet）。 
//
// 实现 MyHashSet 类： 
//
// 
// void add(key) 向哈希集合中插入值 key 。 
// bool contains(key) 返回哈希集合中是否存在这个值 key 。 
// void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。 
// 
//
// 示例： 
//
// 
//输入：
//["MyHashSet", "add", "add", "contains", "contains", "add", "contains", 
//"remove", "contains"]
//[[], [1], [2], [1], [3], [2], [2], [2], [2]]
//输出：
//[null, null, null, true, false, null, true, null, false]
//
//解释：
//MyHashSet myHashSet = new MyHashSet();
//myHashSet.add(1);      // set = [1]
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(1); // 返回 True
//myHashSet.contains(3); // 返回 False ，（未找到）
//myHashSet.add(2);      // set = [1, 2]
//myHashSet.contains(2); // 返回 True
//myHashSet.remove(2);   // set = [1]
//myHashSet.contains(2); // 返回 False ，（已移除） 
//
// 
//
// 提示： 
//
// 
// 0 <= key <= 10⁶ 
// 最多调用 10⁴ 次 add、remove 和 contains 
// 
//
// Related Topics 设计 数组 哈希表 链表 哈希函数 👍 279 👎 0


package com.jue.java.learn.leetcode.editor.cn.DesignHashset;

public class DesignHashset {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(3));
        System.out.println(myHashSet.contains(2));
    }
}

/**
 * @author JUE
 * @number 705
 */
//leetcode submit region begin(Prohibit modification and deletion)
class MyHashSet {
    // 取模也是官方建议 不过建议取一个素数
    private static final int CAPACITY = 3000;

    /**
     * 链表存储常用的节点
     */
    static class Node {
        public Node(int val) {
            this.val = val;
        }

        private final int val;
        private Node next;
    }

    // 哈希 1. 哈希算法 2. 哈希扩容(不扩容, 用链表)
    private int hash(int key) {
        // 这里就简单的模3000
        return key % CAPACITY;
    }


    // 共 10^5, 调用 10^4; 我们为了不扩容 长度暂存3000
    private final Node[] storage;

    public MyHashSet() {
        storage = new Node[CAPACITY];
    }

    public void add(int key) {
        // 重复值处理
        if (contains(key)) {
            return;
        }
        int index = hash(key);
        Node current = new Node(key);
        if (storage[index] == null) {
            storage[index] = current;
        } else {
            Node last = storage[index];
            while (last.next != null) {
                last = last.next;
            }
            last.next = current;
        }
    }

    public void remove(int key) {
        int index = hash(key);
        if (storage[index] == null) {
            return;
        }
        if (storage[index].val == key) {
            storage[index] = storage[index].next;
            return;
        }
        Node head = storage[index], pre = storage[index].next;
        while (pre != null) {
            if (pre.val == key) {
                head.next = pre.next;
                return;
            }
            head = head.next;
            pre = pre.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        if (storage[index] == null) {
            return false;
        }
        Node node = storage[index];
        while (node != null) {
            if (node.val == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)
