import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean visited[];
    static int nums[];
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        nums = new int[M];

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int start, int depth) {


        if (depth == M) {

            for (int i = 0; i < M; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for (int i = start; i < N; i++) {
            int now = arr[i];
            if (before == now || visited[i]) {
                continue;
            } else {
                before = now;
                visited[i] = true;
                nums[depth] = arr[i];
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}