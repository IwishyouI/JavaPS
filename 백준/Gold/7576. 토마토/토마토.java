import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int N, M;


    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    static int arr[][];

    static int days[][];


    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();


        arr = new int[N][M];

        days = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                result = Math.max(result, days[i][j]);
            }
        }

        System.out.println(result);

    }


    static void bfs() {


        while (!queue.isEmpty()) {

            int[] node = queue.poll();

            int nowX = node[0];
            int nowY = node[1];


            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {

                    if (arr[nextX][nextY] == 0) {
                        arr[nextX][nextY] = 1;
                        days[nextX][nextY] = days[nowX][nowY] + 1;

                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }

        }
    }


}


