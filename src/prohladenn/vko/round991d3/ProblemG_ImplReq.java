package prohladenn.vko.round991d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ProblemG_ImplReq {
    static FastInputReader in = new FastInputReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        while (t-- > 0) solve();
        out.close();
    }

    private static void solve() throws Exception {
        int n = in.nextInt();

        List<List<Integer>> tree = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        int[] subtreeSizes = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        dfs(1, -1, tree, subtreeSizes, visited);

        out.println("subtreeSizes=" + Arrays.toString(subtreeSizes));

        if (n == 2) {
            out.println(1);
            return;
        }

        int max = 1;
        for (int u = 1; u <= n; u++) {
            for (int v : tree.get(u)) {
                if (subtreeSizes[v] < subtreeSizes[u]) {
                    int size1 = subtreeSizes[v];
                    int size2 = n - subtreeSizes[v];
                    max = Math.max(max, size1 + size2);
                }
            }
        }

        out.println(max);
    }

    private static int dfs(int u, int p, List<List<Integer>> tree, int[] subtreeSizes, boolean[] visited) {
        visited[u] = true;
        int size = 1;
        for (int v : tree.get(u)) {
            if (v != p && !visited[v]) {
                size += dfs(v, u, tree, subtreeSizes, visited);
            }
        }
        subtreeSizes[u] = size;
        return size;
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
