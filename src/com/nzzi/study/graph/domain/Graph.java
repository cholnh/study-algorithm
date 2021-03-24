package com.nzzi.study.graph.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiFunction;

public class Graph {

    private List<Node> graph;

    private Graph(List<Node> graph) {
        this.graph = graph;
    }

    public static Graph of(int n, int c_lib, int c_road, int[][] cities) {
        return new Graph(convertArrayToList(n, c_lib, c_road, cities));
    }

    public static Graph of(int n, int[][] astronaut) {
        return new Graph(convertArrayToList(n, astronaut));
    }

    private static List<Node> convertArrayToList(int n, int[][] astronaut) {
        List<Node> list = new ArrayList<>(n);

        return list;
    }

    private static List<Node> convertArrayToList(int n, int c_lib, int c_road, int[][] cities) {
        List<Node> cityList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            Node city = Node.of(i + 1, c_lib, c_road);
            cityList.add(city);
        }

        for (int[] section : cities) {
            Node city = cityList.get(section[0] - 1);
            Node neighbor = cityList.get(section[1] - 1);

            city.addNeighbor(neighbor);
            neighbor.addNeighbor(city);
        }

        return cityList;
    }

    public long dfs(BiFunction<Node, Boolean, Long> visitor) {
        long sum = 0;
        for (Node city : graph) {
            if (city.isVisited()) continue;

            sum += dfsRecursiveMethod(city, visitor, true);
        }
        return sum;
    }

    private long dfsRecursiveMethod(Node root, BiFunction<Node, Boolean, Long> visitor, boolean isRoot) {
        long sum = 0;
        if (root.isVisited()) return sum;

        root.visit();
        sum += visitor.apply(root, isRoot);

        for (Node city : root.getNeighbor()) {
            sum += dfsRecursiveMethod(city, visitor, false);
        }

        return sum;
    }

    public long bfs(BiFunction<Node, Node, Long> visitor) {
        long sum = 0;

        for (Node city : graph) {
            if (city.isVisited()) continue;

            Queue<Node> queue = new LinkedList<>();
            queue.add(city);

            while (!queue.isEmpty()) {
                Node next = queue.poll();

                if (next.isVisited()) continue;
                next.visit();
                sum += visitor.apply(next, city);

                queue.addAll(next.getNeighbor());
            }
        }

        return sum;
    }
}
