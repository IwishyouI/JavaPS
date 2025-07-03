import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int max = 0;

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                board[i][j] = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, board[i][j], 1);
                visited[i][j] = false;
                checkExtraShape(i, j); // 'ㅗ', 'ㅜ', 'ㅏ', 'ㅓ' 모양
            }
        }

        System.out.println(max);
    }

    // DFS로 길이 4짜리 도형 찾기
    static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + board[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    // 'ㅗ', 'ㅜ', 'ㅏ', 'ㅓ' 모양은 DFS로는 불가능하므로 별도 처리
    static void checkExtraShape(int x, int y) {
        // 4가지 중심 모양의 변형들
        int[][] shapes = {
            {0, 0, -1, 0, 1, 0, 0, 1},  // ㅏ
            {0, 0, -1, 0, 1, 0, 0, -1}, // ㅓ
            {0, 0, 0, -1, 0, 1, 1, 0},  // ㅜ
            {0, 0, 0, -1, 0, 1, -1, 0}  // ㅗ
        };

        for (int[] shape : shapes) {
            int sum = 0;
            boolean valid = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + shape[i * 2];
                int ny = y + shape[i * 2 + 1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    sum += board[nx][ny];
                } else {
                    valid = false;
                    break;
                }
            }

            if (valid) max = Math.max(max, sum);
        }
    }
}
