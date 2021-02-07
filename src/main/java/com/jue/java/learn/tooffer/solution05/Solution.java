package com.jue.java.learn.tooffer.solution05;

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> push = new Stack<>();
        for (int x = 0, y = 0; y < popA.length; ) {
            if (!push.empty() && push.peek().equals(popA[y])) {
                push.pop();
                y++;
            } else if (x < pushA.length) {
                push.push(pushA[x]);
                x++;
            } else {
                return false;
            }
//            System.out.println(push);
        }
        return true;
    }
}