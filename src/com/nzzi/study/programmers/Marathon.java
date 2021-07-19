package com.nzzi.study.programmers;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Marathon {

    public static void main(String[] args) {
        String[] participant = {"k", "a", "b", "k"};
        String[] completion = {"a", "k", "b"};
        System.out.println(new Marathon().solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : participant) map.put(p, map.getOrDefault(p, 0) + 1);
        for (String c : completion) map.put(c, map.getOrDefault(c, 0) - 1);
        return map.keySet().stream().filter(s -> map.get(s) >= 1).collect(Collectors.joining());
    }
}
