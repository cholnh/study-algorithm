package com.nzzi.study._remember;

public class Combination {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        new Combination().combine(arr);
    }

    public void combine(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        innerRecursiveMethod(arr, 0, arr.length, 3, visited);
    }

    public void innerRecursiveMethod(int[] arr, int start, int n, int r, boolean[] visited) {

        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i])
                    System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            innerRecursiveMethod(arr, i+1, n, r-1, visited);
            visited[i] = false;
        }
    }
}
