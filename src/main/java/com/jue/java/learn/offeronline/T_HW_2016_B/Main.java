package com.jue.java.learn.offeronline.T_HW_2016_B;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author JUE
 * @date 2020/3/17
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {

    /**
     * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
     * 处理:
     * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
     * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
     * 3.输入的文件可能带路径，记录文件名称不能带路径
     * <p>
     * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
     * 文件路径为windows格式
     * 如：E:\V1R2\product\fpgadrive.c 1325
     * <p>
     * 将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
     * 结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
     * 如果超过8条记录，则只输出前8条记录.
     * 如果文件名的长度超过16个字符，则只输出后16个字符
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
//            String[] array = line.split(" ");
//            File file = new File(array[0]);
//            String name = file.getName();
//
//            String key = name + " " + array[1];

//            String key = line.split("\\")[1];

            // 手动寻找到最后一个反斜杠
            int index = 0;
            for (int i = 0, n = line.length(); i < n; i++) {
                if ('\\' == line.charAt(i)) {
                    index = i + 1;
                }
            }
            String key = line.substring(index);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int count = 0;
        while (!map.isEmpty() && count++ < 8) {
            int max = -1;
            String newKey = "";
            for (String key : map.keySet()) {
                if (map.get(key) > max) {
                    max = map.get(key);
                    newKey = key;
                }
            }
            String[] array = newKey.split(" ");
            int len = array[0].length();
            String end = len > 16 ? array[0].substring(len - 16) : array[0];
            System.out.println(end + " " + array[1] + " " + max);
            map.remove(newKey, max);
        }
    }
}
