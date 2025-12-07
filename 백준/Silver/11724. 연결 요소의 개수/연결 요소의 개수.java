

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static boolean visited[];
    static ArrayList<Integer>[] graph;


    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        graph = new ArrayList[N + 1];
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            String[] split = bf.readLine().split(" ");

            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);


            graph[x].add(y);
            graph[y].add(x);

        }

        int count = 0;

        for (int i = 1; i <= N; i++) {

            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }


    static void dfs(int x) {


        visited[x] = true;


        for (int next : graph[x]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }


}