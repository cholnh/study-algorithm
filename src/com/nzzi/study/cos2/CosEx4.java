package com.nzzi.study.cos2;

public class CosEx4 {
    public int solution(int[] arr, int K) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    // System.out.println("[" + arr[i] + ", " + arr[j] + ", " + arr[k] + "]");
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum % K == 0)
                        answer++;
                }
            }
        }

        combine(arr, arr.length, 3, K);

        return answer;
    }

    private void combine(int[] arr, int n, int r, int K) {
        boolean[] visited = new boolean[arr.length];
        recursive(arr, 0, n, r, visited, K);
    }

    private void recursive(int[] arr, int start, int n, int r, boolean[] visited, int K) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i])
                    sum += arr[i];
            }
            if (sum % K == 0)
                System.out.println("gotta");
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            recursive(arr, i+1, n, r-1, visited, K);
            visited[i] = false;
        }
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        CosEx4 sol = new CosEx4();
        int[] arr = {1, 2, 3, 4, 5, 6};
        int K = 3;
        int ret = sol.solution(arr, K);


        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}