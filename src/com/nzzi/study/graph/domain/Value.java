package com.nzzi.study.graph.domain;

public class Value {
    private int c_lib;
    private int c_road;

    private Value() {}

    public static Value of(int c_lib, int c_road) {
        Value value = new Value();
        value.c_lib = c_lib;
        value.c_road = c_road;
        return value;
    }

    public int getCost(boolean isRoot) {
        return c_lib > c_road
                ? isRoot
                    ? c_lib
                    : c_road
                : c_lib;
    }
}
