package com.nzzi.study.sort.radix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * usage : RadixSort.of(arr).sort();
 */
public class RadixSort {

    private final int MAX_BUCKET_SIZE = 10;
    private List<Queue<Integer>> bucket;
    private int[] result;
    private int digit;

    private RadixSort() {
        bucket = new ArrayList<>();

        for (int i = 0; i < MAX_BUCKET_SIZE; i++) {
            bucket.add(new LinkedList<>());
        }
    }

    private RadixSort(int[] target) {
        this();
        this.result = target;
    }

    public static RadixSort of(int[] array) {
        validateArray(array);
        return new RadixSort(array);
    }

    public int[] sort() {
        initializeDigit();

        int round = calculateMaxlength();
        while (round-- >= 0) {
            calculateBucket();
        }
        return result;
    }

    private static void validateArray(int[] array) {
        for (int datum : array)
            if (datum < 0) throw new IllegalArgumentException();
    }

    private void initializeDigit() {
        digit = 1;
    }

    private void updateDigit() {
        digit *= MAX_BUCKET_SIZE;
    }

    private void calculateBucket() {
        offerDataToBucketWithDigit();
        updateResult();
        updateDigit();
    }

    private void offerDataToBucketWithDigit() {
        for (int value : result) {
            bucket.get((value / digit) % 10)
                    .offer(value);
        }
    }

    private void updateResult() {
        int index = 0;
        for (Queue<Integer> queue : bucket)
            while (!queue.isEmpty()) {
                result[index] = queue.poll();
                index += 1;
            }
    }

    private int calculateMaxlength() {
        int max = 0;
        for (int datum : result) {
            int length = (int) Math.log10((double) datum) + 1;
            max = max < length ? length : max;
        }
        return max;
    }
}
