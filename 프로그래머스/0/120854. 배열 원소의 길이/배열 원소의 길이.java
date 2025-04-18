class Solution {
     public int[] solution(String[] strlist) {

        int[] answer = new int[strlist.length];
        for (int i = 0; i < strlist.length; i++) {

            int length = strlist[i].length();
            answer[i] = length;
        }
        return answer;
    }
}