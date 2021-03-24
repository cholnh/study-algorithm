package com.nzzi.study.gcd;

public class GcdExample {
    public static int gcd(int arg1, int arg2) {
        while (arg2 != 0) {
            int swapTemp = arg1 % arg2;
            arg1 = arg2;
            arg2 = swapTemp;
        }
        return Math.abs(arg1);
    }

    public static int lcm(int arg1, int arg2) {
        return (arg1 * arg2) / gcd(arg1, arg2);
    }
}


