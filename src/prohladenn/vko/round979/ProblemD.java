package prohladenn.vko.round979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemD {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        String yes = "YES", no = "NO";

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int q = fs.nextInt();

            int[] p = new int[n + 1];
            boolean[] isOnPlace = new boolean[n + 1];
            int max = 0;
            for (int i = 1; i <= n; i++) {
                p[i] = fs.nextInt();
                max = Math.max(max, p[i]);
                isOnPlace[i] = i == max;
            }

            String s = fs.next();
            boolean[] isR = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                isR[i + 1] = s.charAt(i) == 'R';
            }

            int problemPlaces = 0;
            for (int i = 1; i <= n; i++) {
                if (isProblemPlace(i, isOnPlace, isR)) {
                    problemPlaces++;
                }
            }

            while (q-- > 0) {
                int i = fs.nextInt();

                problemPlaces -= isProblemPlace(i, isOnPlace, isR) ? 1 : 0;
                problemPlaces -= isProblemPlace(i - 1, isOnPlace, isR) ? 1 : 0;

                isR[i] = !isR[i];

                problemPlaces += isProblemPlace(i, isOnPlace, isR) ? 1 : 0;
                problemPlaces += isProblemPlace(i - 1, isOnPlace, isR) ? 1 : 0;

                out.println(problemPlaces == 0 ? yes : no);
            }
        }

        out.close();
    }

    static boolean isProblemPlace(int i, boolean[] isOnPlace, boolean[] isR) {
        if (isOnPlace[i]) {
            return false;
        }

        return !isR[i] && isR[i + 1];
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
    }
}