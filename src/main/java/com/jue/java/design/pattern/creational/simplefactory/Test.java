package com.jue.java.design.pattern.creational.simplefactory;

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

        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        if (video == null) {
            return;
        }
        video.produce();
    }
}
