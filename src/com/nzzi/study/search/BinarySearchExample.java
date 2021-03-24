package com.nzzi.study.search;

import java.util.Random;

public class BinarySearchExample {
    private int[] array;

    public BinarySearchExample init(int n) {
        Random random = new Random();
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }
        return this;
    }

    public int search(int target) {
        int index;

        sort();
        print();
        index = iterativeSearch(array, target, 0, array.length - 1);

        System.out.println("index : " + index + (index != -1 ? ", value : " + array[index] : ""));
        return index;
    }

    private int recursiveSearch(int[] array, int target, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return mid;
        }
        else if (array[mid] > target) {
            return recursiveSearch(array, target, start, mid - 1);
        }
        else {
            return recursiveSearch(array, target, mid + 1, end);
        }
    }

    private int iterativeSearch(int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (array[mid] == target) {
                return mid;
            }
            else if (array[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public void sort() {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public void print() {
        System.out.print("InsertSortExample [ ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
}
