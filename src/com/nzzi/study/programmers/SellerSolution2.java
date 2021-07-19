package com.nzzi.study.programmers;

import java.util.HashMap;
import java.util.Map;

public class SellerSolution2 {

    int[] answer;
    Map<String, String> parentMap = new HashMap<>();
    Map<String, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"sam", "emily", "jaimie", "edward"};
        int[] amount = {2, 3, 5, 4};

        int[] answer = new SellerSolution2().solution(enroll, referral, seller, amount);
        for (int an : answer)
            System.out.print(an + " ");
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; ++i) {
            parentMap.put(enroll[i], referral[i]);
            indexMap.put(enroll[i], i);
        }
        for (int i = 0; i < seller.length; ++i)
            setProfit(seller[i], amount[i] * 100);
        return answer;
    }

    public void setProfit(String name, int profit) {
        answer[indexMap.get(name)] += profit - (profit / 10);
        String parentName = parentMap.get(name);
        if (!parentName.equals("-") && profit / 10 >= 1)
            setProfit(parentName, profit / 10);
    }
}
