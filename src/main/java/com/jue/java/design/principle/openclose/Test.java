package com.jue.java.design.principle.openclose;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote Test
 * note: 0 error(s),0 warning(s)
 */
public class Test {
    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(96, "设计模式", 348D);
        JavaDiscountCourse javaCourse = (JavaDiscountCourse) iCourse;
        javaCourse.getOriginPrice();
        System.out.println(javaCourse.getId() + " - "
                + javaCourse.getName() + " - "
                + javaCourse.getPrice() + " - "
        );
    }
}
