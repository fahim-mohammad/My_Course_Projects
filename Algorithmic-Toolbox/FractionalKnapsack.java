import java.util.*;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        int n = values.length;
        double[][] items = new double[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = values[i];
            items[i][1] = weights[i];
        }
        Arrays.sort(items, (a, b) -> Double.compare(b[0] / b[1], a[0] / a[1]));
        double value = 0;
        for (int i = 0; i < n && capacity > 0; i++) {
            double weight = Math.min(items[i][1], capacity);
            value += weight * (items[i][0] / items[i][1]);
            capacity -= weight;
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
        scanner.close();
    }
}
