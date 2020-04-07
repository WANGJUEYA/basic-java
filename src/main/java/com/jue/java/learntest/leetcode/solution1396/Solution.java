package com.jue.java.learntest.leetcode.solution1396;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JUE
 * @date 2020/3/29
 * @note 0 error(s), 0 warning(s)
 **/
class UndergroundSystem {
    Map<String, List<Integer>> map;
    Map<Integer, String> inPerson;

    /**
     * Your UndergroundSystem object will be instantiated and called as such:
     * UndergroundSystem obj = new UndergroundSystem();
     * obj.checkIn(id,stationName,t);
     * obj.checkOut(id,stationName,t);
     * double param_3 = obj.getAverageTime(startStation,endStation);
     */
    public UndergroundSystem() {
        map = new HashMap<>();
        inPerson = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        // 一个人不可能进两次站
        inPerson.put(id, stationName + "#" + t);

    }

    public void checkOut(int id, String stationName, int t) {
        // 一个人不可能不进站只出站
        if (inPerson.containsKey(id)) {
            String[] in = inPerson.get(id).split("#");
            String key = in[0] + "#" + stationName;
            int time = t - Integer.parseInt(in[1]);
            if (map.containsKey(key)) {
                map.get(key).add(time);
            } else {
                map.put(key, new ArrayList<>() {{
                    add(time);
                }});
            }
        } else {
            throw new IllegalArgumentException("wrong id:" + id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Integer> temp = map.get(startStation + "#" + endStation);
        int sum = 0;
        int count = 0;
        for (Integer i : temp) {
            sum += i;
            count++;
        }
        if (count == 0) {
            return 0D;
        } else {
            return (sum * 1D) / count;
        }
    }
}
