package com.nzzi.study.lotto;

public class LottoExample {

    private static int[] randLotto() {
        int[] result = new int[6];

        for (int i = 0; i < 6; i++) {
            boolean isDuplicated;

            do {
                isDuplicated = false;
                result[i] = (int) (Math.random() * 45) + 1;

                for (int j = 0; j < i; j++) {
                    if (result[i] == result[j]) {
                        isDuplicated = true;
                        break;
                    }
                }
            } while (isDuplicated);
        }
        return result;
    }
}
