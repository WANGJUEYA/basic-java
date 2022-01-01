//在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。 
//
// 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求： 
//
// 
// age[y] <= 0.5 * age[x] + 7 
// age[y] > age[x] 
// age[y] > 100 && age[x] < 100 
// 
//
// 否则，x 将会向 y 发送一条好友请求。 
//
// 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。 
//
// 返回在该社交媒体网站上产生的好友请求总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：ages = [16,16]
//输出：2
//解释：2 人互发好友请求。
// 
//
// 示例 2： 
//
// 
//输入：ages = [16,17,18]
//输出：2
//解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
// 
//
// 示例 3： 
//
// 
//输入：ages = [20,30,100,110,120]
//输出：3
//解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
// 
//
// 
//
// 提示： 
//
// 
// n == ages.length 
// 1 <= n <= 2 * 10⁴ 
// 1 <= ages[i] <= 120 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 98 👎 0


package com.jue.java.learn.leetcode.editor.cn.FriendsOfAppropriateAges;

import java.util.Arrays;

/**
 * @author JUE
 * @number 825
 */
public class FriendsOfAppropriateAges {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numFriendRequests(new int[]{16, 16})); // 2
        System.out.println(solution.numFriendRequests(new int[]{16, 17, 18})); // 2
        System.out.println(solution.numFriendRequests(new int[]{20, 30, 100, 110, 120})); // 3
        System.out.println(solution.numFriendRequests(new int[]{101, 56, 69, 48, 30})); // 4
        System.out.println(solution.numFriendRequests(new int[]{98, 60, 24, 89, 84, 51, 61, 96, 108, 87, 68, 29, 14, 11, 13, 50, 13, 104, 57, 8, 57, 111, 92, 87, 9, 59, 65, 116, 56, 39, 55, 11, 21, 105, 57, 36, 48, 93, 20, 94, 35, 68, 64, 41, 37, 11, 50, 47, 8, 9})); // 439
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numFriendRequests(int[] ages) {
        // 对年龄数组进行排序, 最小区间到前一个人的个数(二分查找)
        Arrays.sort(ages);
        // 假如有 x 个人年纪一致, person个可发好友的对象, 增加数目为 c(x,2) * 2 + x * person
        int result = 0;
        int sameAgeCount = 1;
        int last = ages[0];
        int index = 0, len = ages.length;
        while (++index <= len) {

            // 如果年龄相同, 继续往下算
            if (index < len && ages[index] == last) {
                sameAgeCount++;
                continue;
            }
            // 判断是否有值得关注的人
            int follows = 0;
            int tempHighIndex = index - sameAgeCount - 1;
            double minAge = last * 0.5 + 7;
            if (tempHighIndex >= 0 && ages[tempHighIndex] > minAge) {
//                System.out.println(Arrays.toString(ages));
//                System.out.println("index: " + index);
//                System.out.println("ages[index]: " + (index < len ? ages[index] : 0));
//                System.out.println("last: " + last);
//                System.out.println("minAge: " + minAge);
//                System.out.println("sameAgeCount: " + sameAgeCount);
                // 到年龄不同时, 开始二分查找person个数
                int low = 0, high = tempHighIndex, mid;
                while (low < high) {
                    mid = (low + high) / 2;
                    if (ages[mid] <= minAge) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                mid = (low + high) / 2;
                follows = (index - sameAgeCount) - mid;
//                System.out.println("mid: " + mid);
//                System.out.println("ages[mid]: " + ages[mid]);
//                System.out.println("follows: " + follows);
            }

            if (follows > 0) {
                result += follows * sameAgeCount;
            }

            if (sameAgeCount > 1 && last > minAge) {
                result += C(sameAgeCount, 2) * 2;
            }

            last = index < len ? ages[index] : 0;
            sameAgeCount = 1;
        }

        return result;
    }

    private int C(int m, int n) {
        int molecule = 1;
        int denominator = 1;
        for (int index = 1; index <= n; index++) {
            molecule *= index;
            denominator *= (m - index + 1);
        }
//        System.out.println("C(" + m + "," + n + ")=" + denominator / molecule);
        return denominator / molecule;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


