package com.jue.java.design.principle.openclose;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote JavaCourse
 * note: 0 error(s),0 warning(s)
 */
public class JavaCourse implements ICourse {
    private Integer Id;
    private String name;
    private Double price;

    public JavaCourse() {
    }

    public JavaCourse(Integer id, String name, Double price) {
        Id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.Id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }


    @Override
    public String toString() {
        return "JavaCourse{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
