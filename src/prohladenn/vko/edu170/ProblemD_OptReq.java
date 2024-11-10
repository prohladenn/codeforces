package prohladenn.vko.edu170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemD_OptReq {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt(); // 2 * 10^6
        int m = fs.nextInt(); // 5000
        int[] a = fs.readArray(n);

        int[][] dp = new int[m + 1][m + 1];
        dp[0][0] = 0;

        int attrPointsUsed = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                attrPointsUsed++;

                for (int j = attrPointsUsed; j >= 0; j--) {
                    int currStrength = j;
                    int currIntelligence = attrPointsUsed - j;

                    if (currStrength > 0) {
                        dp[currStrength][currIntelligence] = Math.max(
                                dp[currStrength][currIntelligence],
                                dp[currStrength - 1][currIntelligence]
                        );
                    }

                    if (currIntelligence > 0) {
                        dp[currStrength][currIntelligence] = Math.max(
                                dp[currStrength][currIntelligence],
                                dp[currStrength][currIntelligence - 1]
                        );
                    }
                }
            } else if (a[i] > 0) {
                for (int j = 0; j <= attrPointsUsed; j++) {
                    int currStrength = j;
                    int currIntelligence = attrPointsUsed - j;

                    if (currIntelligence >= a[i]) {
                        dp[currStrength][currIntelligence]++;
                    }
                }
            } else {
                for (int j = 0; j <= attrPointsUsed; j++) {
                    int currStrength = j;
                    int currIntelligence = attrPointsUsed - j;

                    if (currStrength >= -a[i]) {
                        dp[currStrength][currIntelligence]++;
                    }
                }
            }

            //out.println("attrPointsUsed = " + attrPointsUsed + ", a[i] = " + a[i]);
            //print(out, dp);
            //out.println();
        }

        int max = 0;
        for (int j = 0; j <= m; j++) {
            max = Math.max(max, dp[j][m - j]);
        }
        out.println(max);

        out.close();
    }

    static void print(PrintWriter out, int[][] dp) {
        for (int[] row : dp) {
            out.println(Arrays.toString(row));
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
    }
}