import java.util.*;

public class Knapsack {

    static int optimalWeight(int W, int[] w) {
        int n = w.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i - 1]] + w[i - 1]);
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) w[i] = scanner.nextInt();

        System.out.println(optimalWeight(W, w));
        scanner.close();
    }
}
