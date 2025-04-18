class Solution {
      public int[] solution(int[] list) {
        int[] reversed = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            reversed[i] = list[list.length - 1 - i];
        }
        return reversed;

    
}
}