package com.jue.java.learn.tooffer.solution40;

import java.util.Stack;

class Solution {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int result = 0;

        change(stack1, stack2);
        result = stack2.pop();
        change(stack2, stack1);

        return result;
    }

    private static void change(Stack<Integer> stacka, Stack<Integer> stackb) {
        while (!stacka.empty()) {
            stackb.push(stacka.pop());
        }
    }
}