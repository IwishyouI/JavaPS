

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        long length = 0;
        for (int i = 1; i <= N; i *= 10) {
            length += (N - i + 1);
        }
        System.out.print(length);
    }
}