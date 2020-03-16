package com.jue.java.design.principle.singleresponsibility;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote FlyBird
 * note: 0 error(s),0 warning(s)
 */
public class FlyBird {
    public void mainMoveMode(String birdName){
        //不同的方法调用需要不同的方式
        System.out.println(birdName+"用翅膀飞");
    }
}
