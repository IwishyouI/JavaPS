

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        visited = new boolean[N + 1];

        dfs(1,0);

    }


    static void dfs(int start, int depth) {

        if (depth == M) {
            for (int next : arr) {
                System.out.print(next + " ");
            }
            System.out.println();
            return;
        }


        for (int i = start; i <= N; i++) {

            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(i,depth + 1);
                visited[i] = false;
            }
        }
    }


}