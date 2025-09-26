import java.util.Scanner;

public class LCMOptimized {

    private static long gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static long lcm(int a, int b) {
        return ((long) a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        System.out.println(lcm(a, b));
    }
}
