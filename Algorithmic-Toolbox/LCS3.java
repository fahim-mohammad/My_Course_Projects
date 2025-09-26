import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int n = a.length;
        int m = b.length;
        int o = c.length;
        int[][][] dp = new int[n + 1][m + 1][o + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= o; k++) {
                    if (a[i - 1] == b[j - 1] && a[i - 1] == c[k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(
                            Math.max(dp[i - 1][j][k], dp[i][j - 1][k]),
                            dp[i][j][k - 1]
                        );
                    }
                }
            }
        }

        return dp[n][m][o];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) a[i] = scanner.nextInt();

        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) b[i] = scanner.nextInt();

        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) c[i] = scanner.nextInt();

        System.out.println(lcs3(a, b, c));
        scanner.close();
    }
}
