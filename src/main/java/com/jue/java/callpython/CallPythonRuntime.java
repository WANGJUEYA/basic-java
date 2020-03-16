package com.jue.java.callpython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author jue
 * @date 2019/12/4
 * note no error(0) no warning(0)
 * 注意: jython 很多第三方库找不到, 有部分问题
 **/
public class CallPythonRuntime {

    private static final String EXEC_FILE = "D:/coding_mine/basic_java/src/main/java/com/jue/java/callpython/CallPythonRuntime.py";

    public String adder(int a, int b) {
        StringBuilder result = new StringBuilder();
        try {
            String[] args = new String[]{"python", EXEC_FILE, String.valueOf(a), String.valueOf(b)};
            // 执行py文件
            Process proc = Runtime.getRuntime().exec(args);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.print((new CallPythonRuntime()).adder(2, 4));
    }

}

