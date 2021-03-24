package com.nzzi.study.string;

public class AppendAndDeleteExample {

    // https://www.hackerrank.com/challenges/append-and-delete/problem
    // Complete the appendAndDelete function below.
    //
    static String appendAndDelete(String s, String t, int k) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        if (k >= 2 * tArray.length)
            return "Yes";
        else
            return calculateLowerChar(sArray, tArray, k);
    }

    static String calculateLowerChar(char[] sArray, char[] tArray, int k) {
        int cntSame = calculateCntSame(sArray, tArray);
        int remainS = sArray.length - cntSame;
        int remainT = tArray.length - cntSame;

        k -= remainS;

        if (k < remainT) {
            return "No";
        }
        else {
            return (k - remainT) % 2 == 0
                    ? "Yes"
                    : "No";
        }
    }

    static int calculateCntSame(char[] sArray, char[] tArray) {
        int count = 0;
        int n = sArray.length < tArray.length ? sArray.length : tArray.length;

        for (int i = 0; i < n; i++) {
            if (sArray[i] == tArray[i])
                count++;
            else
                break;

        }
        return count;
    }
}
