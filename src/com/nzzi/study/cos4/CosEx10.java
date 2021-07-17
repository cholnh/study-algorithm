package com.nzzi.study.cos4;

import java.util.ArrayList;
import java.util.List;

public class CosEx10 {

    public List<Integer> getPrime(int a, int b) {

        List<Integer> result = new ArrayList<>();
        List<Boolean> primeBucket = new ArrayList<>();
        primeBucket.add(false);
        primeBucket.add(false);
        for (int i = 2; i <= b; i++)
            primeBucket.add(true);

        for (int i = 2; i <= Math.sqrt(b); i++) {
            if (primeBucket.get(i)) {
                for (int j = i*i; j <= b; j += i) {
                    primeBucket.set(j, false);
                }
            }
        }

        for (int i = a; i < primeBucket.size(); i++) {
            if (primeBucket.get(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public int solution(int a, int b) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;


        for (int i = 2; i < Math.sqrt(b); i++) {
            if (isPrime(i)) {
                double pow2 = Math.pow(i, 2);
                double pow3 = Math.pow(i, 3);

                if (isValidRange(pow2, a, b)) {
                    answer++;
                }
                if (isValidRange(pow3, a, b)) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public boolean isValidRange(double n, int a, int b) {
        return n >= a && n <= b;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args){
        CosEx10 sol = new CosEx10();
        int a = 6;
        int b = 30;
        int ret = sol.solution(a, b);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
