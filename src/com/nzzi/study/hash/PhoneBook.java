package com.nzzi.study.hash;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PhoneBook {
    public static void main(String[] args) {
        String[] books = {
                "12","123","1235","567","88"
        };
        System.out.println(new PhoneBook().solution(books));
    }

    public boolean solution(String[] phone_book) {
        Set<String> map = new HashSet<>(Arrays.asList(phone_book));
        for (String phone : phone_book)
            for (int i = 1; i < phone.length(); ++i)
                if (map.contains(phone.substring(0, i))) return false;
        return true;
    }
}
