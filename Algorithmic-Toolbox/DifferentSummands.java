import java.util.*;

public class DifferentSummands {

    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<>();
        int k = 1;
        while (n > 0) {
            if (n - k > k) {
                summands.add(k);
                n -= k;
                k++;
            } else {
                summands.add(n);
                break;
            }
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
        scanner.close();
    }
}
