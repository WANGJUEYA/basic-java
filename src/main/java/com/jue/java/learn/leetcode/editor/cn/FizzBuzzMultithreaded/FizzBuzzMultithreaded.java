//编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是： 
//
// 
// 如果这个数字可以被 3 整除，输出 "fizz"。 
// 如果这个数字可以被 5 整除，输出 "buzz"。 
// 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。 
// 
//
// 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14
//, fizzbuzz。 
//
// 假设有这么一个类： 
//
// 
//class FizzBuzz {
//  public FizzBuzz(int n) { ... }               // constructor
//  public void fizz(printFizz) { ... }          // only output "fizz"
//  public void buzz(printBuzz) { ... }          // only output "buzz"
//  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
//  public void number(printNumber) { ... }      // only output the numbers
//} 
//
// 请你实现一个有四个线程的多线程版 FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用： 
//
// 
// 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。 
// 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。 
// 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。 
// 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。 
// 
//
// 
//
// 提示： 
//
// 
// 本题已经提供了打印字符串的相关方法，如 printFizz() 等，具体方法名请参考答题模板中的注释部分。 
// 
//
// 
//
// Related Topics 多线程 👍 85 👎 0


package com.jue.java.learn.leetcode.editor.cn.FizzBuzzMultithreaded;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author JUE
 * @number 1195
 */
public class FizzBuzzMultithreaded {
}

//leetcode submit region begin(Prohibit modification and deletion)
class FizzBuzz {
    private int n;
    Semaphore fizz;
    Semaphore buzz;
    Semaphore fizzbuzz;
    Semaphore number;
    AtomicInteger index;

    public FizzBuzz(int n) {
        this.n = n;
        fizz = new Semaphore(0);
        buzz = new Semaphore(0);
        fizzbuzz = new Semaphore(0);
        number = new Semaphore(1);
        index = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        int count = 0;
        int total = n / 3 - n / 15;
        while (count < total) {
            fizz.acquire();
            printFizz.run();
            count++;
            number.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int count = 0;
        int total = n / 5 - n / 15;
        while (count < total) {
            buzz.acquire();
            printBuzz.run();
            count++;
            number.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int count = 0;
        int total = n / 15;
        while (count < total) {
            // 打印足够数量应当退出, 不然会死循环
            fizzbuzz.acquire();
            printFizzBuzz.run();
            count++;
            number.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (index.get() <= n) {
            if (index.get() % 15 == 0) {
                fizzbuzz.release();
            } else if (index.get() % 5 == 0) {
                buzz.release();
            } else if (index.get() % 3 == 0) {
                fizz.release();
            } else {
                printNumber.accept(index.get());
                number.release();
            }
            // number.acquire();
            index.addAndGet(1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
