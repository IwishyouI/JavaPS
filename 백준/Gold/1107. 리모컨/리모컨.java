

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(bf.readLine().trim());// 목표로 하는 채널

        int M = Integer.parseInt(bf.readLine().trim()); // 고장난 버튼의 개수

        boolean[] broken = new boolean[10]; // 고장난 버튼의 개수 그런데 리모컨의 번호가 0번부터 9번까지 존재한다.


        final int START = 100;

        int ans = Math.abs(target - START);

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }


        for (int i = 0; i <= 999999; i++) {
            String s = Integer.toString(i);
            boolean ok = true;

            for (char ch : s.toCharArray()) {

                if (broken[ch - '0']) {
                    ok = false;
                    break;

                }
            }

            if(!ok) continue;

            int pressCount = s.length() + Math.abs(i - target);

            ans = Math.min(ans, pressCount);

        }

        System.out.println(ans);


    }


}


