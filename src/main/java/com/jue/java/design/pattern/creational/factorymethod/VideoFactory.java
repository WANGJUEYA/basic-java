package com.jue.java.design.pattern.creational.factorymethod;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote VideoFactory
 * note: 0 error(s),0 warning(s)
 */
public abstract class VideoFactory {
    //将创建对象延迟到子类进行
    public abstract Video getVideo();
//    //通过反射弥补不断扩展的问题
//    public Video getVideo(Class c) {
//        Video video = null;
//        try {
//            video = (Video) Class.forName(c.getName()).newInstance();
//        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return video;
//    }
//
//    public Video getVideo(String type) {
//        //类会不断修改带来风险
//        if ("java".equalsIgnoreCase(type)) {
//            return new JavaVideo();
//        } else if ("python".equalsIgnoreCase(type)) {
//            return new PythonVideo();
//        } else {
//            return null;
//        }
//    }
}
