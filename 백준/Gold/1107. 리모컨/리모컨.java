import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 목표 채널 N (0 ≤ N ≤ 500,000)
        int target = Integer.parseInt(br.readLine().trim());
        // 고장난 버튼의 개수
        int M = Integer.parseInt(br.readLine().trim());
        
        // 고장 여부를 담는 배열, 인덱스는 버튼 번호
        boolean[] broken = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        
        // 시작점은 100번 채널에서 출발
        final int START = 100;
        // +와 - 버튼만 사용해 목표에 도달하는 최소 횟수
        int ans = Math.abs(target - START);

        // 모든 숫자로 이루어진 채널을 탐색 (0 ~ 999,999)
        for (int ch = 0; ch <= 999_999; ch++) {
            String s = Integer.toString(ch);
            boolean ok = true;
            // 채널 숫자를 구성하는 모든 버튼이 살아있는지 확인
            for (char c : s.toCharArray()) {
                if (broken[c - '0']) {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;

            // 숫자 버튼만으로 채널 입력 후, +·–로 조정까지 포함한 총 누름 횟수
            int pressCount = s.length() + Math.abs(ch - target);
            // 시적 비교: 더 짧은 길이로 흐르는 시간을 선택
            ans = Math.min(ans, pressCount);
        }
        
        // 최솟값을 세상에 흘려보내며, 채널은 마침내 맞춰진다
        System.out.println(ans);
    }
}
