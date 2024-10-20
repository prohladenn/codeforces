package prohladenn.vko.round980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ProblemC {

    record Pair(int x, int y) {
        int min() {
            return Math.min(x, y);
        }

        int max() {
            return Math.max(x, y);
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            Pair[] p = new Pair[n];
            for (int i = 0; i < n; i++) {
                p[i] = new Pair(fs.nextInt(), fs.nextInt());
            }

            Arrays.sort(p, Comparator.comparingInt(Pair::min).thenComparing(Pair::max));

            for (int i = 0; i < n; i++) {
                out.print(p[i].x + " " + p[i].y + " ");
            }

            out.println();
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