package com.nzzi.study.programmers;

public class Triangle {

    public static void main(String[] args) {
        int[][] arr = new  int[][]{
                {7},
                {3,8},
                {8,1,0},
                {2,7,4,4},
                {4,5,2,6,5}
        };
        System.out.println(new Triangle().solution(arr));
    }

    public int solution(int[][] triangle) {
        int answer = 0;

        int[] dp = new int[(triangle.length + 1) * triangle.length / 2];

        int cnt = 0;
        for (int depth = 1; depth <= triangle.length; ++depth) {
            int[] nodes = triangle[depth-1];
            for (int i = 0; i < nodes.length; ++i) {
                int node = nodes[i];
                if (i == 0)
                    dp[cnt] = dp[cnt-depth+1] + node;
                else if (i == nodes.length - 1)
                    dp[cnt] = dp[cnt-depth] + node;
                else
                    dp[cnt] = Math.max(dp[cnt-depth], dp[cnt-depth+1]) + node;

                if (depth == triangle.length)
                    answer = Math.max(answer, dp[cnt]);
                cnt++;
            }
        }

        return answer;
    }
}
