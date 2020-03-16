package com.jue.java.design.pattern.creational.singleton;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote LazySingleton
 * note: 0 error(s),0 warning(s)
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;
//    private static boolean flag = true;

    private LazySingleton() {
//        if (flag) {
//            flag = false;
//        } else {
//            //单例(懒汉式)是在类加载时进行初始化
//            throw new RuntimeException("单例构造器禁止反射调用");
//        }
        if (lazySingleton != null) {
            //单例(懒汉式)是在类加载时进行初始化
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public synchronized static LazySingleton getInstance() {
        //public static LazySingleton getInstance(){
        //该方法为线程不安全的
        if (lazySingleton == null) {
            //懒汉式加载(延时加载)，但需要对象时才能创建对象

            //解决方案1(悲观锁) 增加大量性能消耗
            //在静态方法中增加关健字同步整个类
            //synchronized (LazySingleton.class){ }
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
