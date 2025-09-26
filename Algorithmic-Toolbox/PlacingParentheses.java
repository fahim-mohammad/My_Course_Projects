import java.util.*;

public class PlacingParentheses {

    private static long getMaximValue(String exp) {
        int n = (exp.length() + 1) / 2;
        long[][] minValues = new long[n][n];
        long[][] maxValues = new long[n][n];

        for (int i = 0; i < n; i++) {
            long val = exp.charAt(2 * i) - '0';
            minValues[i][i] = val;
            maxValues[i][i] = val;
        }

        for (int s = 1; s < n; s++) {
            for (int i = 0; i < n - s; i++) {
                int j = i + s;
                long minVal = Long.MAX_VALUE;
                long maxVal = Long.MIN_VALUE;

                for (int k = i; k < j; k++) {
                    char op = exp.charAt(2 * k + 1);
                    long[] results = new long[]{
                        eval(maxValues[i][k], maxValues[k + 1][j], op),
                        eval(maxValues[i][k], minValues[k + 1][j], op),
                        eval(minValues[i][k], maxValues[k + 1][j], op),
                        eval(minValues[i][k], minValues[k + 1][j], op)
                    };
                    for (long r : results) {
                        minVal = Math.min(minVal, r);
                        maxVal = Math.max(maxVal, r);
                    }
                }

                minValues[i][j] = minVal;
                maxValues[i][j] = maxVal;
            }
        }

        return maxValues[0][n - 1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        throw new IllegalArgumentException("Unknown operator: " + op);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
        scanner.close();
    }
}
