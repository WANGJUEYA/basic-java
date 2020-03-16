package com.jue.java.design.principle.dependenceinversion;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote Test
 * note: 0 error(s),0 warning(s)
 */
public class Test {

    //V4构造器注入
    public static void main(String[] args) {
        Geely geely = new Geely();
        geely.setiCourse(new JavaCourse());
        geely.studyImoocCourse();

        geely.setiCourse(new PythonCourse());
        geely.studyImoocCourse();
    }

    //V3构造器注入
//    public static void main(String[] args) {
//        Geely geely = new Geely(new JavaCourse());
//        geely.studyImoocCourse();
//    }

    //v2 接口方法注入
//    public static void main(String[] args) {
//        Geely geely = new Geely();
//        geely.studyImoocCourse(new JavaCourse());
//        geely.studyImoocCourse(new PythonCourse());
//        geely.studyImoocCourse(new FECourse());
//    }


    //V1
/*    public static void main(String[] args) {
        Geely geely = new Geely();
        geely.studyJavaCourse();
        geely.studyFECourse();
    }*/
}
