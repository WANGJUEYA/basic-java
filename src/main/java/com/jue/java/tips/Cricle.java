package com.jue.java.tips;

public class Cricle {
    public static void main(String[] args) {
        count(11);
    }

    public static void count(long r) {
        System.out.println(r / 2);
        long pow = r * r;
        long lastX = r;
        for (long y = 0; y <= r; y += 1) {
            long min = Long.MAX_VALUE;
            long minx = lastX;
            for (long x = r; x >= 0; x--) {
                long current = y * y + x * x;
                long c = Math.abs(pow - current);
                if (c <= min) {
                    min = c;
                    minx = x;
                }
            }
            lastX = minx;
            print(r, lastX, y);
        }
    }

    public static void print(long r, long x, long y) {
        System.out.printf("r: %d, x: %d, y:%d;   %d\n", r, x, y, (r - x));
    }

}
