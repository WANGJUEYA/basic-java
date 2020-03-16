package com.jue.java.design.principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote TeamLeader
 * note: 0 error(s),0 warning(s)
 */
public class TeamLeader {
    public void checkNumberofCourse() {
        List<Course> courses = new ArrayList<>();
        for (int i=0;i<20;i++){
            courses.add(new Course());
        }
        System.out.println("数量" + courses.size());
    }
}
