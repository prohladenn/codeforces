package prohladenn.vko.round996d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemC {
    static FastInputReader in = new FastInputReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.close();
    }

    private static void solve() throws Exception {
        int n = in.nextInt();
        int m = in.nextInt();
        char[] c = in.next().toCharArray();

        long[][] a = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }

        long[] sumRow = new long[n];
        long[] sumCol = new long[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumRow[i] += a[i][j];
                sumCol[j] += a[i][j];
            }
        }

        int i = 0, j = 0;
        for (char value : c) {
            if (value == 'D') {
                a[i][j] = -sumRow[i];
                sumCol[j] += a[i][j];
                i++;
            } else {
                a[i][j] = -sumCol[j];
                sumRow[i] += a[i][j];
                j++;
            }
        }
        a[i][j] = -sumRow[i];

        for (int ii = 0; ii < n; ii++) {
            for (int jj = 0; jj < m; jj++) {
                out.print(a[ii][jj] + " ");
            }
            out.println();
        }
    }

    private static class FastInputReader {
        private static BufferedReader reader;
        private static StringTokenizer tokenizer;

        FastInputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws Exception {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        String nextLine() throws Exception {
            String str;
            if (tokenizer != null && tokenizer.hasMoreTokens()) {
                str = tokenizer.nextToken("\n");
            } else {
                str = reader.readLine();
            }
            return str;
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        int[] nextArrayInt(int n) throws Exception {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }
    }
}
