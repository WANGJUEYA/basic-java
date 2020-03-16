package com.jue.java.tips;

import java.text.MessageFormat;

/**
 * @author jue
 * @date 2019/11/26
 * note no error(0) no warning(0)
 **/
public class DemoString {
    public static void main(String[] args) {
        System.out.println(strFormat("你好{1}!,{0}", 1, 2));
    }

    public static String strFormat(String pattern, Object... arguments) {
        return MessageFormat.format(pattern, arguments);
    }
}
