import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) return 0;
        int mid = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, mid);
        numberOfInversions += getNumberOfInversions(a, b, mid, right);

        int i = left, j = mid, k = left;
        while (i < mid && j < right) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
                numberOfInversions += mid - i;
            }
        }
        while (i < mid) b[k++] = a[i++];
        while (j < right) b[k++] = a[j++];
        for (i = left; i < right; i++) a[i] = b[i];

        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
        scanner.close();
    }
}
