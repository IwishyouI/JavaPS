

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int arr[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] split = bf.readLine().split(" ");

         N = Integer.parseInt(split[0]);
         M = Integer.parseInt(split[1]);

        arr = new int[M];

        visited = new boolean[N+1];

        dfs(0);


    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val+ " ");
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