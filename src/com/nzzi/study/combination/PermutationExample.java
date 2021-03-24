package com.nzzi.study.combination;

public class PermutationExample {
    public static void permutation(int[] array, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++)
                System.out.print(array[i] + " ");
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(array, depth, i);
            permutation(array, depth + 1, n, r);
            swap(array, depth, i);
        }
    }

    private static void swap(int[] array, int arg1, int arg2) {
        int temp = array[arg1];
        array[arg1] = array[arg2];
        array[arg2] = temp;
    }
}
