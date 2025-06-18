

import java.io.*;
import java.util.*;

public class Main {


    static int N;

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static boolean visited[][];
    static int arr[][];

    static List<Integer> aptSize = new ArrayList<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       N = sc.nextInt();

        arr = new int[N][N];
        visited = new boolean[N][N];



        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    int num = bfs(i, j);
                    aptSize.add(num);
                }
            }
        }

        Collections.sort(aptSize);
        System.out.println(aptSize.size());
        for (int val : aptSize) {
            System.out.println(val);
        }
    }


    static int bfs(int x, int y) {


        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;


        while (!queue.isEmpty()) {


            int[] node = queue.poll();

            int nowX = node[0];
            int nowY = node[1];


            for (int i = 0; i < 4; i++) {

                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < N && nextY < N && nextX >= 0 && nextY >= 0 && !visited[nextX][nextY] && arr[nextX][nextY] == 1) {

                    visited[nextX][nextY] = true;
                    arr[nextX][nextY] = arr[nowX][nowY] + 1;
                    queue.add(new int[]{nextX, nextY});
                    count += 1;
                }
            }
        }
        return count;
    }

}


