package com.jue.java.design.pattern.creational.builder.v2;

import java.util.Set;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote Test
 * note: 0 error(s),0 warning(s)
 */
public class Test {


    public static void main(String[] args) {
        Course course = new Course(
                new Course.CourseBuilder()
                        .builderCourseName("name")
                        .builderCoursePPT("ppt")
                        .builderCourseVideo("video")
                        .builderCourseArticle("article")
                        .builderCourseQA("qa"));
        System.out.println(course);
    }
}

