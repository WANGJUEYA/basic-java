package com.jue.java.design.pattern.creational.singleton;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote LazyDoubleCheckSingleton
 * note: 0 error(s),0 warning(s)
 */
public class LazyDoubleCheckSingleton {
    //(不允许2&3重排序)volatile 将当前处理器写回内存，其他无效(缓存一致性)
    //(不需要其他线程看到重排序)
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton() {

    }

    //    public synchronized static LazyDoubleCheckSingleton getInstance(){
    public static LazyDoubleCheckSingleton getInstance() {
        if (lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (lazyDoubleCheckSingleton == null) {
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                    //1.分配内存给对象
                    //2.初始化对象
                    //3.设置layDoubleCheckSingleton 指向分配对象
                    //注:2&3会发生重排序
                    // intra-thread semantics 允许单线程不改变结果重排序
                    //解决1
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
