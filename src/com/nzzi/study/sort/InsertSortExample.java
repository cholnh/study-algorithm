package com.nzzi.study.sort;

public class InsertSortExample {
    private int[] array;

    public InsertSortExample init() {
        array = new int[] {7,5,9,0,3,1,6,2,4,8};
        return this;
    }

    public InsertSortExample sort() {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return this;
    }

    public InsertSortExample print() {
        System.out.print("InsertSortExample [ ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.print("]");
        return this;
    }

    public void swap(int[] array, int arg1, int arg2) {
        int temp = array[arg1];
        array[arg1] = array[arg2];
        array[arg2] = temp;
    }
}
