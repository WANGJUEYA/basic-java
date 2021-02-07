package com.jue.java.learn.tooffer.solution22;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Character, Integer> words = new HashMap<>();
    private String stringstream = "";

    /**
     * Insert one char from stringstream
     */
    public void Insert(char ch) {
        stringstream += ch;
        if (words.containsKey(ch)) {
            words.put(ch, words.get(ch) + 1);
        } else {
            words.put(ch, 1);
        }
    }

    /**
     * return the first appearence once char in current stringstream
     */
    public char FirstAppearingOnce() {
        for (int i = 0, n = stringstream.length(); i < n; i++) {
            char ch = stringstream.charAt(i);
            int temp = words.get(ch);
            if (temp == 1) {
                return ch;
            }
        }
        return '#';
    }
}

class SolutionPerfect {
    //Insert one char from stringstream
    String stringstream = "";
    int[] hash = new int[256];

    public void Insert(char ch) {
        stringstream += ch;
        hash[ch]++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0, n = stringstream.length(); i < n; i++) {
            char ch = stringstream.charAt(i);
            if (hash[ch] == 1) {
                return ch;
            }
        }
        return '#';
    }

};
