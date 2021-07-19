package com.nzzi.study.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerSolution {

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"mary", "young", "john", "tod", "emily", "mary", "emily"};
        int[] amount = {2, 12, 4, 2, 3, 8, 2};

        int[] answer = new SellerSolution().solution(enroll, referral, seller, amount);
        for (int an : answer)
            System.out.print(an + " ");
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        List<Seller> sellers = new ArrayList<>();

        Map<String, Integer> memberAmountMap = new HashMap<>();
        Map<String, Seller> memberIndexMap = new HashMap<>();

        for (int i = 0; i < seller.length; i++) {
            Integer memberAmount = memberAmountMap.get(seller[i]);
            memberAmountMap.put(seller[i], amount[i] + (memberAmount == null ? 0 : memberAmount));
        }

        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            Integer memberAmount = memberAmountMap.get(name);
            Seller s = Seller.of(name, memberAmount == null ? 0 : memberAmount);
            sellers.add(s);
            memberIndexMap.put(name, s);
        }
        for (int i = 0; i < referral.length; i++) {
            String ref = referral[i];
            if (!ref.equals("-")) {
                Seller parent = memberIndexMap.get(ref);
                parent.addChild(sellers.get(i));
            }
        }

        return sellers.stream()
                .mapToInt(Seller::getProfit)
                .toArray();
    }
}

class Seller {

    private String name;
    private int amount;
    private List<Seller> children = new ArrayList<>();

    private Seller(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public static Seller of(String name, int amount) {
        return new Seller(name, amount);
    }

    public void addChild(Seller child) {
        this.children.add(child);
    }

    public String getName() {
        return name;
    }

    public int getProfit() {
        int myProfit = this.amount * 100;

        int childrenInsentive = 0;
        for (Seller child : children) {
            int insen = child.getInsentive();
            childrenInsentive += insen < 1 ? 0 : insen;
        }
        myProfit += childrenInsentive;
        myProfit -= myProfit / 10;
        return myProfit;
    }

    public int getInsentive() {
        int myProfit = this.amount * 100;

        int childrenInsentive = 0;
        for (Seller child : children) {
            childrenInsentive += child.getInsentive();
        }
        myProfit += childrenInsentive;
        return myProfit / 10;
    }
}