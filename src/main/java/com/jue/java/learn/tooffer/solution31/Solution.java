package com.jue.java.learn.tooffer.solution31;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] test = {1, 1, 1, 2, 3, 4, 5};
        System.out.println((new SolutionPerfect2().MoreThanHalfNum_Solution(test)));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        int len = array.length / 2;
        //map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
            if (map.size() > (len + 1)) {
                return 0;
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > len) {
                return entry.getKey();
            }
        }
        return 0;
    }
}

class SolutionPerfect {
    public int MoreThanHalfNum_Solution(int[] array) {
        int length = array.length;
        if (array == null || length <= 0) {
            return 0;
        }
        if (length == 1) {
            return array[1];
        }
        int[] tempArray = new int[length];
        for (int i = 0; i < length; i++) {
            tempArray[i] = array[i];
        }
        for (int i = 0; i < length; i++) {
            //后面需要用零来代表抹除数字，所以对0时做特殊处理
            if (tempArray[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                if (tempArray[i] != tempArray[j] && tempArray[j] != 0) {
                    //此处用0代表抹去该数字
                    tempArray[i] = 0;
                    tempArray[j] = 0;
                    break;
                }
            }
        }
        //找出未被抹去的数字
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (tempArray[i] != 0) {
                result = tempArray[i];
                break;
            }
        }
        int times = 0;
        for (int i = 0; i < length; i++) {
            if (result == array[i]) {
                times++;
            }
        }
        if (times * 2 < length) {
            result = 0;
        }
        return result;
    }
}

class SolutionPerfect2 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int length = array.length;
        if (array == null || length <= 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else {
                if (array[i] == result) {
                    times++;
                } else {
                    times--;
                }
            }
        }
        times = 0;
        for (int i = 0; i < length; i++) {
            if (result == array[i]) {
                times++;
            }
        }
        if (times * 2 < length) {
            result = 0;
        }
        return result;
    }
}