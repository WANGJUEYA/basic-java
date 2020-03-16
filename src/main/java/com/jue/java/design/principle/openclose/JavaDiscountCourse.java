package com.jue.java.design.principle.openclose;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote JavaDiscountCourse
 * note: 0 error(s),0 warning(s)
 */
public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getOriginPrice() {
        return super.getPrice();
    }

    @Override
    public Double getPrice() {
        return super.getPrice() * 0.8;
    }
}
