package prohladenn.vko.round984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ProblemC {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            char[] s = fs.next().toCharArray();
            boolean[] b = new boolean[s.length];
            for (int i = 0; i < s.length; i++) {
                b[i] = s[i] == '1';
            }

            HashSet<Integer> ends = new HashSet<>(s.length);
            for (int i = 3; i < b.length; i++) {
                if (b[i - 3] && b[i - 2] && !b[i - 1] && !b[i]) {
                    ends.add(i);
                }
            }

            int q = fs.nextInt();
            while (q-- > 0) {
                int i = fs.nextInt();

                b[i - 1] = fs.nextInt() == 1;

                for (int j = Math.max(3, i - 3); j < Math.min(b.length, i + 4); j++) {
                    if (b[j - 3] && b[j - 2] && !b[j - 1] && !b[j]) {
                        ends.add(j);
                    } else {
                        ends.remove(j);
                    }
                }

                out.println(!ends.isEmpty() ? "YES " : "NO");
            }
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
