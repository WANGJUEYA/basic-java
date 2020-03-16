package com.jue.java.design.pattern.creational.abstractfactory;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote JavaCourseFactory
 * note: 0 error(s),0 warning(s)
 */
public class PythonCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
