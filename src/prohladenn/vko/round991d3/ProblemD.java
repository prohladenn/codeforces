package prohladenn.vko.round991d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemD {
    static FastInputReader in = new FastInputReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.close();
    }

    private static void solve() throws Exception {
        char[] c = in.next().toCharArray();

        for (int i = 0; i < c.length - 1; i++) {
            for (int j = i + 1; j < Math.min(i + 12, c.length); j++) {
                if (c[j] == '0') continue;
                char tmp = (char) (c[j] - (j - i));
                if (tmp >= '0' && tmp <= '9' && tmp > c[i]) {
                    for (int k = j; k > i; k--) c[k] = c[k - 1];
                    c[i] = tmp;
                }
            }
        }

        out.println(new String(c));
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
