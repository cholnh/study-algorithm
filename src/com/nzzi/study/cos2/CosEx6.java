package com.nzzi.study.cos2;

import java.util.Arrays;

public class CosEx6 {
    public int[] solution(String commands) {
        // 여기에 코드를 작성해주세요.
        int[] answer = {};

        int x = 0;
        int y = 0;
        for (int i = 0; i < commands.length(); i++) {
            switch (commands.charAt(i)+"") {
                case "U":
                    y++;
                    break;
                case "D":
                    y--;
                    break;
                case "L":
                    x--;
                    break;
                case "R":
                    x++;
                    break;
            }
        }

        answer = new int[2];
        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        CosEx6 sol = new CosEx6();
        String commands = "URDDL";
        int[] ret = sol.solution(commands);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
    }
}
