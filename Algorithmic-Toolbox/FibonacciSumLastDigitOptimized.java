import java.util.Scanner;

public class FibonacciSumLastDigitOptimized {

    private static long getFibonacciSumLastDigit(long n) {
        long lastDigitNPlus2 = getFibonacciLastDigit((int) ((n + 2) % 60));
        long sumLastDigit = (lastDigitNPlus2 + 9) % 10;
        return sumLastDigit;
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
        System.out.println(getFibonacciSumLastDigit(n));
    }
}
