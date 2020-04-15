package com.jue.java.learntest.offeronline.T_PDD_2020_04_10_D;

import java.util.*;

/**
 * @author JUE
 * @date 2020/4/10
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int len = scanner.nextInt();
            int total = scanner.nextInt();
            Map<Integer, List<Integer>> distance = new HashMap<>();
            Map<Integer, int[]> map = new HashMap<>();
            int begin = -1;
            int last = 0;
            int max = Integer.MIN_VALUE;
            for (int index = 0; index < len; index++) {
                int temp = scanner.nextInt();
                if (temp != last || index == len - 1) {
                    // 放入上一个
                    if (last > 0) {
                        int end = index == len - 1 ? len - 1 : index - 1;
                        int[] array = new int[]{begin, end};
                        int subLen = end - begin + 1;
                        List<Integer> item = distance.containsKey(last) ? distance.get(last) : new ArrayList<>();
                        if (map.containsKey(last)) {
                            int dis = begin - map.get(last)[1] - 1;
                            item.add(dis);
                        }
                        max = Math.max(max, subLen);
                        item.add(subLen);
                        distance.put(last, item);
                        map.put(last, array);
                    }
                    // 刷新这一个
                    begin = index;
                    last = temp;
                }
            }
            for (List<Integer> item : distance.values()) {
                int n = item.size();
                if (n < 3) {
                    continue;
                }
                int[][] dp = new int[n / 2 + 1][3]; // 0-len 1-dis 2-index
                dp[0][0] = item.get(0);
                dp[0][2] = -1;
                for (int index = 2; index < n; index += 2) {
                    int l = index / 2 - 1, c = index / 2;
                    dp[c][0] = dp[l][0] + item.get(index);
                    dp[c][1] = dp[l][1] + item.get(index - 1);
                    int tempIndex = dp[l][2];
                    while (dp[c][1] > total && tempIndex > 0) {
                        dp[c][1] -= item.get(tempIndex);
                        dp[c][0] -= item.get(tempIndex - 1);
                        tempIndex += 2;
                    }
                    dp[c][2] = tempIndex;
                    max = Math.max(max, dp[c][0]);
                }
            }
            System.out.println(max);
        }
    }
}
