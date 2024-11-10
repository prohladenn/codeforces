package prohladenn.vko.round980d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemB {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] a = fs.readArray(n);

            Arrays.sort(a);

            int min = a[0];
            if ((long) min * n >= k) {
                out.println(k);
                continue;
            }

            long sum = (long) min * n;
            long pres = (long) min * n + 1;

            for (int i = 1; i < n; i++) {

                if (a[i] == a[i - 1]) {
                    pres++;
                    continue;
                }

                long rowValue = (long) (a[i] - a[i - 1]) * (n - i);

                if (sum + rowValue >= k) {
                    pres += k - sum;
                    break;
                }

                sum += rowValue;
                pres += rowValue;
                pres++;
            }

            out.println(pres);
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