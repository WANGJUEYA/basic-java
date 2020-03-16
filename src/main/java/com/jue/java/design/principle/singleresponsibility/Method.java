package com.jue.java.design.principle.singleresponsibility;

/**
 * @author JUE
 * @date 2019/6/6
 * @apiNote Method
 * note: 0 error(s),0 warning(s)
 */
public class Method {
    private void updateUserInfo(String useName,String address){
        System.out.println(useName+address);
    }

    private void updateUserInfo(String useName,String... properties){
        System.out.println(useName+properties);
    }

    //把上面info拆开使每个方法的指责单一
    private void  updateUserInfo(Boolean bool){
        //建议拆开？结合实际开发
        if(bool){
            //toDoSomething1
        }else {
            //toDoSomething2
        }
    }
}
