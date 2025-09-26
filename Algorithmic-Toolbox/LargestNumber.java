import java.util.*;

public class LargestNumber {

    private static String largestNumber(String[] a) {
        Arrays.sort(a, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder result = new StringBuilder();
        for (String num : a) {
            result.append(num);
        }
        // Handle case where all numbers are zeros
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
        scanner.close();
    }
}
