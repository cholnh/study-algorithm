package com.nzzi.study.programmers;

import java.util.ArrayList;
import java.util.List;

public class MathMan {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] answer = new MathMan().solution(arr);
        for (int a : answer)
            System.out.print(a + " ");
    }

    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();

        int[][] patterns = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };
        int[] scores = new int[patterns.length];

        for (int i = 0; i < answers.length; ++i) {
            for (int pi = 0; pi < patterns.length; ++pi) {
                if (answers[i] == getAnswerInPattern(i, patterns[pi]))
                    scores[pi]++;
            }
        }

        int max = -1;
        for (int i = 0; i < scores.length; ++i) {
            if (max < scores[i]) {
                answer.clear();
                max = scores[i];
                answer.add(i+1);
            }
            else if (max == scores[i])
                answer.add(i+1);
        }

        return answer.stream().mapToInt(x->x).toArray();
    }

    private int getAnswerInPattern(int index, int[] pattern) {
        return pattern[index % pattern.length];
    }
}
