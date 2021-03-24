package com.nzzi.study.graph.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

public class Graph2 {

    private List<Node> graph;

    private Graph2(List<Node> graph) {
        this.graph = graph;
    }

    public List<Node> getGraph() {
        return graph;
    }

    public static Graph2 of(int n, int[][] astronaut) {
        return new Graph2(convertArrayToList(n, astronaut));
    }

    private static List<Node> convertArrayToList(int n, int[][] astronaut) {
        List<Node> list = new ArrayList<>(n);

        for (int i = 0; i < n ; i++) {
            Node node = Node.from(i);
            list.add(node);
        }

        for (int[] section : astronaut) {
            Node root = list.get(section[0]);
            Node neighbor = list.get(section[1]);

            root.addNeighbor(neighbor);
        }

        return list;
    }

    public long dfs() {
        long sum = 0;
        int countVisited = 0;

        for (Node city : graph) {
            if (city.isVisited()) continue;

            int size = dfsRecursiveMethod(city);
            sum += (graph.size() - size - countVisited) * size;
            countVisited += size;
        }
        return sum;
    }

    private int dfsRecursiveMethod(Node root) {
        int sum = 1;
        if (root.isVisited()) return 0;

        root.visit();

        for (Node city : root.getNeighbor()) {
            sum += dfsRecursiveMethod(city);
        }

        return sum;
    }

    public int bfs(Function<Node, Integer> visitor) {
        int sum = 0;

        for (Node city : graph) {
            if (city.isVisited()) continue;

            Queue<Node> queue = new LinkedList<>();
            queue.add(city);

            while (!queue.isEmpty()) {
                Node next = queue.poll();

                if (next.isVisited()) continue;
                next.visit();
                sum += visitor.apply(next);

                queue.addAll(next.getNeighbor());
            }
        }

        return sum;
    }
}
