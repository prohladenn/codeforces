package prohladenn.vko.edu171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemC_ImplReq {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char[] a = fs.next().toCharArray();

            boolean[] b = new boolean[n];
            Arrays.fill(b, false);

            if (n == 1) {
                out.println(1);
                continue;
            }

            int sum = 0, j = n - 2;
            for (int i = n - 1; i > 0; i--) {
                if (a[i] == '1') {
                    while (j >= 0 && a[j] == '1') {
                        j--;
                    }
                    if (j > 0) {
                        b[i] = true;
                        b[j] = true;
                        sum += j + 1;
                        out.println("Adding1 " + (j + 1) + "(" + (i + 1) + ")");
                        j--;
                    }
                } else {
                    if (!b[i]) {
                        b[i] = true;
                        sum += i + 1;
                        out.println("Adding2 " + (i + 1));
                    }
                }
            }

            out.println(sum);
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
