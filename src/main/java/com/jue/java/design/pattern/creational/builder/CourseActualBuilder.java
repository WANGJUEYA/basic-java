package com.jue.java.design.pattern.creational.builder;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote CourseActualBuilder
 * note: 0 error(s),0 warning(s)
 */
public class CourseActualBuilder extends CourseBuilder {

    private Course course = new Course();

    @Override
    public void builderCourseName(String courseName) {
        this.course.setCourseName(courseName);
    }

    @Override
    public void builderCoursePPT(String coursePPT) {
        this.course.setCoursePPT(coursePPT);
    }

    @Override
    public void builderCourseVideo(String courseVideo) {
        this.course.setCourseVideo(courseVideo);
    }

    @Override
    public void builderCourseArticle(String courseArticle) {
        this.course.setCourseArticle(courseArticle);
    }

    @Override
    public void builderCourseQA(String courseQA) {
        this.course.setCourseQA(courseQA);
    }

    @Override
    public Course makeCourse() {
        return this.course;
    }
}
