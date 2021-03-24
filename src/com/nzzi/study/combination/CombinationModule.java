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

    public List<T> combine(int n, int r) {
        List<T> result = new ArrayList<>();
        boolean[] visited = new boolean[list.size()];
        innerRecursiveMethod(result, 0, n, r, visited);
        return result;
    }

    private void innerRecursiveMethod(List<T> result, int start, int n, int r, boolean[] visited) {
        if(r == 0) {
            for (int i = 0; i < n; i++)
                if (visited[i])
                    result.add(list.get(i));
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            innerRecursiveMethod(result, i + 1, n, r - 1, visited);
            visited[i] = false;
        }
    }
}
