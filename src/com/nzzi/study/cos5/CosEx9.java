package com.nzzi.study.cos5;

import java.util.LinkedList;
import java.util.Queue;

public class CosEx9 {
    public int solution(int number, int target) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;

        int[] dp = new int[target+target+1];

        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;

        for (int i = 1; i <= number; i++) {
            dp[i] = number - i;
            dp[i*2] = dp[i] + 1;
        }

        dp[number+1] = 1;

        for (int i = number + 2; i <= target; i++) {
            int min = i % 2 == 0 && i/2 >= number
                    ? Math.min(dp[i-1]+1, dp[i/2]+1)
                    : dp[i-1]+1;

            if (dp[i+1] != -1) {
                min = Math.min(min, dp[i+1]+1);
            }

            if (dp[i] != -1) {
                min = Math.min(min, dp[i]);
            }

            dp[i] = min;
            dp[i*2] = min + 1;
        }

        return dp[target];
    }

    public int ss1(int number, int target) {
        int answer = 0;

        while(number != target) {
            if(number < target) {
                if(number * 2 < target || number * 2 - (number - 1) < target ) number *= 2;
                else number++;
            } else if(target == number) break;
            else number--;

            answer++;
        }

        return answer;
    }

    public int ss2(int number, int target) {
        int answer = 0;

        int[] visited = new int[10001];
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(number);
        visited[number] = 1;

        while(!q.isEmpty()) {
            int x = q.poll();

            if(x == target)
                break;

            if(x+1 <= 10000 && visited[x+1] == 0) {
                visited[x+1] = visited[x]+1;
                q.offer(x+1);
            }
            if(x-1 >= 0 && visited[x-1] == 0) {
                visited[x-1] = visited[x]+1;
                q.offer(x-1);
            }
            if(2*x <= 10000 && visited[2*x] == 0) {
                visited[2*x] = visited[x]+1;
                q.offer(2*x);
            }
        }

        answer = visited[target]-1;
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        CosEx9 sol = new CosEx9();
        int number1 = 11;
        int target1 = 5877;
        int ret1 = sol.solution(number1, target1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        System.out.println("solution 메소드의 반환 값은 " + sol.ss1(number1, target1) + " 입니다.");
        System.out.println("solution 메소드의 반환 값은 " + sol.ss2(number1, target1) + " 입니다.");

        int number2 = 3;
        int target2 = 30;
        int ret2 = sol.solution(number2, target2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
        System.out.println("solution 메소드의 반환 값은 " + sol.ss1(number2, target2) + " 입니다.");
        System.out.println("solution 메소드의 반환 값은 " + sol.ss2(number2, target2) + " 입니다.");

    }
}
