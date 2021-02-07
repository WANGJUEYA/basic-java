package com.jue.java.learn.tooffer.bean;

import java.util.*;

/**
 * @author JUE
 * @date 2020/8/12
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static Node newInstance(int[][] list) {
        Map<Integer, Node> cache = new HashMap<>(16);
        int len = list.length;
        for (int index = 1; index <= len; index++) {
            int[] node = list[index - 1];
            if (!cache.containsKey(index)) {
                cache.put(index, new Node(index));
            }
            for (int i : node) {
                if (!cache.containsKey(i)) {
                    cache.put(i, new Node(i));
                }
                cache.get(index).neighbors.add(cache.get(i));
            }
        }
        return cache.get(1);
    }

    @Override
    public String toString() {

        Map<Integer, Node> nodes = new HashMap<>(16);

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(this);

        while (!nodeStack.empty()) {
            Node temp = nodeStack.pop();
            if (!nodes.containsKey(temp.val)) {
                nodes.put(temp.val, temp);
            }
            for (Node node : temp.neighbors) {
                if (!nodes.containsKey(node.val)) {
                    nodeStack.push(node);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        int len = nodes.size();
        for (int index = 1; index <= len; index++) {
            List<Integer> array = new ArrayList<>();
            for (Node node : nodes.get(index).neighbors) {
                array.add(node.val);
            }
            result.add(array);
        }

        return result.toString();
    }
}
