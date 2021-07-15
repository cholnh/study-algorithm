package com.nzzi.study.combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationModule<T> {

    private List<T> list;

    private CombinationModule() {
    }

    private CombinationModule(List<T> list) {
        this();
        this.list = list;
    }

    public static CombinationModule of(List list) {
        return new CombinationModule(list);
    }

    public void combine(int n, int r) {
        boolean[] visited = new boolean[list.size()];
        innerRecursiveMethod(0, n, r, visited);
    }

    private void innerRecursiveMethod(int start, int n, int r, boolean[] visited) {
        if(r == 0) {
            for (int i = 0; i < n; i++)
                if (visited[i])
                    System.out.print(list.get(i) + " ");
            System.out.println();
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            innerRecursiveMethod(i + 1, n, r - 1, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        CombinationModule
                .of(list)
                .combine(6, 3);
    }
}
