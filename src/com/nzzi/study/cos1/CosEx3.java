package com.nzzi.study.cos1;

public class CosEx3 {
    public int solution(String pos) {
        // Write code here.
        int answer = 0;

        int x = 0;
        int y = Integer.parseInt(pos.charAt(1)+"");


        switch (pos.charAt(0)) {
            case 65: x = 1; break;
            case 66: x = 2; break;
            case 67: x = 3; break;
            case 68: x = 4; break;
            case 69: x = 5; break;
            case 70: x = 6; break;
            case 71: x = 7; break;
            case 72: x = 8; break;
        }

        answer = Pos.of(x, y).getValue();

        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        CosEx3 sol = new CosEx3();


        for(int i = 1; i < 9; i ++) {
            String pos = "H";

            int ret = sol.solution(pos+i);

            // Press Run button to receive output.
            System.out.println((pos+i) + " " + ret + " .");
        }


    }
}
class Pos {

    private int x;
    private int y;

    private Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getValue() {
        if (x == 1 && y == 1)
            return 2;
        if (x == 2 && y == 2)
            return 4;
        if (x >= 3 && y >= 3)
            return 8;
        if (x == 1 && y == 2)
            return 3;
        if (x == 1 && y >= 3)
            return 4;
        if (x == 2 && y >= 3)
            return 6;
        return 0;
    }

    public static Pos of(int x, int y) {
        if (x > 4) {
            x = 9 - x;
        }
        if (y > 4) {
            y = 9 - y;
        }

        if (x > y) {
            int swap = x;
            x = y;
            y = swap;
        }

        return new Pos(x, y);
    }
}