package com.jue.java.design.principle.demeter;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote Boss
 * note: 0 error(s),0 warning(s)
 */
public class Boss {
    public void commandCheckNumber(TeamLeader teamLeader){
//        List<Course> courseList = new ArrayList<>();
//        for (int i=0;i<20;i++){
//            courseList.add(new Course());
//        }
        teamLeader.checkNumberofCourse();
    }
}
