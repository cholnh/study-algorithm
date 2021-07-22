package com.nzzi.study.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrimeFind {

    public static void main(String[] args) {
        System.out.println(new PrimeFind().solution("17"));
    }

    private Set<Integer> set = new HashSet<>();
    private Map<Integer, Boolean> primeBucket = new HashMap<>();

    public int solution(String numbers) {
        int answer = 0;
        String[] strArr = numbers.split("");
        makePrimeBucket(Math.pow(10, numbers.length()));
        for (int i = 1; i <= strArr.length; ++i)
            permutation(strArr, 0, i);
        for (Integer number : set)
            if (primeBucket.get(number)) answer++;
        return answer;
    }

    private void makePrimeBucket(double limit) {
        for (int i = 0; i < limit; i++)
            primeBucket.put(i, true);
        primeBucket.put(0, false);
        primeBucket.put(1, false);
        for (int i = 2; i < Math.sqrt(limit); ++i)
            if (primeBucket.get(i))
                for (int j = i*i; j < limit; j += i)
                    primeBucket.put(j, false);
    }

    private void permutation(String[] arr, int depth, int r) {
        if (r == depth) {
            StringBuilder comb = new StringBuilder();
            for (int i = 0 ; i < r; ++i)
                comb.append(arr[i]);
            set.add(Integer.parseInt(comb.toString()));
        }
        for (int i = depth; i < arr.length; ++i) {
            swap(arr, depth, i);
            permutation(arr, depth+1, r);
            swap(arr, depth, i);
        }
    }

    private void swap(String[] arr, int arg1, int arg2) {
        String temp = arr[arg1];
        arr[arg1] = arr[arg2];
        arr[arg2] = temp;
    }


}
