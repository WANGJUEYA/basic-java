package com.jue.java.learn.tooffer.solution01;

import java.util.Stack;

/**
 * @author JUE
 * @date 2019/6/18
 * @apiNote Solution
 * note: 0 error(s),0 warning(s)
 */
public class Solution {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        int minInt = min.empty() || node < min.peek() ? node : min.peek();
        min.push(minInt);
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
