package prohladenn.vko.edu170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemC {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] a = fs.readArray(n);

            Arrays.sort(a);

            int end, max = 1;
            for (int start = 0; start < n - 1; start++) {

                if (start != 0 && a[start] == a[start - 1]) {
                    continue;
                }

                end = start + 1;
                while (end < n && a[end] - a[end - 1] < 2 && a[end] - a[start] < k) {
                    end++;
                }

                max = Math.max(max, end - start);
            }

            out.println(max);
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