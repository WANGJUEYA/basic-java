package com.jue.java.learntest.leetcode.solution0991;

class Solution {
    public static void main(String[] args) {
//        System.out.println((new Solution()).brokenCalc(3, 10));
//        System.out.println((new Solution()).brokenCalc(1, 1000000000));
        System.out.println((new Solution()).brokenCalc(1, 10));

    }

    /**
     * 为什么这道题采用逆向思维更优？ 正向思维：在X<Y时要实现操作数最小，
     * 要将X逼近Y的1/2值或1/4值或1/8值或...再进行*2操作，难点在于要判断要逼近的是1/2值还是1/4值还是其他值，逻辑复杂
     * 逆向思维：在Y>X时Y只管/2，到了Y<X时在+1逼近 说白了就是，正向思维采用的是先小跨度的-1操作，再大跨度的*2操作；
     * 逆向思维采用的是先大跨度的/2操作，再小跨度的-1操作 然而事实上往往是先大后小的解决问题思维在实现起来会比较简单
     */
    public int brokenCalc(int X, int Y) {
        int count = 0;
        while (X < Y) {
            count++;
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y++;
            }
        }
        return count + X - Y;
    }
}