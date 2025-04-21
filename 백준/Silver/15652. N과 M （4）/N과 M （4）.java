
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    static int N;
    static int M;

    static int arr[];

    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] split = bf.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        arr = new int[M];

        visited = new boolean[N + 1];

        dfs(1, 0);

    }

    public static void dfs(int start, int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
                arr[depth] = i;
                dfs(i, depth + 1);
        }
        }


}