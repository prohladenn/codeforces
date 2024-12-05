package prohladenn.vko.round991d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProblemC {
    static FastInputReader in = new FastInputReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.close();
    }

    private static void solve() throws Exception {
        char[] c = in.next().toCharArray();

        int sum = 0, count2 = 0, count3 = 0;
        for (char value : c) {
            sum += value - '0';
            if (value == '2') count2++;
            if (value == '3') count3++;
        }

        int remainder = (9 - sum % 9) % 9;
        if (remainder == 0) {
            out.println("YES");
            return;
        }

        for (int count3Used = 0; count3Used <= Math.min(count3, 2); count3Used++) {
            int total6Count3Mod9 = (6 * count3Used) % 9;
            int requiredRemainder = (remainder - total6Count3Mod9 + 9) % 9;
            int count2Required = (requiredRemainder * 5) % 9;

            if (count2Required <= count2) {
                out.println("YES");
                return;
            }
        }

        out.println("NO");
    }

    private static class FastInputReader {
        private static BufferedReader reader;
        private static StringTokenizer tokenizer;

        FastInputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws Exception {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        String nextLine() throws Exception {
            String str;
            if (tokenizer != null && tokenizer.hasMoreTokens()) {
                str = tokenizer.nextToken("\n");
            } else {
                str = reader.readLine();
            }
            return str;
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        int[] nextArrayInt(int n) throws Exception {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }
    }
}
