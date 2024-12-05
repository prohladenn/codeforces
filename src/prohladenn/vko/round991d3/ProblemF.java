package prohladenn.vko.round991d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemF {
    static FastInputReader in = new FastInputReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.close();
    }

    private static void solve() throws Exception {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = in.nextArrayInt(n);

        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = Math.abs(a[i + 1] - a[i]);
        }

        int[] prefix = new int[0];
        if (n > 1) {
            prefix = new int[4 * (n - 1)];
            build(diff, prefix, 1, 0, n - 2);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;
            if (l == r) {
                ans.append("0 ");
            } else {
                int res = query(prefix, 1, 0, n - 2, l, r - 1);
                ans.append(res).append(" ");
            }
        }

        out.println(ans.toString().trim());
    }

    private static void build(int[] diff, int[] prefix, int v, int tl, int tr) {
        if (tl == tr) {
            prefix[v] = diff[tl];
        } else {
            int tm = (tl + tr) / 2;
            build(diff, prefix, v * 2, tl, tm);
            build(diff, prefix, v * 2 + 1, tm + 1, tr);
            prefix[v] = gcd(prefix[v * 2], prefix[v * 2 + 1]);
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static int query(int[] prefix, int v, int tl, int tr, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l <= tl && tr <= r) {
            return prefix[v];
        }
        int tm = (tl + tr) / 2;
        int leftGcd = query(prefix, v * 2, tl, tm, l, Math.min(r, tm));
        int rightGcd = query(prefix, v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
        return gcd(leftGcd, rightGcd);
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
