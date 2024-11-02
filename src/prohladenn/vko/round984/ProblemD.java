package prohladenn.vko.round984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProblemD {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int[][] a = new int[n][m];

            for (int i = 0; i < n; i++) {
                char[] row = fs.next().toCharArray();
                for (int j = 0; j < m; j++) {
                    a[i][j] = row[j] - '0';
                }
            }

            int ans = 0;
            for (int l = 0; l < Math.min(n / 2, m / 2); l++) {

                //out.println("\n\nl = " + l);
                ArrayList<Integer> layer = new ArrayList<>(n * m);

                for (int i = l; i < m - l; i++) {
                    //out.print(a[l][i] + " ");
                    if (i != l) {
                        layer.add(a[l][i]);
                    }
                }
                //out.println();

                for (int i = l; i < n - l; i++) {
                    //out.print(a[i][m - l - 1] + " ");
                    if (i != l) {
                        layer.add(a[i][m - l - 1]);
                    }
                }
                //out.println();

                for (int i = m - l - 1; i >= l; i--) {
                    //out.print(a[n - l - 1][i] + " ");
                    if (i != m - l - 1) {
                        layer.add(a[n - l - 1][i]);
                    }
                }
                //out.println();

                for (int i = n - l - 1; i >= l; i--) {
                    //out.print(a[i][l] + " ");
                    if (i != n - l - 1) {
                        layer.add(a[i][l]);
                    }
                }
                //out.println();

                //out.println("layer = " + layer);

                layer.add(layer.get(0));
                layer.add(layer.get(1));
                layer.add(layer.get(2));

                //out.println("layer with 3 extra = " + layer);

                for (int i = 0; i < layer.size() - 3; i++) {
                    if (layer.get(i) == 1
                            && layer.get(i + 1) == 5
                            && layer.get(i + 2) == 4
                            && layer.get(i + 3) == 3) {
                        ans += 1;
                    }
                }
            }

            out.println(ans);
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
