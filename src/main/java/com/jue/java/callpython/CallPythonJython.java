package com.jue.java.callpython;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.util.Properties;

/**
 * @author jue
 * @date 2019/12/4
 * note no error(0) no warning(0)
 * 注意: jython 很多第三方库找不到, 有部分问题
 **/
public class CallPythonJython {

    private static final String PYTHON_HOME = "D:/software/Python/Python37/Lib";
    private static final String EXEC_FILE = "D:/coding_mine/basic_java/src/main/java/com/jue/java/callpython/CallPythonJython.py";

    public PythonInterpreter getInterpreter(String pythonHome) {
        Properties props = new Properties();
        props.put("python.home", pythonHome);
        // Used to prevent: console: Failed to install '': java.nio.charset.UnsupportedCharsetException: cp0.
        props.put("python.console.encoding", "UTF-8");
        //don't respect java accessibility, so that we can access protected members on subclasses
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);

        return new PythonInterpreter();
    }

    public Integer adder(int a, int b) {
        PythonInterpreter interpreter = getInterpreter(PYTHON_HOME);
        interpreter.execfile(EXEC_FILE);

        PyFunction adder = (PyFunction) interpreter.get("adder", PyFunction.class);
        // int a = 30, b = 50;
        PyObject pyobj = adder.__call__(new PyInteger(a), new PyInteger(b));
        System.out.println("anwser = " + pyobj.toString());

        return Integer.parseInt(pyobj.toString());
    }

    public static void main(String[] args) {
        System.out.print((new CallPythonJython()).adder(1, 3));
    }

}

