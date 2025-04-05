class Solution {
  public static int solution(double num1, double num2) {
        double answer = (num1 / num2) * 1000;
        answer = Math.floor(answer); // 소숫점 이하 제거
        int N = (int)answer;
        return N;
    }
}