package com.nzzi.study.cos5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CosEx5 {
    public int solution(int[] enemies, int[] armies) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;

        List<Integer> armyList = Arrays.stream(armies).boxed().collect(Collectors.toList());
        List<Integer> enemyList = Arrays.stream(enemies).boxed().collect(Collectors.toList());

        for (Integer army : armyList) {
            for (Integer enemy : enemyList) {
                if (army >= enemy) {
                    answer++;
                    enemyList.remove(enemy);
                    break;
                }
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        CosEx5 sol = new CosEx5();
        int[] enemies1 = {1, 4, 3};
        int[] armies1 = {1, 3};
        int ret1 = sol.solution(enemies1, armies1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[] enemies2 = {1, 1, 1};
        int[] armies2 = {1, 2, 3, 4};
        int ret2 = sol.solution(enemies2, armies2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
