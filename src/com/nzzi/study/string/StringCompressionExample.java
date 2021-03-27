package com.nzzi.study.string;

public class StringCompressionExample {

    public static void main(String...args) {
        System.out.println(new StringCompressionExample().solution("a"));
    }

    public int solution(String word) {
        int answer = word.length();
        for (int i = 1; i <= word.length() / 2; ++i) {
            String pre = word.substring(0, i);

            int deleted = 0;
            int repeatCount = 1;
            for (int j = i; j <= word.length() - i; j += i) {
                String next = word.substring(j, j + i);
                String cur = pre;

                if (cur.equals(next)) {
                    deleted += i;
                    repeatCount++;
                } else {
                    if (repeatCount > 1) {
                        int length = (int) Math.log10((double) repeatCount) + 1; // 자리수
                        deleted -= length;
                    }
                    pre = next;
                    repeatCount = 1;
                }
            }
            if (repeatCount > 1) {
                int length = (int) Math.log10((double) repeatCount) + 1; // 자리수
                deleted -= length;
            }
            int result = word.length() - deleted;
            answer = Math.min(answer, result);
        }
        return answer;
    }

    private void compress() {

    }

}