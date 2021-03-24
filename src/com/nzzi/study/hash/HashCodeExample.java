package com.nzzi.study.hash;

public class HashCodeExample {

    static int hashCode(String key) {
        int hash = 0;
        char[] ch = key.toCharArray();
        for (int i = 0; i < key.length(); i++) {
            hash = hash * 31 + ch[i];
        }
        return hash;
    }

}
