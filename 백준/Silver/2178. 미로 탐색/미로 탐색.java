

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int N, M;

    static int map[][];

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    static boolean visited[][];


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';

            }
        }

        int result = bfs(0, 0, 1);
        System.out.println(result);

    }


    static int bfs(int x, int y, int d) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y, d});
        visited[x][y] = true;


        while (!queue.isEmpty()) {

            int[] node = queue.poll();

            int currentX = node[0];
            int currentY = node[1];
            int currentD = node[2];

            if (currentX == N - 1 && currentY == M - 1) {
                return currentD;
            }
            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, currentD + 1});
                    }
                }
            }

        }
        return -1;

    }

}