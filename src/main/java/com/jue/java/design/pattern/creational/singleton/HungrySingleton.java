package com.jue.java.design.pattern.creational.singleton;

import java.io.Serializable;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote HungrySingleton
 * note: 0 error(s),0 warning(s)
 */
public class HungrySingleton implements Serializable {
    private final static HungrySingleton hungrySingleton = new HungrySingleton();

//    static {
//        hungrySingleton = new HungrySingleton();
//    }
    private HungrySingleton() {
        if(hungrySingleton != null){
            //单例(懒汉式)是在类加载时进行初始化
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    //防止序列化与反序列化导致的实体不一致
    private Object readResolve(){
        return hungrySingleton;
    }
}
