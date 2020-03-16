package com.jue.java.design.pattern.creational.factorymethod;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote Test
 * note: 0 error(s),0 warning(s)
 */
public class Test {
    public static void main(String[] args) {

        //V1
//        VideoFactory videoFactory = new VideoFactory();
//        Video video = videoFactory.getVideo("java");
//        if (video == null) {
//            return;
//        }
//        video.produce();

        //V2使用反射的方法进行优化
//        VideoFactory videoFactory = new VideoFactory();
//        Video video = videoFactory.getVideo(JavaVideo.class);
//        if (video == null) {
//            return;
//        }
//        video.produce();

        //V3工厂方法：让实例创建推迟到子类中进行
//        VideoFactory videoFactory = new JavaVideoFactory();
        VideoFactory videoFactory = new PythonVideoFactory();
        videoFactory.getVideo().produce();
    }
}
