package com.jue.java.tips;

/**
 * @author JUE
 * @date 2020/3/12
 * @note 0 error(s), 0 warning(s)
 **/
public class IdCard {

    /**
     * 1、将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7－9－10－5－8－4－2－1－6－3－7－9－10－5－8－4－2。
     * 2、将这17位数字和系数相乘的结果相加。
     * 3、用加出来和除以11，看余数是多少？
     * 4、余数只可能有0－1－2－3－4－5－6－7－8－9－10这11个数字。其分别对应的最后一位身份证的号码为1－0－X －9－8－7－6－5－4－3－2。(即余数0对应1，余数1对应0，余数2对应X...)
     * 5、通过上面得知如果余数是3，就会在身份证的第18位数字上出现的是9。如果对应的数字是2，身份证的最后一位号码就是罗马数字x。
     */
    public int last(String num17) {
        int[] ratio = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        int[] table = {1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int total = 0;
        for (int index = 0; index < 17; index++) {
            total += ratio[index] * Integer.parseInt(num17.charAt(index) + "");
        }
        return table[total % 11];
    }

    public static void main(String[] args) {
//        System.out.println((new IdCard()).last("51102319970506842"));
        System.out.println((new IdCard()).last("51202120070209841"));
    }
}
