package com.jue.java.learntest.leetcode.solution1418;

import java.util.*;

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<Integer> tables = new TreeSet<>();
        Set<String> foods = new TreeSet<>();
        Map<String, Map<String, Integer>> menu = new HashMap<>();
        for (List<String> order : orders) {
            String table = order.get(1);
            String food = order.get(2);
            tables.add(Integer.valueOf(table));
            foods.add(food);
            Map<String, Integer> m = menu.containsKey(table) ? menu.get(table) : new HashMap<>();
            m.put(food, 1 + m.getOrDefault(food, 0));
            menu.put(table, m);
        }
        List<List<String>> result = new ArrayList<>();
        List<String> title = new ArrayList<>();
        boolean first = true;
        for (Integer tab : tables) {
            List<String> item = new ArrayList<>();
            String table = String.valueOf(tab);
            if (first) {
                title.add("Table");
            }
            item.add(table);
            for (String food : foods) {
                if (first) {
                    title.add(food);
                }
                item.add(String.valueOf(menu.get(table).getOrDefault(food, 0)));
            }
            if (first) {
                result.add(title);
                first = false;
            }
            result.add(item);
        }
        return result;
    }
}