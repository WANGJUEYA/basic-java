package com.jue.java.design.pattern.creational.builder;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote Test
 * note: 0 error(s),0 warning(s)
 */
public class Test {
    public static void main(String[] args) {
        CourseBuilder courseBuilder = new CourseActualBuilder();
        Coach coach = new Coach();
        coach.setCourseBuilder(courseBuilder);

        Course course = coach.makeCourse("name", "ppt", "video", "article", "qa");

    }
}
