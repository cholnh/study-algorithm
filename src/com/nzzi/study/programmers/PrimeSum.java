package com.nzzi.study.programmers;


import java.util.HashMap;
import java.util.Map;

public class PrimeSum {

    private Map<Integer, Boolean> primeBucket = new HashMap<>();
    private int answer = 0;

    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        new PrimeSum().solution(nums);
    }

    public int solution(int[] nums) {
        makePrimeBucket();
        //combination(nums, 0, 3, new boolean[nums.length]);

        for (int i = 0; i < nums.length; ++i)
            for (int j = i+1; j < nums.length; ++j)
                for (int k = j+1; k < nums.length; k++)
                    if (primeBucket.get(nums[i] + nums[j] + nums[k]))
                        answer++;





        return answer;
    }

//    private void combination(int[] arr, int start, int r, boolean[] visited) {
//        if (r == 0) {
//            int sum = 0;
//            for (int i = 0; i < arr.length; ++i)
//                if (visited[i]) sum += arr[i];
//            if (primeBucket.get(sum))
//                answer++;
//        }
//        for (int i = start; i < arr.length; ++i) {
//            visited[i] = true;
//            combination(arr, i+1, r-1, visited);
//            visited[i] = false;
//        }
//    }

    private void makePrimeBucket() {
        int max = 3000;
        primeBucket.put(0, false);
        primeBucket.put(1, false);
        for (int i = 2; i < max; ++i)
            primeBucket.put(i, true);
        for (int i = 2; i < Math.sqrt(max); ++i) {
            for (int j = i*i; j < max; j += i)
                primeBucket.put(j, false);
        }
    }
}
