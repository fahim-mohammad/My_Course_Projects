import java.util.Scanner;

public class ChangeDP {

    private static int getChange(int m) {
        int[] dp = new int[m + 1];
        dp[0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (i >= 1) dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            if (i >= 3) dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            if (i >= 4) dp[i] = Math.min(dp[i], dp[i - 4] + 1);
        }
        return dp[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();
    }
}
