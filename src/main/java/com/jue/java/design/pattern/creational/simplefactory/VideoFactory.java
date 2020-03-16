package com.jue.java.design.pattern.creational.simplefactory;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote VideoFactory
 * note: 0 error(s),0 warning(s)
 */
public class VideoFactory {
    //通过反射弥补不断扩展的问题
    public Video getVideo(Class c) {
        Video video = null;
        try {
            video = (Video) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }

    public Video getVideo(String type) {
        //类会不断修改带来风险
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        } else if ("python".equalsIgnoreCase(type)) {
            return new PythonVideo();
        } else {
            return null;
        }
    }
}
