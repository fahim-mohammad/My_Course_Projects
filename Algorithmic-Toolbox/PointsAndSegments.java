import java.util.*;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int n = starts.length;
        int m = points.length;
        int[] cnt = new int[m];

        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) idx[i] = i;

        Arrays.sort(starts);
        Arrays.sort(ends);
        Integer[] sortedIdx = idx.clone();
        Arrays.sort(sortedIdx, Comparator.comparingInt(i -> points[i]));

        int s = 0, e = 0;
        for (int i = 0; i < m; i++) {
            int point = points[sortedIdx[i]];
            while (s < n && starts[s] <= point) s++;
            while (e < n && ends[e] < point) e++;
            cnt[sortedIdx[i]] = s - e;
        }

        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) points[i] = scanner.nextInt();

        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) System.out.print(x + " ");
        scanner.close();
    }
}
