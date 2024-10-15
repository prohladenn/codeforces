package prohladenn.vko.edu170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ProblemC {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] a = fs.readArray(n);

            Map<Integer, Integer> map = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }

            List<Integer> ai = new ArrayList<>(map.keySet());
            Collections.sort(ai);

            int start = 0;
            int sum = 0;
            int max = 0;
            for (int end = 0; end < ai.size(); end++) {

                if (end > 0 && ai.get(end) - ai.get(end - 1) > 1) {
                    start = end;
                    sum = 0;
                }

                sum += map.get(ai.get(end));

                while (end - start + 1 > k) {
                    sum -= map.get(ai.get(start));
                    start++;
                }

                max = Math.max(max, sum);
            }

            out.println(max);
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