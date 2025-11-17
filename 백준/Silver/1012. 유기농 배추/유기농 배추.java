
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int T;

    static int M, N, K;

    static boolean visited[][];

    static int map[][];

    static int count;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    static List<Integer> list;

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());


        while (T-- > 0) {
            String[] split = bf.readLine().split(" ");

            M = Integer.parseInt(split[0]);
            N = Integer.parseInt(split[1]);
            K = Integer.parseInt(split[2]);

            map = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            list = new ArrayList<>();

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());

                int L = Integer.parseInt(st.nextToken());
                int H = Integer.parseInt(st.nextToken());

                map[H][L] = 1;

            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            list.add(count);

            Collections.sort(list);



            for (int num : list) {
                System.out.println(num);
            }


        }


    }


    static void dfs(int x, int y) {

        visited[x][y] = true;


        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1 && !visited[nx][ny]) {

                dfs(nx, ny);

            }
        }

    }

}
