package com.nzzi.study.string;

public class KInterSpaceSubStringExample {

    public static void find(String str, int k) {
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean isAppendFinished = true;

        for (int i = 0; i < str.length() - 1; i++) {
            char s = str.charAt(i);
            char e = str.charAt(i + 1);
            int dist = Math.abs(s - e);

            if (dist <= k) {
                temp.append(isAppendFinished ? "" + s + e : "" + e);
                isAppendFinished = false;
            }
            else {
                isAppendFinished = true;
            }

            boolean isRoundFinished = i == str.length() - 2;
            if (isRoundFinished || isAppendFinished) {
                if (temp.length() > 0 && temp.length() > result.length()) {
                    result.setLength(0);
                    result.append(temp.toString());
                    temp.setLength(0);
                }
            }
        }
        System.out.println(result);
    }
}
