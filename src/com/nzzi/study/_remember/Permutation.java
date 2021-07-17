package com.nzzi.study._remember;

public class Permutation {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        new Permutation().permutate(arr, 0, 3, 3);
    }

    public void permutate(int[] arr, int depth, int n, int r) {

        if (r == depth) {
            for (int i = 0; i < n; i ++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutate(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    public void swap(int[] arr, int arg1, int arg2) {
        int temp = arr[arg1];
        arr[arg1] = arr[arg2];
        arr[arg2] = temp;
    }
}
