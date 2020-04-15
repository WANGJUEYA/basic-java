package com.jue.java.learntest.offeronline.T_AL_2020_03_31;

import java.util.Stack;

/**
 * @author JUE
 * @date 2020/3/31
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    /**
     * 已知一个int数组A[] = {1,2,-2,-1,3,-3}，且数组元素中不包含0。假设正数表示“装货”，负数表示“卸货”，元素的绝对值表示商品的编号，
     * 例如1和-1分别表示对商品1进行装货和卸货，且数组中元素的
     * 顺序表示装卸货顺序。一条合理的装卸货顺序应该满足如下几个条件：
     * 条件1、有装必有卸，有卸不一定有装
     * 条件2、先装后卸 (ps: -> 此处考虑用栈)
     * 条件3、商品可以多次装卸，例如{-1，1，-1}
     * 请编程实现一个高效的方式来判断数组中元素序列的合理性？
     */
    boolean judgeLegalityOfSequence(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int a : A) {
            if (a > 0) {
                // 商品已经装入了
                if (stack.contains(a)) {
                    return false;
                }
                stack.add(a);
            } else {
                int id = -a;
                // 没有对应商品
                if (stack.isEmpty() || !stack.contains(id)) {
                    return false;
                }
                // 栈顶元素不等于
                if (id != stack.pop()) {
                    return false;
                }
            }
        }
        // 所有商品卸载完毕
        return stack.isEmpty();
    }
}

