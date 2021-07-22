package com.nzzi.study._remember;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

    public static void main(String[] args) {

        StringPermutation stringPermutation = new StringPermutation();

        String str = "7011722389";
        Set<Double> set1 = new HashSet<>();

        long cur = System.currentTimeMillis();
        stringPermutation.permutate1("", str, set1);
        System.out.println("1 : "+ (System.currentTimeMillis()-cur));

        cur = System.currentTimeMillis();
        String[] strArr = str.split("");
        for (int i = 1; i <= strArr.length; ++i)
            stringPermutation.permutate2(strArr, 0, i);
        System.out.println("2 : "+ (System.currentTimeMillis()-cur));

        System.out.println("[output]");
        //System.out.println(set1);
        //System.out.println(stringPermutation.set2);
    }

    public void permutate1(String prefix, String str, Set<Double> set) {
        int length = str.length();
        if (!prefix.isEmpty())
            set.add(Double.parseDouble(prefix));
        for (int i = 0; i < length; ++i)
            permutate1(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, length), set);
    }

    private Set<Double> set2 = new HashSet<>();
    private void permutate2(String[] arr, int depth, int r) {
        if (r == depth) {
            StringBuilder comb = new StringBuilder();
            for (int i = 0 ; i < r; ++i)
                comb.append(arr[i]);
            set2.add(Double.parseDouble(comb.toString()));
        }
        for (int i = depth; i < arr.length; ++i) {
            swap(arr, depth, i);
            permutate2(arr, depth+1, r);
            swap(arr, depth, i);
        }
    }

    private void swap(String[] arr, int arg1, int arg2) {
        String temp = arr[arg1];
        arr[arg1] = arr[arg2];
        arr[arg2] = temp;
    }
}
