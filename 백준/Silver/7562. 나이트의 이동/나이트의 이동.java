

import java.io.*;
import java.util.*;

public class Main {

    // 나이트가 갈 수 있는 8개의 방향, 마치 체스판 위 춤추는 말처럼
    static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            // 체스판의 크기
            int N = Integer.parseInt(br.readLine().trim());

            // 나이트의 출발 위치
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            // 나이트의 목표 위치
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            // 나이트가 목표 지점까지 가는 데 걸리는 최소 이동 횟수 계산
            int result = bfs(N, startX, startY, targetX, targetY);
            sb.append(result).append('\n');
        }

        // 모든 테스트 케이스 결과 출력
        System.out.print(sb);
    }

    // BFS: 바람결처럼 넓게 퍼지는 나이트의 발걸음
    private static int bfs(int N, int sx, int sy, int tx, int ty) {
        // 시작 지점이 도착 지점과 같다면, 움직일 필요가 없지요
        if (sx == tx && sy == ty) return 0;

        boolean[][] visited = new boolean[N][N]; // 이미 다녀간 곳을 기억하는 흔적
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(sx, sy, 0)); // 시작점에서 시작
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // 나이트가 뻗어나갈 수 있는 8방향을 차례차례 탐색
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 체스판의 경계를 넘지 않고, 아직 방문하지 않은 곳이라면
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    // 목표 지점에 도달했을 때
                    if (nx == tx && ny == ty) {
                        return p.d + 1;
                    }

                    // 다음 발걸음을 큐에 담고, 방문 체크
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, p.d + 1));
                }
            }
        }

        return -1; // 이론상 도달하지 못하는 경우는 없지만, 혹시를 위해
    }

    // 한 걸음의 좌표와 거리 정보를 담은 따뜻한 그릇
    static class Point {
        int x, y, d;

        Point(int x, int y, int d) {
            this.x = x; // 가로 위치
            this.y = y; // 세로 위치
            this.d = d; // 시작점으로부터의 거리 (이동 횟수)
        }
    }
}
