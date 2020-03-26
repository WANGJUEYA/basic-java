package com.jue.java.learntest.offeronline.T_AL_2020_03_24_B;

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
     * 现有n个人, 要从这n个人中选任意数量的人组成一支队伍，再在这些人中选出一名队长
     * 求不同的方案数(对 10^9+7 取模)的结果。如果两个方案选取的人的集合不同或选出的队长不同
     * 则认为这两个方案是不同的
     */
    public int function(int n) {
        int MOD = (int) (1E9 + 7);
        Map<Integer, Double> map = new HashMap<>();
        double mul = 1;
        map.put(0, mul);
        for (int i = 1; i <= n; i++) {
            mul = (mul * i) % MOD;
            map.put(i, mul);
        }
        // sum(i * Cn(i)) = sum( (n!) / [r!*(n-r)!] )
        int sum = 1;
        for (int r = 1; r <= n; r++) {
            int sub =


                    sum += (map.get(n) / (map.get(r) * map.get(n - r))) % MOD;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println((new Main()).function(1));
        System.out.println((new Main()).function(2));
        System.out.println((new Main()).function(3));
        System.out.println((new Main()).function(4));
        System.out.println((new Main()).function(5));
        System.out.println((new Main()).function(6));
        System.out.println((new Main()).function(7));
        System.out.println((new Main()).function(8));
        System.out.println((new Main()).function(9));
        System.out.println((new Main()).function(10));
        System.out.println((new Main()).function(20));
        System.out.println((new Main()).function(50));
        System.out.println((new Main()).function(1000));
        System.out.println((new Main()).function(10000));
    }
}

// https://blog.csdn.net/sinat_27990891/article/details/105056793
// https://www.cnblogs.com/1024th/p/10623541.html
class Main_Perfect {
    static int mod = 1000000007;

    // sum[i * Cn(i)] = sum[i * (n! / (i! * (n-i)!))]
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println((pow(n - 1) * n) % mod);
    }


    // 快速幂韩式 求 2^n 的结果 同理可以求出 a^n 的结果
    public static long pow(int n) {
        if (n == 0)
            return 1;
        long half = pow(n / 2);
        if (n % 2 == 0)
            return (half * half) % mod;
        else
            return (half * half * 2) % mod;
    }
}
