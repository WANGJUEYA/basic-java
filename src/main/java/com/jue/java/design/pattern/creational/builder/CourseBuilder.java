package com.jue.java.design.pattern.creational.builder;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote CourseBuilder
 * note: 0 error(s),0 warning(s)
 */
public abstract class CourseBuilder {

    public abstract void builderCourseName(String courseName);

    public abstract void builderCoursePPT(String coursePPT);

    public abstract void builderCourseVideo(String courseVideo);

    public abstract void builderCourseArticle(String courseArticle);

    public abstract void builderCourseQA(String courseQA);

    public abstract Course makeCourse();
}