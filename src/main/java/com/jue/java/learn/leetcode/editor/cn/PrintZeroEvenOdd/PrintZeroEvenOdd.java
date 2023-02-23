//现有函数 printNumber 可以用一个整数参数调用，并输出该整数到控制台。 
//
// 
// 例如，调用 printNumber(7) 将会输出 7 到控制台。 
// 
//
// 给你类 ZeroEvenOdd 的一个实例，该类中有三个函数：zero、even 和 odd 。ZeroEvenOdd 的相同实例将会传递给三个不同线程：
// 
//
// 
// 线程 A：调用 zero() ，只输出 0 
// 线程 B：调用 even() ，只输出偶数 
// 线程 C：调用 odd() ，只输出奇数 
// 
//
// 修改给出的类，以输出序列 "010203040506..." ，其中序列的长度必须为 2n 。 
//
// 实现 ZeroEvenOdd 类： 
//
// 
// ZeroEvenOdd(int n) 用数字 n 初始化对象，表示需要输出的数。 
// void zero(printNumber) 调用 printNumber 以输出一个 0 。 
// void even(printNumber) 调用printNumber 以输出偶数。 
// void odd(printNumber) 调用 printNumber 以输出奇数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出："0102"
//解释：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出："0102030405"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics 多线程 👍 139 👎 0


package com.jue.java.learn.leetcode.editor.cn.PrintZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author JUE
 * @number 1116
 */
public class PrintZeroEvenOdd {
    public static void main(String[] args) {
        ZeroEvenOdd test = new ZeroEvenOdd(2);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class ZeroEvenOdd {
    private int n;

    // 信号量
    Semaphore zero;
    Semaphore even; // 偶数
    Semaphore odd; // 奇数

    public ZeroEvenOdd(int n) {
        this.n = n;
        zero = new Semaphore(1);
        odd = new Semaphore(0);
        even = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        // 只有循环才会一直打印
        for (int index = 1; index <= n; index++) {
            zero.acquire();
            // 在while中加1会导致计数不准确
            printNumber.accept(0);
            if (index % 2 == 1) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        // 只有循环才会一直打印
        for (int index = 2; index <= n; index += 2) {
            even.acquire();
            printNumber.accept(index);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        // 只有循环才会一直打印
        for (int index = 1; index <= n; index += 2) {
            odd.acquire();
            printNumber.accept(index);
            zero.release();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
