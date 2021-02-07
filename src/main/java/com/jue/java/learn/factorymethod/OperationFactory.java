package com.jue.java.learn.factorymethod;

/**
 * Created by JUE
 * Date: 2019/2/19
 * note: 0 error(s),0 warning(s)
 */
public class OperationFactory {
    public static Operation CreateOperation(String operate) {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            default:
                break;

        }
        return operation;
    }
}
