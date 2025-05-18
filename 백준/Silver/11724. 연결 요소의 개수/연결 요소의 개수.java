import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph; // 그래프 표현을 위한 인접 리스트
    static boolean[] visited; // 방문 여부 체크 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수

        // 그래프 초기화 (1부터 N까지의 정점)
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            // 양방향 간선
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N + 1]; // 방문 배열 초기화
        int count = 0; // 연결 요소의 개수

        // 모든 정점을 확인
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 아직 방문하지 않은 정점이라면
                dfs(i); // DFS 수행
                count++; // 연결 요소 개수 증가
            }
        }

        // 결과 출력
        System.out.println(count);

        sc.close();
    }

    // DFS 구현
    static void dfs(int node) {
        visited[node] = true; // 현재 노드 방문 처리

        // 인접한 노드 중 방문하지 않은 노드를 재귀적으로 방문
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}