import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        // 미리 DP 테이블 계산 (문제에서 n은 11보다 작다고 했으므로)
        int[] dp = new int[11];
        dp[0] = 1; // 초기값 (아무것도 선택하지 않는 경우)
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2
        
        // DP 테이블 채우기
        for (int i = 3; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        // 테스트 케이스 처리
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}