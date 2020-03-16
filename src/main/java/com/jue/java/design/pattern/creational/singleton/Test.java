package com.jue.java.design.pattern.creational.singleton;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote Test
 * note: 0 error(s),0 warning(s)
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //懒汉式利用延迟加载,只有使用时才进行初始化

        //V1单线程加载
//        LazySingleton lazySingleton = LazySingleton.getInstance();

        //V2多线程加载
//        Thread t1 = new Thread(new T());
//        Thread t2 = new Thread(new T());
//        t1.start();
//        t2.start();
//        System.out.println("end");

        //序列化和反序列化破坏单例模式(实现序列化接口?)
//        HungrySingleton instance = HungrySingleton.getInstance();
//        //存储到文件中，再从文件中取出来，两个对象还是同一个对象嘛?
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        oos.writeObject(instance);
//        File file = new File("singleton_file");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton_file"));
//
//        HungrySingleton newInstance = (HungrySingleton) ois.readObject();
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);

        //防止反射攻击(打开私有构造器权限)
//        Class objectClass = HungrySingleton.class;
//        //Class.forName(HungrySingleton.class.getName());
//        Constructor constructor = objectClass.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        HungrySingleton instance = HungrySingleton.getInstance();
//        HungrySingleton newInstance = (HungrySingleton) constructor.newInstance();
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);

//        Class objectClass = LazySingleton.class;
//        //Class.forName(LazySingleton.class.getName());
//        Constructor constructor = objectClass.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        LazySingleton instance = LazySingleton.getInstance();
//        LazySingleton newInstance = (LazySingleton) constructor.newInstance();
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);


//        Class objectClass = LazySingleton.class;
//        Constructor constructor = objectClass.getDeclaredConstructor();
//        constructor.setAccessible(true);

        //反射能够修复私有字段！
//        LazySingleton instance = LazySingleton.getInstance();
//        Field flag = instance.getClass().getDeclaredField("flag");
//        flag.setAccessible(true);
//        flag.set(instance,true);
//        LazySingleton newInstance = (LazySingleton) constructor.newInstance();
//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);
    }
}
