package com.jue.java.learntest.offeronline.T_HW_2020_10_26_B;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author JUE
 * @date 2020/10/26
 * @note 0 error(s), 0 warning(s)
 **/
public class Main {
    public static void main(String[] args) {
        // 不考虑双层嵌套
        // TODO 是否考虑括号不完整???
        // 目前看到所有不合法的坐标均为0开头
        Scanner in = new Scanner(System.in);
        // 使用正则表达式
//        Matcher matcher = Pattern.compile("(\\(\\d*,\\d*\\))").matcher("ferg(1,2)qwew(23,4)");
//        while (matcher.find()) {
//            System.out.println(matcher.group(0));
//        }
        String line = in.nextLine();
        int X = 0;
        int Y = 0;
        int POS = 0;
        int index = 0, len = line.length();
        while (index < len) {
            boolean end = false;
            char temp = line.charAt(index);
            // 进入遍历知道结束
            if (temp == '(') {
                int x = 0;
                int y = 0;
                if (index + 1 >= len) {
                    break;
                }
                if ('0' == line.charAt(index + 1)) {
                    if (index + 2 < len && ',' == line.charAt(index + 2)) {
                        x = 0;
                    } else {
                        index++;
                        end = true;
                    }
                } else {
                    boolean first = true;
                    while (++index < len) {
                        char leftChar = line.charAt(index);
                        if (leftChar == ',') {
                            if (first) {
                                end = true;
                            }
                            break;
                        } else if (leftChar >= '0' && leftChar <= '9' && (x = number(x, leftChar)) > 0) {
                        } else {
                            index++;
                            end = true;
                            break;
                        }
                        first = false;
                    }
                    if (end) {
                        continue;
                    }
                    if ('0' == line.charAt(index + 1)) {
                        if (index + 2 < len && ')' == line.charAt(index + 2)) {
                            y = 0;
                        } else {
                            index++;
                            end = true;
                        }
                    } else {
                        first = true;
                        while (++index < len) {
                            char rightChar = line.charAt(index);
                            if (rightChar == ')') {
                                if (first) {
                                    end = true;
                                }
                                index++;
                                break;
                            } else if (rightChar >= '0' && rightChar <= '9' && (y = number(y, rightChar)) > 0) {
                            } else {
                                index++;
                                end = true;
                                break;
                            }
                            first = false;
                        }
                    }
                }
                if (end) {
                    continue;
                }
                int pos = x * x + y * y;
                if (pos > POS) {
                    X = x;
                    Y = y;
                    POS = pos;
                }
            } else {
                index++;
            }
        }
        System.out.printf("(%d,%d)", X, Y);
    }

    /**
     * @param before 之前的数字和
     * @param next   下一个数字(默认符合规则)
     * @return 最后结果
     */
    public static int number(int before, char next) {
        int result = before * 10 + (next - '0');
        return result >= 1000 ? -1 : result;
    }
}
