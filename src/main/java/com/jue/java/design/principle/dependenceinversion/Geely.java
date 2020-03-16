package com.jue.java.design.principle.dependenceinversion;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote 此类需要实时更新, 应用随实现细节变化
 * note: 0 error(s),0 warning(s)
 */
public class Geely {
    //构造器的方式注入
    private ICourse iCourse;

    public Geely() {
    }

    //V4 构造器注入
    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    //V3 构造器注入 - 只有构造时能够注入 -单例模式/dao-service
    public Geely(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void studyImoocCourse() {
        iCourse.studyCourse();
    }

    //V2 参数注入
//    public void studyImoocCourse(ICourse iCourse){
//        iCourse.studyCourse();
//    }


    //V1 依赖底层细节
//    public void studyJavaCourse(){
//        System.out.println("JavaCourse");
//    }
//
//    public void studyFECourse(){
//        System.out.println("FECourse");
//    }
//
//    public void studyPythonCourse(){
//        System.out.println("PythonCourse");
//    }
}
