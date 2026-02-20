import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 친구 관계 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];

        // 모든 정점을 시작점으로 DFS 시도
        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            if (found) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    static void dfs(int node, int depth) {
        if (depth == 4) { // A-B-C-D-E
            found = true;
            return;
        }

        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                if (found) return; // 이미 찾았으면 더 볼 필요 없음
            }
        }

        visited[node] = false; // 백트래킹
    }
}