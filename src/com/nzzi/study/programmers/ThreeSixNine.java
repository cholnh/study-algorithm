package com.nzzi.study.programmers;

public class ThreeSixNine {

    private final int[] triggers = {3, 6, 9};

    public static void main(String[] args) {
        System.out.println(new ThreeSixNine().solution(33));
    }

    public int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; ++i) {
            answer += getCount(i);
        }
        return answer;
    }

    private int getCount(int number) {
        int count = 0;
        for (String part : String.valueOf(number).split(""))
            for (int trigger : triggers)
                if (trigger == Integer.parseInt(part))
                    count++;
        return count;
    }
}
