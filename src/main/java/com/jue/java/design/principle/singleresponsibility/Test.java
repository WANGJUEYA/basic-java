package com.jue.java.design.principle.singleresponsibility;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote Test
 * note: 0 error(s),0 warning(s)
 */
public class Test {

    public static void main(String[] args) {
//        Bird bird = new Bird();
//        bird.mainMoveMode("大雁");
//        bird.mainMoveMode("鸵鸟");

        FlyBird flyBird = new FlyBird();
        flyBird.mainMoveMode("大雁");

        WalkBird walkBird = new WalkBird();
        walkBird.mainMoveMode("鸵鸟");
    }
}
