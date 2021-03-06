package com.nzzi.study.cos4;

public class CosEx9 {
    public String solution(int hour, int minute) {
        // 여기에 코드를 작성해주세요.
        String answer = "";

        int minDeg = minute * 6;
        float hourDeg = hour * 30 + minute * 0.5f;

        answer = Math.abs(minDeg - hourDeg) + "";

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        CosEx9 sol = new CosEx9();
        int hour = 3;
        int minute = 0;
        String ret = sol.solution(hour, minute);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
