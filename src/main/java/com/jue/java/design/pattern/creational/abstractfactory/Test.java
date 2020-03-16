package com.jue.java.design.pattern.creational.abstractfactory;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote Test
 * note: 0 error(s),0 warning(s)
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        video.produce();
        article.produce();
    }
}
