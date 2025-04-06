class Solution {
           public static double solution(int[] numbers) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];

            }
            double d = (double) sum / numbers.length;
            double answer =  d;
            return answer;
        }
}