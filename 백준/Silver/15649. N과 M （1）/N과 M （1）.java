

import java.util.Scanner;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];        // 수열을 저장할 배열
        visited = new boolean[N+1]; // 방문 여부 체크

        dfs(0);
        sc.close();
    }

    // 간단한 DFS로 구현
    static void dfs(int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");

            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }

    }
}