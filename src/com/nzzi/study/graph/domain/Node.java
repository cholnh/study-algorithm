package com.nzzi.study.graph.domain;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private int idx;
    private Value value;
    private boolean isVisited;
    private List<Node> neighbor = new ArrayList<>();

    public int getIdx() {
        return idx;
    }

    public Value getValue() {
        return value;
    }

    public List<Node> getNeighbor() { return neighbor; }

    public boolean isVisited() {
        return isVisited;
    }

    public static Node from(int idx) {
        Node node = new Node();
        node.isVisited = false;
        node.idx = idx;
        return node;
    }

    public static Node of(int idx, int c_lib, int c_road) {
        Node node = new Node();
        node.isVisited = false;
        node.idx = idx;
        node.value = Value.of(c_lib, c_road);
        return node;
    }

    public void addNeighbor(Node city) {
        if (neighbor == null) {
            neighbor = new ArrayList<>();
        }
        if (!neighbor.contains(city)) {
            neighbor.add(city);
        }
        if (!city.getNeighbor().contains(this)) {
            city.getNeighbor().add(this);
        }
    }

    public Node visit() {
        this.isVisited = true;
        return this;
    }

    @Override
    public String toString() {
        String ss = "";
        for (Node n : neighbor) {
            ss += "[idx: "+n.idx+", visited: " + n.isVisited + "] ";
        }
        return "Node{" +
                "idx=" + idx +
                ", isVisited=" + isVisited +
                ", neighbor=" + ss +
                '}';
    }
}
