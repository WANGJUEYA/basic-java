package com.jue.java.learntest.utils;

import java.io.File;
import java.io.FileWriter;

/**
 * @author JUE
 * @date 2019/6/18
 * @apiNote MyFile
 * note: 0 error(s),0 warning(s)
 */
public class MyFile {
    public static void main(String[] args) throws Exception {
        String prefix = "package com.jue.java.learntest.leetcode.solution";
        String dir = (new File("")).getAbsolutePath() + File.separator + "leetcode";
        int current = 1314;
        File fileDir = new File(dir);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }

        for (int i = 1; i <= current; i++) {
            String index = String.format("%04d", i);
            String content = prefix + index + ";";
            String dirSolution = dir + File.separator + "solution" + index;
            fileDir = new File(dirSolution);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }
            FileWriter fw = new FileWriter(fileDir + File.separator + "Solution.java", false);
            fw.write(content);
            // 关闭写文件,每次仅仅写一行数据，因为一个读文件中仅仅一个唯一的od
            fw.close();
        }
    }
}
