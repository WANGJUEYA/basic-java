package com.jue.java.learn.tooffer.solution36;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap();
        for (int i = 0, n = str.length(); i < n; i++) {
            String temp = str.charAt(i) + "";
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return str.indexOf((int) entry.getKey().charAt(0));
            }
        }
        return -1;
    }
}