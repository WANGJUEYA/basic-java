package com.jue.java.learn.effective.genericity;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author JUE
 * Description: Stack
 * Date: 2019/4/3
 * note: 0 error(s),0 warning(s)
 */
public class CustomStack<T> {
    private T[] elements;
    //栈指针
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public CustomStack() {
        //如何新建泛型对象
        //1、创建Object对象并强制泛型转换(warning unchecked)
        //elements = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
        //2、创建Object对象在pop()转换泛型
        elements = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(T e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        //先返回栈顶元素,再将指针下移
        T result = elements[--size];
        //Eliminate obsolete reference
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
