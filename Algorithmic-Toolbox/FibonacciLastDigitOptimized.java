import java.util.Scanner;

public class FibonacciLastDigitOptimized {

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
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(getFibonacciLastDigit(n));
    }
}
