package com.nzzi.study.cos1;

public class CosEx2 {
    public int solution(int n) {
        // Write code here.
        int answer = 0;

        int start = 1;

        while (n > 0) {
            answer += start + calculate(n, start);
            start = next(n, start);
            n -= 2;
        }

        return answer;
    }

    private int calculate(int n, int x) {
        if (n == 1)
            return 0;
        return 2*(n - 1) + x;
    }

    private int next(int n, int x) {
        return 4*(n - 1) + x;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {


        CosEx2 sol = new CosEx2();

        for (int i = 1; i < 1000; i++) {
            System.out.println("sol1] " + i + " => " + sol.solution(i));
            System.out.println();
        }

    }
}

//class Solution{
//    int[][] pane;
//    int dx[] = {0, 1, 0, -1};
//    int dy[] = {1, 0, -1, 0};
//    boolean inRange(int i, int j, int n){
//        return 0 <= i && i < n && 0 <= j && j < n;
//    }
//    public int solution(int n){
//        pane = new int[n][n];
//        int ci = 0;
//        int cj = 0;
//        int num = 1;
//        while(inRange(ci, cj, n) && pane[ci][cj] == 0){
//            for(int k = 0; k < 4; k++){
//                if(!inRange(ci, cj, n) || pane[ci][cj] != 0) break;
//                while(true){
//                    pane[ci][cj] = num++;
//                    int ni = ci + dy[k];
//                    int nj = cj + dx[k];
//                    if(!inRange(ni, nj, n) || pane[ni][nj] != 0){
//                        ci += dy[(k + 1) % 4];
//                        cj += dx[(k + 1) % 4];
//                        break;
//                    }
//                    ci = ni;
//                    cj = nj;
//                }
//            }
//        }
//        int ans = 0;
//        for(int i = 0; i < n; i++) ans += pane[i][i];
//        return ans;
//    }
//}
