package prohladenn.vko.hello2025;

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
        long l = in.nextInt();
        long r = in.nextInt();
        long sum = 0;
        int id = 30;

        while (id >= 0) {
            long mask = 1L << id;
            if ((l & mask) == (r & mask)) {
                if ((l & mask) != 0) {
                    sum += mask;
                }
            } else {
                break;
            }
            id--;
        }

        long mask = 1L << id;
        if (r > sum + mask) {
            out.println((sum + mask - 1) + " " + (sum + mask) + " " + (sum + mask + 1));
        } else {
            out.println((sum + mask - 2) + " " + (sum + mask - 1) + " " + (sum + mask));
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
