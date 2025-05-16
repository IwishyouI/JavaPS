import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> complexSizes = new ArrayList<>(); // 단지별 집의 수를 저장할 리스트
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        
        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        // 모든 위치를 확인하며 단지 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i, j);
                    complexSizes.add(size);
                }
            }
        }
        
        // 단지 내 집의 수 오름차순 정렬
        Collections.sort(complexSizes);
        
        // 결과 출력
        System.out.println(complexSizes.size()); // 총 단지 수
        for (int size : complexSizes) {
            System.out.println(size); // 각 단지 내 집의 수
        }
        
        sc.close();
    }
    
    // DFS를 통해 하나의 단지를 탐색하고 집의 수를 반환
    static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1; // 현재 집 포함
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 지도 범위 내에 있고, 집이 있으며, 아직 방문하지 않은 경우
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                count += dfs(nx, ny); // 연결된 집 탐색 후 집의 수 누적
            }
        }
        
        return count;
    }
}