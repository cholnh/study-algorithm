package com.nzzi.study.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid1 {

    public static void main(String[] args) {
        int n = 3;
        int[] lost = {1,3};
        int[] reserve = {1,2};
        System.out.println(new Grid1().solution(n, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        List<Integer> newLost = new ArrayList<>();
        Map<Integer, Integer> reserveMap = new HashMap<>();
        for (int studentId : reserve) reserveMap.put(studentId, 1);
        for (int studentId : lost) {
            if (reserveMap.getOrDefault(studentId, 0) > 0)
                reserveMap.replace(studentId, 0);
            else
                newLost.add(studentId);
        }
        for (int studentId : newLost) {
            int front = reserveMap.getOrDefault(studentId-1, 0);
            int back = reserveMap.getOrDefault(studentId+1, 0);
            if (front > 0 || back > 0) {
                answer++;
                reserveMap.replace(studentId + (front > 0 ? -1 : 1), 0);
            }
        }
        return answer - newLost.size();
    }
}
