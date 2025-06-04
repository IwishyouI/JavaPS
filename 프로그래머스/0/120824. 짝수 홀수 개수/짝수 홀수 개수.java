

import java.util.ArrayList;

class Solution {

    static int[] num_list = {1, 2, 3, 4, 5};

    public static void main(String[] args) {

        solution(num_list);
    }

    public static int[] solution(int[] num_list) {

        ArrayList<Integer> answer = new ArrayList<>();
        int Ycount = 0;
        int Ncount = 0;

        for (int val : num_list) {
            if (val % 2 == 0) {
                Ycount += 1;
            } else {
                Ncount += 1;

            }
        }
        answer.add(0,Ycount);
        answer.add(1,Ncount);

        System.out.println(answer);
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}