package com.nzzi.study.cos3;// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class CosEx5 {
    public String solution(String phrases, int second) {
        // 여기에 코드를 작성해주세요.
        String answer = "";

        second %= 28;

        String display = "______________" + phrases + "______________";
        answer = display.substring(second, second + 14);

//        int q = second / 14;
//        int r = second % 14;
//
//        if (q % 2 == 0) {
//            for (int i = 0; i < phrases.length() - r; i++) {
//                answer += "_";
//            }
//            for (int i = 0; i < r; i++) {
//                answer += phrases.charAt(i);
//            }
//        }
//        else {
//            for (int i = r; i < phrases.length(); i++) {
//                answer += phrases.charAt(i);
//            }
//            for (int i = 0; i < r; i++) {
//                answer += "_";
//            }
//        }

        return answer;
    }



    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        CosEx5 sol = new CosEx5();


        for (int i = 0; i < 50; i++) {
            String phrases = new String("happy-birthday");
            int second = i;
            String ret = sol.solution(phrases, second);
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
        }


    }
}