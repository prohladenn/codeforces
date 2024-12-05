//package prohladenn.vko.round991d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemE {
    static FastInputReader in = new FastInputReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.close();
    }

    private static void solve() throws Exception {
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        char[] c = in.next().toCharArray();

        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= b.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        for (int i = 0; i <= a.length; i++) {
            for (int j = 0; j <= b.length; j++) {
                int pos = i + j;

                if (i < a.length) {
                    int value = dp[i][j] + (c[pos] == a[i] ? 0 : 1);
                    dp[i + 1][j] = Math.min(dp[i + 1][j], value);
                }

                if (j < b.length) {
                    int value = dp[i][j] + (c[pos] == b[j] ? 0 : 1);
                    dp[i][j + 1] = Math.min(dp[i][j + 1], value);
                }
            }
        }

        out.println(dp[a.length][b.length]);
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
