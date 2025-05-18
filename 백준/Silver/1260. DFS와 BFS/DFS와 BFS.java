
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph; // 그래프 표현을 위한 인접 리스트
    static boolean[] visited; // 방문 여부 체크 배열
    static StringBuilder dfsResult = new StringBuilder(); // DFS 결과 저장
    static StringBuilder bfsResult = new StringBuilder(); // BFS 결과 저장

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int V = sc.nextInt(); // 탐색 시작 정점

        // 그래프 초기화 (1부터 N까지의 정점)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // 양방향 간선
            graph[a].add(b);
            graph[b].add(a);
        }

        // 정점 번호가 작은 것을 먼저 방문하기 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS 수행
        visited = new boolean[N + 1];
        dfs(V);

        // BFS 수행
        visited = new boolean[N + 1]; // 방문 배열 초기화
        bfs(V);

        // 결과 출력
        System.out.println(dfsResult.toString().trim());
        System.out.println(bfsResult.toString().trim());

        sc.close();
    }


    static void dfs(int node) {

        visited[node] = true;
        dfsResult.append(node).append(" ");
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);

            }
        }
    }


    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        bfsResult.append(start).append(" ");
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    bfsResult.append(next).append(" ");
                }
            }
        }
    }
}