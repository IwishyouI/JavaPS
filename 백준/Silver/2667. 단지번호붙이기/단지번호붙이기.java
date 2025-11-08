
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int houseCount = 0;

    static List<Integer> cityList = new ArrayList<>();


    static int[] dx = {-1, 1, 0, 0}; // 상, 하
    static int[] dy = {0, 0, -1, 1}; // 좌, 우
    static int N;

    static int map[][];

    static boolean visited[][];


    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        map = new int[N][N];

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {

                    houseCount = 0;
                    dfs(i, j);
                    cityList.add(houseCount);

                }
            }
        }

        Collections.sort(cityList);


        System.out.println(cityList.size());

        for (int arr : cityList) {
            System.out.println(arr);
        }
    }


    static void dfs(int x, int y) {
        visited[x][y] = true;
        houseCount++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];


            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }


}
