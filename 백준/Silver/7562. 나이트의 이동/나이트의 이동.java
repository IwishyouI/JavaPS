
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
        int N = Integer.parseInt(bf.readLine());


        while (N-- > 0) {

            int M = Integer.parseInt(bf.readLine().trim());
            StringTokenizer st = new StringTokenizer(bf.readLine().trim());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());


            st = new StringTokenizer(bf.readLine().trim());

            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());


            int result = bfs(M, startX, startY, targetX, targetY);
            sb.append(result).append('\n');
        }

        System.out.println(sb);


    }


    static int bfs(int M, int startX, int startY, int targetX, int targetY) {
        if (startX == targetX && startY == targetY) {
            return 0;
        }
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][M];

        queue.add(new Point(startX, startY, 0));

        visited[startX][startY] = true;

        while (!queue.isEmpty()) {

            Point p = queue.poll();

            for (int i = 0; i < 8; i++) {

                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < M && !visited[nx][ny]) {
                    if (nx == targetX && ny == targetY) {
                        return p.d + 1;
                    }
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, p.d + 1));
                }
            }
        }
        return -1;
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














