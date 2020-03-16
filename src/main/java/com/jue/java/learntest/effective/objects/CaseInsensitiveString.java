package com.jue.java.learntest.effective.objects;

/**
 * @author JUE
 * @date 2019/4/4
 * @apiNote CaseInsensitiveString
 * note: 0 error(s),0 warning(s)
 */
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        //指出对象是否是特定类的一个实例
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        //One-way interoperability!
        if (o instanceof String) {
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }
}
