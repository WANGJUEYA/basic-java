//给你一个类： 
//
// 
//class FooBar {
//  public void foo() {
//    for (int i = 0; i < n; i++) {
//      print("foo");
//    }
//  }
//
//  public void bar() {
//    for (int i = 0; i < n; i++) {
//      print("bar");
//    }
//  }
//}
// 
//
// 两个不同的线程将会共用一个 FooBar 实例： 
//
// 
// 线程 A 将会调用 foo() 方法，而 
// 线程 B 将会调用 bar() 方法 
// 
//
// 请设计修改程序，以确保 "foobar" 被输出 n 次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出："foobar"
//解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出："foobarfoobar"
//解释："foobar" 将被输出两次。
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
// Related Topics 多线程 👍 176 👎 0


package com.jue.java.learn.leetcode.editor.cn.PrintFoobarAlternately;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author JUE
 * @number 1115
 */
public class PrintFoobarAlternately {
}

//leetcode submit region begin(Prohibit modification and deletion)
class FooBar {
    private int n;
    Semaphore foo;
    Semaphore bar;

    public FooBar(int n) {
        this.n = n;
        foo = new Semaphore(1);
        bar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.acquire(); //值为1的时候，能拿到，执行下面的操作
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release(); //释放许可给barSema这个信号量 barSema 的值+1
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            bar.acquire(); //值为1的时候，能拿到，执行下面的操作
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release(); //释放许可给fooSema这个信号量 fooSema 的值+1
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
class FooBar_CountDownLatch {
    // CountDownLatch 获取到资源就执行, 导致第一个线程可能会提前打印很多次
    private int n;
    CountDownLatch foo;
    CountDownLatch bar;

    public FooBar_CountDownLatch(int n) {
        this.n = n;
        foo = new CountDownLatch(n);
        bar = new CountDownLatch(n - 1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            // 通知bar可以运行了
            bar.countDown();
            // 等待被通知
            foo.await();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // 等待被通知
            bar.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            // 通知foo可以运行了
            foo.countDown();
        }
    }
}
