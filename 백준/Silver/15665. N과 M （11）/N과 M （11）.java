
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int N, M;

    static int arr[];

    static int selected[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] split = bf.readLine().split(" ");
        String[] secondLine = bf.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        arr = new int[N];

        selected = new int[M];


        for (int i = 0; i < secondLine.length; i++) {
            arr[i] = Integer.parseInt(secondLine[i]);

        }

        Arrays.sort(arr);
 

        dfs(0);

        System.out.println(sb);

    }


    static void dfs(int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }

            sb.append("\n");
            return;
        }


        int before = -1;

        for (int i = 0; i < N; i++) {

            int now = arr[i];
            if (before == now) {
                continue;
            } else {

                before = now;
                selected[depth] = arr[i];
                dfs(depth+ 1);

            }


        }

    }

}