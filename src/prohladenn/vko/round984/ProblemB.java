package prohladenn.vko.round984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ProblemB {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            Bottle[] bottles = new Bottle[k];
            for (int i = 0; i < k; i++) {
                bottles[i] = new Bottle(fs.nextInt(), fs.nextInt());
            }

            int ans = Arrays.stream(bottles)
                    .collect(Collectors.groupingBy(Bottle::brand, Collectors.summingInt(Bottle::capacity)))
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(n)
                    .mapToInt(Map.Entry::getValue)
                    .sum();

            out.println(ans);
        }

        out.close();
    }

    record Bottle(int brand, int capacity) {
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
