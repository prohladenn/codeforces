package prohladenn.vko.round982d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class ProblemA {
    static FastInputReader in = new FastInputReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.close();
    }

    private static void solve() throws Exception {
        int n = in.nextInt();
        int x = 0, y = 0;
        for (int i = 1; i <= n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            x = Math.max(x, a);
            y = Math.max(y, b);
        }
        out.println(2 * (x + y));
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

        long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        double nextDouble() throws Exception {
            return Double.parseDouble(next());
        }

        BigInteger nextBigInteger() throws Exception {
            return new BigInteger(next());
        }

        BigDecimal nextBigDecimal() throws Exception {
            return new BigDecimal(next());
        }

        int[] nextArrayInt(int n) throws Exception {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }

        long[] nextArrayLong(int n) throws Exception {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = nextLong();
            return arr;
        }

        double[] nextArrayDouble(int n) throws Exception {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) arr[i] = nextDouble();
            return arr;
        }

        BigInteger[] nextArrayBigInteger(int n) throws Exception {
            BigInteger[] arr = new BigInteger[n];
            for (int i = 0; i < n; i++) arr[i] = nextBigInteger();
            return arr;
        }

        BigDecimal[] nextArrayBigDecimal(int n) throws Exception {
            BigDecimal[] arr = new BigDecimal[n];
            for (int i = 0; i < n; i++) arr[i] = nextBigDecimal();
            return arr;
        }

        String[] nextArrayString(int n) throws Exception {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = next();
            return arr;
        }
    }

    private static class NumberUtils {
        static long gcd(long a, long b) {
            BigInteger bigA = BigInteger.valueOf(a);
            BigInteger bigB = BigInteger.valueOf(b);
            return bigA.gcd(bigB).longValue();
        }

        public static int gcd(int a, int b) {
            BigInteger bigA = BigInteger.valueOf(a);
            BigInteger bigB = BigInteger.valueOf(b);
            return bigA.gcd(bigB).intValue();
        }

        public static long lcm(long a, long b) {
            BigInteger bigA = BigInteger.valueOf(a);
            BigInteger bigB = BigInteger.valueOf(b);
            return bigA.divide(bigA.gcd(bigB)).multiply(bigB).longValue();
        }

        public static int lcm(int a, int b) {
            BigInteger bigA = BigInteger.valueOf(a);
            BigInteger bigB = BigInteger.valueOf(b);
            return bigA.divide(bigA.gcd(bigB)).multiply(bigB).intValue();
        }
    }
}
