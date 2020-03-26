package com.jue.java.learntest.offeronline.T_HW_2016_C;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author JUE
 * @date 2020/3/17
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {

    /**
     * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A，2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）:)
     * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
     * 输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如：4 4 4 4-joker JOKER
     * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR
     * <p>
     * 基本规则：
     * （1）输入每手牌可能是个子，对子，顺子（连续5张），三个，炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
     * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）
     * （3）大小规则跟大家平时了解的常见规则相同，个子，对子，三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
     * （4）输入的两手牌不会出现相等的情况。
     * <p>
     * 答案提示：
     * （1）除了炸弹和对王之外，其他必须同类型比较。
     * （2）输入已经保证合法性，不用检查输入是否是合法的牌。
     * （3）输入的顺子已经经过从小到大排序，因此不用再排序了.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] hand = line.split("-");
            System.out.println((new Main()).compare(hand[0], hand[1]));
        }
    }

    public String compare(String handA, String handB) {
        // this can be replaces by switch
        Map<String, Integer> map = new HashMap<>();
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        map.put("joker", 15);
        map.put("JOKER", 16);
        String[] hand_a = handA.split(" ");
        String[] hand_b = handB.split(" ");
        int typeA = type(hand_a);
        int typeB = type(hand_b);
        if (typeA == 4 && typeB != 4) {
            return handA;
        } else if (typeA != 4 && typeB == 4) {
            return handB;
        } else if (typeA == typeB) {
            return map.get(hand_a[0]) > map.get(hand_b[0])
                    ? handA : handB;
        } else {
            return "ERROR";
        }
    }

    private int type(String[] hand) {
        int len = hand.length;
        if (len == 2 && ("joker".equalsIgnoreCase(hand[0]))) {
            return 4;
        } else {
            return len;
        }
    }
}
