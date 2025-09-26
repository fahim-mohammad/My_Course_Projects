import java.util.Scanner;

public class FibonacciSumSquaresOptimized {

    private static long getFibonacciSumSquares(long n) {
        long fn = getFibonacciLastDigit((int) (n % 60));
        long fnPlus1 = getFibonacciLastDigit((int) ((n + 1) % 60));
        return (fn * fnPlus1) % 10;
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
        long n = scanner.nextLong();
        scanner.close();
        System.out.println(getFibonacciSumSquares(n));
    }
}
