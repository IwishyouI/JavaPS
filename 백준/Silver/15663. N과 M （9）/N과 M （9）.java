import java.util.*;

public class Main {
    static int N, M;
    static int[] nums, selected;
    static boolean[] visited; // 각 인덱스의 사용 여부를 추적하는 배열 추가
    static LinkedHashSet<String> result = new LinkedHashSet<>(); // 중복된 수열 출력을 방지하기 위해 유지

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        selected = new int[M];
        visited = new boolean[N]; // visited 배열 초기화

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums); // 입력된 숫자 정렬 (사전 순 출력을 위해)

        dfs(0); // DFS 시작

        // 결과 출력
        for (String s : result) {
            System.out.println(s);
        }
    }

    static void dfs(int depth) {

        if (depth == M) { // M개의 숫자를 모두 선택한 경우
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]);
                if (i < M - 1) { // 마지막 숫자가 아니면 공백 추가
                    sb.append(" ");
                }
            }
            result.add(sb.toString()); // 완성된 수열을 Set에 추가 (중복 제거)
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = nums[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}