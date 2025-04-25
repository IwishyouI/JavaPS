import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        nums = new int[N];
        selected = new int[M];
        
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        
        // 수를 오름차순으로 정렬
        Arrays.sort(nums);
        
        // 백트래킹 시작
        backtrack(0, 0);
        
        System.out.print(sb);
        sc.close();
    }
    
    static void backtrack(int start, int depth) {
        // M개의 수를 모두 선택했다면 결과 저장
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        // 현재 위치부터 끝까지 순회하며 수를 선택
        for (int i = start; i < N; i++) {
            selected[depth] = nums[i];
            backtrack(i + 1, depth + 1);
        }
    }
}