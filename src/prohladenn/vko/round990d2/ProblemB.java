package prohladenn.vko.round990d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ProblemB {
    static FastInputReader in = new FastInputReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.close();
    }

    private static void solve() throws Exception {
        int n = in.nextInt();
        String s = in.next();

        if (n == 1) {
            out.println(s);
            return;
        }

        Map<Character, Integer> map = new HashMap<>(30);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if (map.size() == 1) {
            out.println(s);
            return;
        }

        var iterator = map.entrySet().iterator();

        int max, min;
        char maxChar, minChar;

        var first = iterator.next();
        var second = iterator.next();
        if (first.getValue() > second.getValue()) {
            max = first.getValue();
            maxChar = first.getKey();
            min = second.getValue();
            minChar = second.getKey();
        } else {
            max = second.getValue();
            maxChar = second.getKey();
            min = first.getValue();
            minChar = first.getKey();
        }

        while (iterator.hasNext()) {
            var entry = iterator.next();
            int count = entry.getValue();
            if (count > max) {
                max = count;
                maxChar = entry.getKey();
            }
            if (count < min) {
                min = count;
                minChar = entry.getKey();
            }
        }

        out.println(s.replaceFirst("" + minChar, "" + maxChar));
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
}
