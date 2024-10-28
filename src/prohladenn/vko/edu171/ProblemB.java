package prohladenn.vko.edu171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemB {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long[] a = fs.readArrayL(n);

            if (n == 1) {
                out.println(1);
                continue;
            }

            if (n % 2 == 0) {
                long max = Long.MIN_VALUE;
                for (int i = 0; i < n; i += 2) {
                    max = Math.max(max, a[i + 1] - a[i]);
                }
                out.println(max);
                continue;
            }

            long min = Long.MAX_VALUE;
            for (int ignr = 0; ignr < n; ignr += 2) {
                int start = -1;
                long max = Long.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    if (ignr == i) {
                        continue;
                    }
                    if (start == -1) {
                        start = i;
                    } else {
                        max = Math.max(max, a[i] - a[start]);
                        start = -1;
                    }
                }
                min = Math.min(min, max);
            }

            out.println(min);
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

        long[] readArrayL(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }
}
