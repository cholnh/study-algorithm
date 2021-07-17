package com.nzzi.study.cos4;

import java.util.*;
import java.util.stream.Collectors;

public class CosEx8 {

    Set<Integer> set = new HashSet<>();

    public int solution(int[] card, int n) {
        // 여기에 코드를 작성해주세요.
        int answer = -1;

        permutation(card, 0, 4, 4);

        List<Integer> list = set.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            if (n == list.get(i)) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    public void permutation(int[] array, int depth, int n, int r) {
        if (depth == r) {
            String str = "";
            for (int i = 0; i < r; i++)
                str += array[i];
            set.add(Integer.parseInt(str));
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(array, depth, i);
            permutation(array, depth + 1, n, r);
            swap(array, depth, i);
        }
    }

    private void swap(int[] array, int arg1, int arg2) {
        int temp = array[arg1];
        array[arg1] = array[arg2];
        array[arg2] = temp;
    }



    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        CosEx8 sol = new CosEx8();
        int card1[] = {1, 2, 1, 3};
        int n1 = 1312;
        int ret1 = sol.solution(card1, n1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int card2[] = {1, 1, 1, 2};
        int n2 = 1122;
        int ret2 = sol.solution(card2, n2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
