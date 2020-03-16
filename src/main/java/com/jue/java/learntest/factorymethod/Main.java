package com.jue.java.learntest.factorymethod;

/**
 * Created by JUE
 * Date: 2019/2/19
 * note: 0 error(s),0 warning(s)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(OperationFactory.CreateOperation("+").work(1, 2));
        System.out.println(OperationFactory.CreateOperation("-").work(1, 2));
        System.out.println(OperationFactory.CreateOperation("*").work(1, 2));
        System.out.println(OperationFactory.CreateOperation("/").work(1, 2));
    }
}
