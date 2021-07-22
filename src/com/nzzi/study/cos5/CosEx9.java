package com.nzzi.study.cos5;

import java.util.*;

public class CosEx9 {

    public int newSolution(int number, int target) {
        if (number == target) return 0;

        int depth = 1;
        List<Set<Integer>> dp = new ArrayList<>();
        Set<Integer> first = new HashSet<>();
        first.add(number);
        dp.add(0, new HashSet<>());
        dp.add(1, first);

        while (true) {
            Set<Integer> newSet = new HashSet<>();
            Set<Integer> preSet = dp.get(depth);
            for (Integer preNode : preSet) {
                for (int type = 1; type <= 3; ++type) {
                    int value = 0;
                    switch (type) {
                        case 1: value = preNode + 1; break;
                        case 2: value = preNode - 1; break;
                        case 3: value = preNode * 2; break;
                    }
                    if (value == target) return depth;
                    else newSet.add(value);
                }
            }
            dp.add(newSet);
            depth++;
        }
    }

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
        int number1 = 3;
        int target1 = 3;
        int ret1 = sol.solution(number1, target1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        System.out.println("solution 메소드의 반환 값은 " + sol.ss1(number1, target1) + " 입니다.");
        System.out.println("solution 메소드의 반환 값은 " + sol.ss2(number1, target1) + " 입니다.");
        System.out.println("newSolution 메소드의 반환 값은 " + sol.newSolution(number1, target1) + " 입니다.");

        System.out.println();

        int number2 = 3;
        int target2 = 30;
        int ret2 = sol.solution(number2, target2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
        System.out.println("solution 메소드의 반환 값은 " + sol.ss1(number2, target2) + " 입니다.");
        System.out.println("solution 메소드의 반환 값은 " + sol.ss2(number2, target2) + " 입니다.");
        System.out.println("newSolution 메소드의 반환 값은 " + sol.newSolution(number2, target2) + " 입니다.");

    }
}
