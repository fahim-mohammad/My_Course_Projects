import java.util.Scanner;

public class FibonacciHugeOptimized {

    private static long getPisanoPeriod(long m) {
        long previous = 0;
        long current = 1;
        long period = 0;

        for (long i = 0; i < m * m; i++) {
            long temp = (previous + current) % m;
            previous = current;
            current = temp;

            if (previous == 0 && current == 1) {
                period = i + 1;
                break;
            }
        }

        return period;
    }

    private static long getFibonacciHuge(long n, long m) {
        long pisanoPeriod = getPisanoPeriod(m);
        n = n % pisanoPeriod;

        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;
        for (long i = 2; i <= n; i++) {
            long temp = (previous + current) % m;
            previous = current;
            current = temp;
        }

        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        scanner.close();

        System.out.println(getFibonacciHuge(n, m));
    }
}
