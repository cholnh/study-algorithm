package com.nzzi.study.programmers;

public class Grid2 {
    public static void main(String[] args) {
        System.out.println(new Grid2().solution("ABABAAAAAAABA"));
    }

    public int solution(String name) {
        int answer = 0;
        boolean[] visited = new boolean[name.length()];

        for (int i = 0; i < visited.length; ++i)
            visited[i] = name.charAt(i) == 'A';

        int cur = 0;
        while (hasNext(visited)) {

            if (!visited[cur]) {
                visited[cur] = true;
                answer += howManyWordChanged(name.charAt(cur));
            }

            int left = leftIndex(cur, name.length());
            int right = rightIndex(cur, name.length());
            if (!visited[right]) {
                System.out.println("[1] move RIGHT");
                cur = right;
                answer++;
            }
            else if (!visited[left]) {
                System.out.println("[1] move LEFT");
                cur = left;
                answer++;
            }
            else {
                int step = cur, rStep = cur;
                for (int i = 0; i < name.length(); ++i) {
                    step = rightIndex(step, name.length());
                    rStep = leftIndex(rStep, name.length());
                    if (!visited[step]) {
                        System.out.println("[1] move RIGHT (..)");
                        cur = rightIndex(cur, name.length());
                        answer++;
                        break;
                    }
                    if (!visited[rStep]) {
                        System.out.println("[1] move LEFT (..)");
                        cur = leftIndex(cur, name.length());
                        answer++;
                        break;
                    }
                }

            }
        }
        return answer;
    }

    private int leftIndex(int cur, int length) {
        return cur == 0 ? length -1 : cur - 1;
    }

    private int rightIndex(int cur, int length) {
        return cur == length -1 ? 0 : cur + 1;
    }

    private boolean hasNext(boolean[] visited) {
        for (boolean v : visited)
            if (!v) return true;
        return false;
    }


//    public int solution(String name) {
//        int answer = 0;
//
//        String[] nameArray = name.split("");
//        int step = 0, reverseStep = 0;
//        for (int i = 1; i < nameArray.length; ++i) {
//            if (!nameArray[i].equals("A")) step = i;
//            if (!nameArray[nameArray.length-i].equals("A")) reverseStep = i;
//        }
//        answer += howManyWordChanged(name.charAt(0));
//
//        StringBuffer sb = new StringBuffer(name.substring(1));
//        name = step > reverseStep ? sb.reverse().toString() : sb.toString();
//
//        for (int i = 0; i < name.length(); ++i) {
//            if (isEnd(name.substring(i))) {
//                break;
//            }
//            System.out.println("[1] move " + (step > reverseStep ? "LEFT" : "RIGHT"));
//            answer++;
//            answer += howManyWordChanged(name.charAt(i));
//        }
//
//        return answer;
//    }

    private int howManyWordChanged(char alphabet) {
        if(alphabet == 'A') return 0;
        System.out.print("[" + Math.min(alphabet - 'A', 'Z' - alphabet + 1) + "] move " + (alphabet - 'A' < 'Z' - alphabet + 1 ? "UP" : "DOWN"));
        System.out.println(" A -> " + alphabet);
        return Math.min(alphabet - 'A', 'Z' - alphabet + 1);
    }

    private boolean isEnd(String tail) {
        boolean isValid = true;
        for (int i = 0; i < tail.length(); ++i) {
            if (tail.charAt(i) != 'A') {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
