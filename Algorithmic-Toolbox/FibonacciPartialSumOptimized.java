import java.util.Scanner;

public class FibonacciPartialSumOptimized {

    private static long getFibonacciPartialSum(long from, long to) {
        long sumTo = getFibonacciSumLastDigit(to);
        long sumFromMinusOne = getFibonacciSumLastDigit(from - 1);
        return (sumTo - sumFromMinusOne + 10) % 10;
    }

    private static long getFibonacciSumLastDigit(long n) {
        long lastDigitNPlus2 = getFibonacciLastDigit((int) ((n + 2) % 60));
        return (lastDigitNPlus2 + 9) % 10;
    }

    private static int getFibonacciLastDigit(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current = 1;

        for (int i = 2; i <= n; i++) {
            int temp = (previous + current) % 10;
            previous = current;
            current = temp;
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        scanner.close();
        System.out.println(getFibonacciPartialSum(from, to));
    }
}
