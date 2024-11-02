package prohladenn.vko.round984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class ProblemE_OptimizationReq {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();
        int k = fs.nextInt();
        int q = fs.nextInt();

        int[][] a = new int[n][k];
        int[][] b = new int[n][k];
        for (int i = 0; i < n; i++) {
            a[i] = fs.readArray(k);
        }

        //out.println("a");
        //print(a, out);

        b[0] = a[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                b[i][j] = b[i - 1][j] | a[i][j];
            }
        }

        //out.println("b");
        //print(b, out);

        while (q-- > 0) {
            int m = fs.nextInt();
            //out.println(m);

            ArrayList<Predicate<Integer>> predicates = new ArrayList<>();

            while (m-- > 0) {
                int r = fs.nextInt();
                char o = fs.next().charAt(0);
                int c = fs.nextInt();

                //out.println(r + " " + o + " " + c);

                predicates.add(row -> (o == '>')
                        ? b[row][r - 1] > c
                        : b[row][r - 1] < c);
            }

            boolean ok = true;
            for (int row = 0; row < n; row++) {
                ok = true;

                for (Predicate<Integer> predicate : predicates) {
                    if (!predicate.test(row)) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    out.println(row + 1);
                    break;
                }
            }
            if (!ok) {
                out.println(-1);
            }
        }

        out.close();
    }

    static void print(int[][] a, PrintWriter out) {
        for (int[] row : a) {
            for (int col : row) {
                out.print(col + " ");
            }
            out.println();
        }
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
