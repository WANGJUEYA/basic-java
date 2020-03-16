package com.jue.java.design.pattern.creational.singleton;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote StaticInnerClassSingleton
 * note: 0 error(s),0 warning(s)
 */
public class StaticInnerClassSingleton {
    //解决原理：基于类初始化的延迟加载解决方案
    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }
}
