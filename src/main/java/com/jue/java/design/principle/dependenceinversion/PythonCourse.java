package com.jue.java.design.principle.dependenceinversion;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote PythonCourse
 * note: 0 error(s),0 warning(s)
 */
public class PythonCourse implements ICourse {

    @Override
    public void studyCourse() {
        System.out.println("PythonCourse");
    }
}
