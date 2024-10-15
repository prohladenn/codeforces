package prohladenn.vko.edu170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemB {

    static long D = 1_000_000_000 + 7;

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        /*int N = 15;
        int[][] C = new int[N][N];

        for (int i = 0; i < N; i++) {
            C[i][0] = 1;
            C[i][i] = 1;
            for (int k = 1; k < i; k++)
                C[i][k] = C[i][k - 1] + C[i - 1][k - 1];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                out.print(C[i][j] + " ");
            }
            out.println();
        }*/

        int t = fs.nextInt();
        int[] n = fs.readArray(t);
        int[] k = fs.readArray(t);

        int kmax = 100_000;
        long[] res = new long[kmax];
        res[0] = 1;
        for (int i = 1; i < kmax; i++) {
            res[i] = (res[i - 1] % D + res[i - 1] % D) % D;
        }

        for (int i = 0; i < t; i++) {
            if (k[i] > n[i]) {
                out.println(0);
            } else if (k[i] == n[i]) {
                out.println(1);
            } else {
                out.println(res[k[i]]);
            }
        }

        out.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}