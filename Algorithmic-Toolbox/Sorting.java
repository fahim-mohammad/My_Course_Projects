import java.util.*;

public class Sorting {

    private static Random random = new Random();

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) return;

        int k = l + random.nextInt(r - l + 1);
        swap(a, l, k);

        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    private static int[] partition3(int[] a, int l, int r) {
        int pivot = a[l];
        int lt = l;   // a[l..lt-1] < pivot
        int gt = r;   // a[gt+1..r] > pivot
        int i = l;

        while (i <= gt) {
            if (a[i] < pivot) {
                swap(a, i, lt);
                i++;
                lt++;
            } else if (a[i] > pivot) {
                swap(a, i, gt);
                gt--;
            } else { // a[i] == pivot
                i++;
            }
        }
        return new int[]{lt, gt};
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        randomizedQuickSort(a, 0, n - 1);
        for (int num : a) System.out.print(num + " ");
        scanner.close();
    }
}
