package com.nzzi.study.string;

import java.util.ArrayList;
import java.util.List;

public class StringCompressionExample {

    public static void main(String...args) {
        System.out.println(new StringCompressionExample().solution("a"));
    }

    class SubString{
        private String value;
        private int count;
        public SubString(String value) {
            this.value = value;
            this.count = 1;
        }
        public boolean equals(String str) {
            return this.value.equals(str);
        }
        public void plus() {
            this.count++;
        }
        public int getCompressionCount() {
            int p = (int) Math.log10(count) + 1;
            return value.length() + (count > 1 ? p : 0);
        }

        @Override
        public String toString() {
            return count + value;
        }
    }

    public int solution(String word) {
        int answer = Integer.MAX_VALUE;
        if (word.length() == 1) return 1;
        for (int dUnit = 1; dUnit <= word.length() / 2; ++dUnit) {
            List<SubString> subStrings = new ArrayList<>();
            int index = dUnit;
            while (index <= word.length()) {
                String part = word.substring(index-dUnit, index);
                if (index == dUnit)
                    subStrings.add(new SubString(part));
                else {
                    SubString last = subStrings.get(subStrings.size()-1);
                    if (last.equals(part))
                        last.plus();
                    else
                        subStrings.add(new SubString(part));
                }
                index += dUnit;
            }
            int count = 0;
            for (SubString subString : subStrings)
                count += subString.getCompressionCount();
            count += word.length()-(index-dUnit);
            System.out.println("dUnit: " + dUnit);
            System.out.println(subStrings);
            System.out.println(count + " (" + (word.length()-(index-dUnit)) + ")");
            System.out.println();
            answer = Math.min(answer, count);
        }
        return answer;
    }
}