import java.util.*;

public class PrimitiveCalculator {

    private static List<Integer> optimal_sequence(int n) {
        int[] dp = new int[n + 1];
        int[] prev = new int[n + 1];
        dp[1] = 0;
        prev[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;

            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
        }

        List<Integer> sequence = new ArrayList<>();
        for (int i = n; i != 0; i = prev[i]) {
            sequence.add(i);
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) System.out.print(x + " ");
        scanner.close();
    }
}
