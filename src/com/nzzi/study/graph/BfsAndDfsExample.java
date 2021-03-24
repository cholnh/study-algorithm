package com.nzzi.study.graph;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BfsAndDfsExample {

    public void run() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));
        Scanner scanner = new Scanner(new File("input"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

    private int[] bfs(int n, int m, int[][] edges, int s) {

        Graph graph = Graph.of(n, edges);
        int[] arr = graph.dfs(s);
        System.out.print("result : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        return arr;
    }

}

class Graph {

    private List<Node> graph;

    private Graph(List<Node> graph) {
        this.graph = graph;
    }

    public static Graph of(int n, int[][] array) {
        return new Graph(convertArrayToList(n, array));
    }

    private static List<Node> convertArrayToList(int n, int[][] array) {
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Node node = Node.from(i + 1);
            list.add(node);
        }

        for (int[] section : array) {
            Node root = list.get(section[0] - 1);
            Node neighbor = list.get(section[1] - 1);

            root.addNeighbor(neighbor);
        }

        return list;
    }

    public int[] dfs(int s) {
        Node start = graph.get(s - 1);
        start.setCost(-1);

        dfsRecursiveMethod(start, 0);

        int[] arr = new int[graph.size() - 1];
        for (int i = 1; i < graph.size(); i++) {
            arr[i - 1] = graph.get(i).getCost();
        }

        return arr;
    }

    private void dfsRecursiveMethod(Node root, int level) {
        if (root.isVisited()) return;
        root.visit();
        root.setCost(level == 0 ? -1 : level * 6);

        for (Node neighbor : root.getNeighbor()) {
            if (neighbor.isVisited()) continue;
            dfsRecursiveMethod(neighbor, level + 1);
        }
    }

    public int[] bfs(int s) {

        Node start = graph.get(s - 1);
        start.setCost(-1);

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node next = queue.poll();

            if (next.isVisited()) continue;
            next.visit();

            for (Node neighbor : next.getNeighbor()) {
                if (neighbor.isVisited()) continue;

                neighbor.setCost(next.getCost() == -1 ? 6 : next.getCost() + 6);
                queue.add(neighbor);
            }
        }

        int[] arr = new int[graph.size() - 1];
        for (int i = 1; i < graph.size(); i++) {
            arr[i - 1] = graph.get(i).getCost();
        }

        return arr;
    }
}

class Node {
    private int idx;
    private boolean isVisited;
    private List<Node> neighbor = new ArrayList<>();

    private int cost;

    public int getIdx() {
        return idx;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    private Node() {
        this.isVisited = false;
        this.cost = -1;
    }

    private Node(int idx) {
        this();
        this.idx = idx;
    }

    public static Node from(int idx) {
        return new Node(idx);
    }

    public List<Node> getNeighbor() { return neighbor; }

    public boolean isVisited() {
        return isVisited;
    }

    public Node addNeighbor(Node root) {
        if (neighbor == null) {
            neighbor = new ArrayList<>();
        }
        if (!neighbor.contains(root)) {
            neighbor.add(root);
        }
        if (!root.getNeighbor().contains(this)) {
            root.getNeighbor().add(this);
        }
        return this;
    }

    public Node visit() {
        this.isVisited = true;
        return this;
    }
}
