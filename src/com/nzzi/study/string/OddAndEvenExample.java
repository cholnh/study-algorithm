package com.nzzi.study.string;

public class OddAndEvenExample {

    public static int oddEven(int[] arr) {
        int n = arr.length;

        int[] odds = new int[n];
        int[] evens = new int[n];
        int[] reverseOdds = new int[n];
        int[] reverseEvens = new int[n];

        init(odds);
        init(evens);
        init(reverseOdds);
        init(reverseEvens);

        for (int i = 2; i < n; i += 2) {
            odds[i] = arr[i - 1] + odds[i - 2];
            if (i != n - 1)
                odds[i + 1] = odds[i];
        }
        for (int i = 1; i < n; i += 2) {
            evens[i] = arr[i - 1] + (i == 1 ? 0 : evens[i - 2]);
            if (i != n - 1)
                evens[i + 1] = evens[i];
        }

        int start = n % 2 == 0 ? n - 2 : n - 3;
        for (int i = start; i >= 0; i-=2) {
            reverseOdds[i] = arr[i + 1] + reverseOdds[i + 2];
            if (i != 0)
                reverseOdds[i - 1] = reverseOdds[i];
        }

        start = n % 2 == 0 ? n - 3 : n - 2;
        for (int i = start; i >= 0; i -= 2) {
            reverseEvens[i] = arr[i + 1] + (i == start ? 0 : reverseEvens[i + 2]);
            if (i != 0)
                reverseEvens[i - 1] = reverseEvens[i];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int sumOdd = odds[i] + reverseEvens[i];
            int sumEven = evens[i] + reverseOdds[i];
            if (sumOdd == sumEven) count++;
        }
        return count;
    }

    private static void init(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
