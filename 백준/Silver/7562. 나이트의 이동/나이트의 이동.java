

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine()); // 테스트 케이스 개수

        while (N-- > 0) {
            int T = Integer.parseInt(bf.readLine()); // 체스판 크기

            String[] split = bf.readLine().split(" ");
            int startX = Integer.parseInt(split[0]);
            int startY = Integer.parseInt(split[1]);

            String[] split2 = bf.readLine().split(" ");
            int targetX = Integer.parseInt(split2[0]);
            int targetY = Integer.parseInt(split2[1]);

            int result = bfs(T, startX, startY, targetX, targetY);
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(int N, int startX, int startY, int targetX, int targetY) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        visited[startX][startY] = true;
        queue.add(new Point(startX, startY, 0));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            // 목표 지점 도착
            if (p.x == targetX && p.y == targetY) {
                return p.d;
            }

            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, p.d + 1));
                }
            }
        }
        return -1; // 도달 불가능한 경우
    }

    static class Point {
        int x, y, d;
        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
