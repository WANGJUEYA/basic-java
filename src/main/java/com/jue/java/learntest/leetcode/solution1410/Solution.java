package com.jue.java.learntest.leetcode.solution1410;

/**
 * @author JUE
 * @date 2020/4/12
 * @note 0 error(s), 0 warning(s)
 **/
class Solution {
    public String entityParser(String text) {
        text = text.replaceAll("&quot;", "\"");
        text = text.replaceAll("&apos;", "'");
        text = text.replaceAll("&amp;", "&");
        text = text.replaceAll("&gt;", ">");
        text = text.replaceAll("&lt;", "<");
        text = text.replaceAll("&frasl;", "/");
        return text;
    }
}
