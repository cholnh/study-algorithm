package com.nzzi.study.cos2;

public class CosEx5 {
    public int solution(int[] arr) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        int counter = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            int cur = arr[i];
            int next = arr[i+1];

            if (cur < next) {
                answer = Math.max(++counter, answer);
            } else {
                counter = 1;
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        CosEx5 sol = new CosEx5();
        int[] arr = {5,4,3,2,3,1,1};
        int ret = sol.solution(arr);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
