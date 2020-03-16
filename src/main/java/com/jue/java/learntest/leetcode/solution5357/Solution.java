package com.jue.java.learntest.leetcode.solution5357;

class CustomStack {

    int[] stack;
    int point;

    public CustomStack(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must more than zero!");
        }
        stack = new int[maxSize];
        point = -1;
    }

    public void push(int x) {
        if (point < stack.length - 1) {
            stack[++point] = x;
        }
    }

    public int pop() {
        if (point > -1) {
            return stack[point--];
        }
        return -1;
    }

    public void increment(int k, int val) {
        for (int index = 0; index <= point && index < k; index++) {
            stack[index] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // 栈是空的 []
        customStack.push(1);                         // 栈变为 [1]
        customStack.push(2);                         // 栈变为 [1, 2]
        System.out.println(customStack.pop());          // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        customStack.push(2);                         // 栈变为 [1, 2]
        customStack.push(3);                         // 栈变为 [1, 2, 3]
        customStack.push(4);                         // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        customStack.increment(5, 100);          // 栈变为 [101, 102, 103]
        customStack.increment(2, 100);          // 栈变为 [201, 202, 103]
        System.out.println(customStack.pop());          // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        System.out.println(customStack.pop());          // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        System.out.println(customStack.pop());          // 返回 201 --> 返回栈顶值 201，栈变为 []
        System.out.println(customStack.pop());          // 返回 -1 --> 栈为空，返回 -1
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */