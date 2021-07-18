package com.nzzi.study.programmers;

import java.util.ArrayList;
import java.util.List;

public class SellerSolution {

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] answer = new SellerSolution().solution(enroll, referral, seller, amount);
        for (int an : answer)
            System.out.print(an + " ");
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        List<Seller> sellers = new ArrayList<>();

        for (int i = 0; i < enroll.length; i++) {
            String name = enroll[i];
            int sumOfAmount = 0;
            for (int j = 0; j < seller.length; j++) {
                if (seller[j].equals(name)) {
                    sumOfAmount += amount[j];
                }
            }
            sellers.add(Seller.of(name, sumOfAmount));
        }
        for (int i = 0; i < referral.length; i++) {
            String ref = referral[i];
            if (!ref.equals("-")) {
                Seller parent = findSeller(sellers, ref);
                parent.addChild(sellers.get(i));
            }
        }

        return sellers.stream()
                .mapToInt(Seller::getProfit)
                .toArray();
    }

    public Seller findSeller(List<Seller> sellers, String name) {
        for (Seller seller : sellers) {
            if (seller.getName().equals(name)) {
                return seller;
            }
        }
        return null;
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

        System.out.println(name + "'s raw profit : " + myProfit);

        int childrenInsentive = 0;
        for (Seller child : children) {
            System.out.print((child.getProfit()*0.1) + ", ");
            childrenInsentive += (int)(child.getProfit() * 0.1);
        }
        System.out.println();
        System.out.println(name + "'s final profit : " + (myProfit + childrenInsentive));
        System.out.println();
        return (int)((myProfit + childrenInsentive) * 0.9);
    }

}