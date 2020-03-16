package com.jue.java.design.pattern.creational.singleton;

/**
 * @author JUE
 * @date 2019/6/14
 * @apiNote EnumInstance
 * note: 0 error(s),0 warning(s)
 */
public enum EnumInstance {
    //枚举实例
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }
}
