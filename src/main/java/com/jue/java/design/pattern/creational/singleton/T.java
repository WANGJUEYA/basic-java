package com.jue.java.design.pattern.creational.singleton;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote T
 * note: 0 error(s),0 warning(s)
 */
public class T implements Runnable {
    @Override
    public void run() {
        //LazySingleton lazySingleton = LazySingleton.getInstance();
        LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " ==> " + instance);
    }
}
