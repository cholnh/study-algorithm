package com.nzzi.study.cos3;
import java.util.*;

public class CosEx3 {
    public int solution(String[] bishops) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;

        boolean[][] arr = new boolean[9][9];

        for (String bishop : bishops) {
            Point bishopPoint = convert(bishop);
            arr = setBishopMove(arr, bishopPoint);
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (!arr[i][j])
                    answer++;
            }
        }

        return answer;
    }

    private boolean[][] setBishopMove(boolean[][] arr, Point bishopPoint) {
        int x = bishopPoint.x;
        int y = bishopPoint.y;

        // left, down
        do {
            arr[x--][y--] = true;
        } while (x >= 1 && y >= 1);

        // left, up
        x = bishopPoint.x;
        y = bishopPoint.y;
        do {
            arr[x--][y++] = true;
        } while (x >= 1 && y <= 8);

        // right, down
        x = bishopPoint.x;
        y = bishopPoint.y;
        do {
            arr[x++][y--] = true;
        } while (x <= 8 && y >= 1);

        // right, up
        x = bishopPoint.x;
        y = bishopPoint.y;
        do {
            arr[x++][y++] = true;
        } while (x <= 8 && y <= 8);

        return arr;
    }

    private Point convert(String str) {
        Point point = new Point();
        point.x = Integer.parseInt((str.charAt(0) - 64) + "");
        point.y = Integer.parseInt(str.charAt(1) + "");
        return point;
    }

    class Point {
        int x;
        int y;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        CosEx3 sol = new CosEx3();
        String[] bishops1 = {new String("D5")};
        int ret1 = sol.solution(bishops1);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        String[] bishops2 = {new String("D5"), new String("E8"), new String("G2")};
        int ret2 = sol.solution(bishops2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}