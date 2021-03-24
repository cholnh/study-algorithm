package com.nzzi.study.sort;

public class SelectedSortExample {
    private int[] array;

    public SelectedSortExample init() {
        array = new int[] {7,5,9,0,3,1,6,2,4,8};
        return this;
    }

    public SelectedSortExample sort() {
        for (int i = 0; i < array.length; i++) {
            int minIdx = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIdx] > array[j]) {
                    minIdx = j;
                }
            }
            swap(array, minIdx, i);
        }
        return this;
    }

    public SelectedSortExample print() {
        System.out.print("SelectedSortExample [ ");
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
