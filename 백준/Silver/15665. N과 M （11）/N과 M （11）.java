import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;         // 입력받은 수를 저장할 배열
    static int[] selected;    // 선택된 수열을 저장할 배열
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        selected = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 사전 순으로 출력하기 위해 정렬
        Arrays.sort(arr);
        
        // 백트래킹 시작
        dfs(0);
        
        System.out.println(sb);
    }
    
    static void dfs(int depth) {
        // M개를 모두 선택했으면 수열 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        int prev = -1; // 같은 레벨에서 중복 선택 방지를 위한 변수
        
        for (int i = 0; i < N; i++) {
            // 이전에 같은 값을 선택한 경우 건너뛰기
            if (arr[i] == prev) continue;
            
            selected[depth] = arr[i];
            prev = arr[i]; // 현재 선택한 값을 이전 값으로 기록
            
            // 다음 숫자 선택을 위해 재귀 호출
            dfs(depth + 1);
        }
    }
}