package com.nzzi.study._remember;

import java.util.ArrayList;
import java.util.List;

public class Prime {

    public static void main(String[] args) {

        List<Integer> primes = new Prime().getPrime(1, 30);

        System.out.println(primes);

    }

    public List<Integer> getPrime(int a, int b) {

        List<Integer> result = new ArrayList<>();
        List<Boolean> primeBucket = new ArrayList<>();
        primeBucket.add(false);
        primeBucket.add(false);

        for (int i = 2; i <= b; i++)
            primeBucket.add(true);

        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (primeBucket.get(i)) {
                for (int j = i*i; j <= b; j += i) {
                    primeBucket.set(j, false);
                }
            }
        }

        for (int i = a; i < primeBucket.size(); i++) {
            if (primeBucket.get(i)) {
                result.add(i);
            }
        }
        return result;
    }

}
