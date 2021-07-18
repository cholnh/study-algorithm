package com.nzzi.study.programmers;

public class Matrix {

    public static void main(String[] args) {
        int[][] queries = {
                {2,2,5,4},
                {3,3,6,6,},
                {5,1,6,3}
        };
        new Matrix().solution(6, 6, queries);
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] matrix = makeMatrix(rows, columns);

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            answer[i] = getMinValueOfPartMatrix(query, matrix);
            rotate(query, matrix);
        }

        return answer;
    }

    public void print(int[][] matrix) {
        for (int[] m : matrix) {
            for (int v : m) {
                System.out.printf("%2d ", v);
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] makeMatrix(int r, int c) {
        int[][] matrix = new int[r][c];
        int count = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = count++;
            }
        }
        return matrix;
    }

    public int getMinValueOfPartMatrix(int[] query, int[][] matrix) {
        int min = Integer.MAX_VALUE;

        int startX = query[0]-1; // 2
        int startY = query[1]-1; // 2
        int endX = query[2]-1;    // 5
        int endY = query[3]-1;    // 4

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (i == startX || i == endX || j == startY || j == endY) {
                    min = Math.min(matrix[i][j], min);
                }
            }
        }

        return min;
    }

    public void rotate(int[] query, int[][] matrix) {
        int startX = query[0]-1;
        int startY = query[1]-1;
        int endX = query[2]-1;
        int endY = query[3]-1;

        int startTemp;
        int endTemp;

        // 1st
        endTemp = matrix[startX][endY];
        for (int j = endY; j >= startY + 1; j--) {
            matrix[startX][j] = matrix[startX][j-1];
        }

        // 2nd
        startTemp = matrix[endX][endY];
        for (int i = endX; i >= startX + 1; i--) {
            matrix[i][endY] = matrix[i-1][endY];
        }
        matrix[startX+1][endY] = endTemp;

        // 3rd
        endTemp = matrix[endX][startY];
        for (int j = startY; j < endY - 1; j++) {
            matrix[endX][j] = matrix[endX][j+1];
        }
        matrix[endX][endY-1] = startTemp;

        // 4th
        for (int i = startX; i < endX - 1; i++) {
            matrix[i][startY] = matrix[i+1][startY];
        }
        matrix[endX-1][startY] = endTemp;
    }
}
