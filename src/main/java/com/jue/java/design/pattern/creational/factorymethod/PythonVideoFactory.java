package com.jue.java.design.pattern.creational.factorymethod;

/**
 * @author JUE
 * @date 2019/6/10
 * @apiNote PythonVideoFactory
 * note: 0 error(s),0 warning(s)
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
