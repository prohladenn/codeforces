package prohladenn.vko.round979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProblemD_Failed {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        String yes = "YES", no = "NO";

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int q = fs.nextInt();
            int[] p = fs.readArray(n);
            StringBuilder s = new StringBuilder(fs.next());

            int[] lReach = getLeftReach(s);
            int[] rReach = getRightReach(s);

            out.println("lReach: " + Arrays.toString(lReach));
            out.println("rReach: " + Arrays.toString(rReach));

            for (int i = 0; i < q; i++) {
                int queryIndex = fs.nextInt();
                out.println("queryIndex: " + queryIndex);
                queryIndex--;

                out.println("s before: " + s);
                swapChar(s, queryIndex);
                out.println("s after: " + s);

                updateLeftReach(lReach, s, queryIndex);
                updateRightReach(rReach, s, queryIndex);

                out.println("lReach: " + Arrays.toString(lReach));
                out.println("rReach: " + Arrays.toString(rReach));

                out.println(canSort(p, lReach, rReach) ? yes : no);
            }
        }

        out.close();
    }

    static void updateLeftReach(int[] lReach, StringBuilder s, int index) {
        for (int i = index; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == 'L') {
                lReach[i] = lReach[i - 1];
            } else {
                lReach[i] = i;
            }
            if (i > 0 && s.charAt(i) == 'R') {
                break;
            }
        }
    }

    static void updateRightReach(int[] rReach, StringBuilder s, int index) {
        for (int i = index; i >= 0; i--) {
            if (i < s.length() - 1 && s.charAt(i) == 'R') {
                rReach[i] = rReach[i + 1];
            } else {
                rReach[i] = i;
            }
            if (i < s.length() - 1 && s.charAt(i) == 'L') {
                break;
            }
        }
    }

    static int[] getLeftReach(StringBuilder s) {
        int n = s.length();
        int[] lReach = new int[n];
        for (int i = 0; i < n; i++) {
            lReach[i] = i;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == 'L') {
                lReach[i] = lReach[i - 1];
            }
        }
        return lReach;
    }

    static int[] getRightReach(StringBuilder s) {
        int n = s.length();
        int[] rReach = new int[n];
        for (int i = 0; i < n; i++) {
            rReach[i] = i;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == 'R') {
                rReach[i] = rReach[i + 1];
            }
        }
        return rReach;
    }

    static void swapChar(StringBuilder s, int i) {
        if (s.charAt(i) == 'L') {
            s.setCharAt(i, 'R');
        } else {
            s.setCharAt(i, 'L');
        }
    }

    static boolean canSort(int[] p, int[] lReach, int[] rReach) {
        for (int i = 0; i < p.length; i++) {
            int pos = p[i] - 1;
            if (pos < i) {
                if (lReach[i] > pos) {
                    return false;
                }
            } else if (pos > i) {
                if (rReach[i] < pos) {
                    return false;
                }
            }
        }
        return true;
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