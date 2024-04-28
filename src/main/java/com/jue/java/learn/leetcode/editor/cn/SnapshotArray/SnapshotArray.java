//实现支持下列接口的「快照数组」- SnapshotArray：
//
//
// SnapshotArray(int length) - 初始化一个与指定长度相等的 类数组 的数据结构。初始时，每个元素都等于 0。
// void set(index, val) - 会将指定索引 index 处的元素设置为 val。
// int snap() - 获取该数组的快照，并返回快照的编号 snap_id（快照号是调用 snap() 的总次数减去 1）。
// int get(index, snap_id) - 根据指定的 snap_id 选择快照，并返回该快照指定索引 index 的值。
//
//
//
//
// 示例：
//
// 输入：["SnapshotArray","set","snap","set","get"]
//     [[3],[0,5],[],[0,6],[0,0]]
//输出：[null,null,0,null,5]
//解释：
//SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
//snapshotArr.set(0,5);  // 令 array[0] = 5
//snapshotArr.snap();  // 获取快照，返回 snap_id = 0
//snapshotArr.set(0,6);
//snapshotArr.get(0,0);  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5
//
//
//
// 提示：
//
//
// 1 <= length <= 50000
// 题目最多进行50000 次set，snap，和 get的调用 。
// 0 <= index < length
// 0 <= snap_id < 我们调用 snap() 的总次数
// 0 <= val <= 10^9
//
//
// Related Topics 设计 数组 哈希表 二分查找 👍 151 👎 0


package com.jue.java.learn.leetcode.editor.cn.SnapshotArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @number 1146
 */
class SnapshotArrayTest {
    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(3); // 初始化一个长度为 3 的快照数组
        snapshotArr.set(0, 5);  // 令 array[0] = 5
        snapshotArr.snap();  // 获取快照，返回 snap_id = 0
        snapshotArr.set(0, 6);
        System.out.println(snapshotArr.get(0, 0));  // 获取 snap_id = 0 的快照中 array[0] 的值，返回 5

        snapshotArr = new SnapshotArray(1); // 初始化一个长度为 3 的快照数组
        snapshotArr.set(0, 4);
        snapshotArr.set(0, 16);
        snapshotArr.set(0, 13);
        snapshotArr.snap();  // 获取快照，返回 snap_id = 0
        snapshotArr.set(0, 0);
        System.out.println(snapshotArr.get(0, 0));  // 13

        snapshotArr = new SnapshotArray(2); // 初始化一个长度为 3 的快照数组
        snapshotArr.snap();
        snapshotArr.get(1, 0);
        snapshotArr.get(0, 0);
        snapshotArr.set(1, 8);
        System.out.println(snapshotArr.get(1, 0));  // 0
        snapshotArr.set(0, 20);
        System.out.println(snapshotArr.get(0, 0));  // 0
        snapshotArr.set(0, 7);

    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class SnapshotArray {

    /**
     * 记录每个节点的变化; List<int[]> = [snapshot, value];
     * 再通过二分算法计算正确的索引
     */
    List<int[]>[] store;
    Integer snapshot;

    public SnapshotArray(int length) {
        store = new List[length];
        snapshot = 0;
    }

    public void set(int index, int val) {
        // System.out.println("set > " + index + "," + val);
        if (store[index] == null) {
            store[index] = new ArrayList<>();
        }
        // 取最后一次覆盖
        List<int[]> temp = store[index];
        if (temp.size() > 0 && temp.get(temp.size() - 1)[0] == snapshot) {
            temp.remove(temp.size() - 1);
        }
        store[index].add(new int[]{snapshot, val});
    }

    public int snap() {
        // System.out.println("snap");
        return snapshot++;
    }

    public int get(int index, int snap_id) {
        // System.out.println("get > " + index + "," + snap_id);
        // 二分查法; 查找小于等于snap_id的第一个值
        List<int[]> temp = store[index];
        if (temp == null) {
            return 0;
        }
        int low = 0, high = temp.size() - 1;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            int count = temp.get(mid)[0];
            if (count == snap_id) {
                return temp.get(mid)[1];
            } else if (count < snap_id) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low < temp.size() && temp.get(low)[0] <= snap_id ? temp.get(low)[1] : 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
//leetcode submit region end(Prohibit modification and deletion)
