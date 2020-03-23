package com.jue.java.learntest.leetcode.solution0007;

class Solution {
    public int reverse(int x) {
        if(x <= -Math.pow(2,31) || x > Math.pow(2,31)){
            return 0;
        }

        long temp = x > 0 ? x : -1 * x;
        // System.out.println(temp);
        long result = 0;
        do{
            int mod = ((int)temp) % 10;
            if( result * 10 + mod > Math.pow(2,31)){
                return 0;
            }
            result = result * 10 + mod;
            temp /= 10;
            // System.out.println(result);

        }while(temp > 0);
        return (int)(x > 0 ? result : -result);
    }
}