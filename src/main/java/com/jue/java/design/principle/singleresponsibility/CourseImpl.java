package com.jue.java.design.principle.singleresponsibility;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote CourseImpl
 * note: 0 error(s),0 warning(s)
 */
public class CourseImpl implements ICourseContent,ICourseManager{

    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public byte[] getCourseVideo() {
        return new byte[0];
    }

    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }
}
