import java.util.*;

public class Partition3 {

    private static int partition3(int[] A) {
        int n = A.length;
        int sum = 0;
        for (int a : A) sum += a;

        if (sum % 3 != 0) return 0;
        int target = sum / 3;

        boolean[][][] dp = new boolean[n + 1][target + 1][target + 1];
        dp[0][0][0] = true;

        for (int i = 1; i <= n; i++) {
            int current = A[i - 1];
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k <= target; k++) {
                    if (dp[i - 1][j][k]) {
                        dp[i][j][k] = true;
                        if (j + current <= target) dp[i][j + current][k] = true;
                        if (k + current <= target) dp[i][j][k + current] = true;
                    }
                }
            }
        }

        return dp[n][target][target] ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = scanner.nextInt();

        System.out.println(partition3(A));
        scanner.close();
    }
}
