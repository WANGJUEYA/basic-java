//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。 
//
// 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。 
//
// 
//
// 我们可以按下面的指令规则行动： 
//
// 
// 如果方格存在，'U' 意味着将我们的位置上移一行； 
// 如果方格存在，'D' 意味着将我们的位置下移一行； 
// 如果方格存在，'L' 意味着将我们的位置左移一列； 
// 如果方格存在，'R' 意味着将我们的位置右移一列； 
// '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。 
// 
//
// （注意，字母板上只存在有字母的位置。） 
//
// 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = "leet"
//输出："DDR!UURRR!!DDD!"
// 
//
// 示例 2： 
//
// 
//输入：target = "code"
//输出："RR!DDRR!UUL!R!"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 100 
// target 仅含有小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 👍 64 👎 0


package com.jue.java.learn.leetcode.editor.cn.AlphabetBoardPath;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author JUE
 * @number 1138
 */
public class AlphabetBoardPath {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.alphabetBoardPath("leet")); // DDR!UURRR!!DDD!
        System.out.println(solution.alphabetBoardPath("code")); // RR!DDRR!UUL!R!
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static final char[][] board = {{'a', 'b', 'c', 'd', 'e'}, {'f', 'g', 'h', 'i', 'j'}, {'k', 'l', 'm', 'n', 'o'}, {'p', 'q', 'r', 's', 't'}, {'u', 'v', 'w', 'x', 'y'}, {'z', ' ', ' ', ' ', ' '}};
    public static final Map<String, int[]> STEP = new HashMap<>() {{
        put("U", new int[]{-1, 0});
        put("D", new int[]{1, 0});
        put("L", new int[]{0, -1});
        put("R", new int[]{0, 1});
    }};
    public static final int ROW = 6;
    public static final int COL = 5;

    public String alphabetBoardPath(String target) {
        StringBuilder result = new StringBuilder();
        int[] begin = new int[]{0, 0};
        for (char next : target.toCharArray()) {
            result.append(pathWithTwoPoint(begin, next)).append("!");
        }
        return result.toString();
    }

    static class MyQueueItem {
        String path;
        int row;
        int col;

        public MyQueueItem(String path, int row, int col) {
            this.path = path;
            this.row = row;
            this.col = col;
        }
    }

    private String pathWithTwoPoint(int[] currentPoint, char global) {
        // 广度遍历, 先入先出
        Queue<MyQueueItem> queue = new ArrayDeque<>();
        queue.add(new MyQueueItem("", currentPoint[0], currentPoint[1]));
        while (!queue.isEmpty()) {
            MyQueueItem item = queue.poll();
            if (board[item.row][item.col] == global) {
                currentPoint[0] = item.row;
                currentPoint[1] = item.col;
                return item.path;
            }
            for (Map.Entry<String, int[]> entry : STEP.entrySet()) {
                int newRow = item.row + entry.getValue()[0];
                int newCol = item.col + entry.getValue()[1];
                if (newRow >= 0 && newRow < ROW && newCol >= 0 && newCol < COL && board[newRow][newCol] != ' ') {
                    queue.add(new MyQueueItem(item.path + entry.getKey(), newRow, newCol));
                }
            }
        }
        return "";
    }

}
//leetcode submit region end(Prohibit modification and deletion)
