package com.nzzi.study.imple;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LongFactorialsExample {
    static void extraLongFactorials(int n) {
        List<BigInteger> dp = new ArrayList();
        dp.add(BigInteger.valueOf(0L));
        dp.add(BigInteger.valueOf(1L));

        for (int i = 2; i <= n; i++) {
            dp.add((dp.get(i - 1).multiply(BigInteger.valueOf(i))));
        }

        System.out.println(dp.get(n).toString());
    }

}
