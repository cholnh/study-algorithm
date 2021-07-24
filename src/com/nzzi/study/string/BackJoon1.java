package com.nzzi.study.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BackJoon1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BackJoon1 main = new BackJoon1();
        while (true) {
            String str = sc.nextLine();
            if (str.equals("#")) break;
            System.out.println(main.solution(str));
        }
    }
    public int solution(String str) {
        int answer = 0;
        Map<Character, Boolean> charMap = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ++ch)
            charMap.put(ch, false);
        for (int i = 0; i < str.length(); ++i)
            charMap.replace(Character.toLowerCase(str.charAt(i)), true);
        for (Character key : charMap.keySet())
            answer += charMap.get(key) ? 1 : 0;
        return answer;
    }
}
