

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int N, M;

    static int map[][];
    static boolean visited[][];


    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line = bf.readLine();

        String[] split = line.split(" ");

        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);


        visited = new boolean[N][M];

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String m = bf.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = m.charAt(j) - '0';

            }

        }


        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);

    }


    static void bfs(int x, int y) {


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;


        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            int cx = node[0];
            int cy = node[1];


            for (int i = 0; i < 4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {

                    visited[nx][ny] = true;
                    map[nx][ny] = map[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});

                }

            }

        }

    }


}