package com.nzzi.study.programmers;

import java.util.*;

public class Dp1 {

    public static void main(String[] args) {
        int N = 5;
        int number = 26;
        System.out.println("[ N: "+N+ ", number: " + number+" ]\n\n");
        System.out.println("answer: "+new Dp1().solution(N, number));
    }

    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        Set<Integer> first = new HashSet<>();
        if (N == number) return 1;
        first.add(N);
        dp.add(0, new HashSet<>());
        dp.add(1, first);

        for (int depth = 2; depth <= 8; depth++) {
            Set<Integer> newSet = new HashSet<>();
            for (int lengthOfN = 1; lengthOfN <= depth; lengthOfN++) {
                int value = 0;
                if (lengthOfN == depth) {
                    value = convert(N, depth);
                    if (value == number) return depth;
                    else newSet.add(value);
                }
                else
                    for (Integer preNode : dp.get(lengthOfN))
                        for (Integer postNode : dp.get(depth - lengthOfN))
                            for (int type = 1; type <= 4; type++) {
                                switch (type) {
                                    case 1: value = preNode + postNode; break;
                                    case 2: value = preNode - postNode; break;
                                    case 3: value = preNode * postNode; break;
                                    case 4: value = postNode != 0 ? preNode / postNode : -1; break;
                                }
                                if (type == 4 && postNode == 0) continue;
                                if (value == number) return depth;
                                else newSet.add(value);
                            }
            }
            dp.add(depth, newSet);
        }
        return -1;
    }
    private int convert(int N, int repeat) {
        StringBuilder repeatedN = new StringBuilder();
        for (int i = 1; i <= repeat; i++)
            repeatedN.append(N);
        return Integer.parseInt(repeatedN.toString());
    }
}
