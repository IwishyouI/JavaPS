

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
    static StringBuilder sb = new StringBuilder();

    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().split(" ");

        String[] secondLine = bf.readLine().split(" ");

        numbers = new int[secondLine.length];

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        for (int i = 0; i < secondLine.length; i++) {
            numbers[i] = Integer.parseInt(secondLine[i]);
        }
        Arrays.sort(numbers);
        arr = new int[M];
        dfs(0, 0);

        System.out.println(sb);

    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }


        for (int i = start; i < N; i++) {
            arr[depth] = numbers[i];
            dfs(start, depth + 1);
        }
    }

}