package com.jue.java.learn.tooffer.bean;

/**
 * @author JUE
 * @date 2019/6/19
 * @apiNote RandomListNode
 * note: 0 error(s),0 warning(s)
 */
public class RandomListNode {
    public int label;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return String.format("%s(%s->%s) -> %s%n",
                this.label,
                this.hashCode(),
                (null == random) ? "null" : random.hashCode(),
                this.next);
    }
}
