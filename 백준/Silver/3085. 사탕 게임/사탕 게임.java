

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    public static char board[][];

    static int maxCandy;

    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = bf.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    countMaxCandy();
                    swap(i, j, i, j + 1);
                }
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    countMaxCandy();
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.println(maxCandy);
    }

    static void swap(int r1, int c1, int r2, int c2) {
        char temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }

    public static void countMaxCandy() {

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++;
                } else {
                    maxCandy = Math.max(maxCandy, count);
                    count = 1;
                }
            }
            maxCandy = Math.max(maxCandy, count);
        }

        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                } else {
                    maxCandy = Math.max(maxCandy, count);
                    count = 1;
                }
            }
            maxCandy = Math.max(maxCandy, count);
        }
    }
}