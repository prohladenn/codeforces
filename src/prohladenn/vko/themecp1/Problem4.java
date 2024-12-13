package prohladenn.vko.themecp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://codeforces.com/problemset/problem/2038/L
public class Problem4 {
    static FastInputReader in = new FastInputReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) solve();
        out.close();
    }

    private static void solve() throws Exception {
        int n = in.nextInt();
        out.println(n + (n + 5) / 6);
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
