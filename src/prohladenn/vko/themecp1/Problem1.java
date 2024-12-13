package prohladenn.vko.themecp1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://codeforces.com/problemset/problem/1850/D
public class Problem1 {
    static FastInputReader in = new FastInputReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.close();
    }

    private static void solve() throws Exception {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = in.nextArrayInt(n);

        Arrays.sort(a);

        int i = 0, j = 1, max = 0;
        while (i < n) {
            if (i == j) j++;
            while (j < n && a[j] - a[j - 1] <= k) j++;
            max = Math.max(max, j - i);
            i++;
        }

        out.println(n - max);
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
