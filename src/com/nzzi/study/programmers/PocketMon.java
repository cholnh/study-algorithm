package com.nzzi.study.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class PocketMon {
    public int solution(int[] nums) {
        Set<Integer> typeSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Math.min(typeSet.size(), nums.length/2);
    }
}
