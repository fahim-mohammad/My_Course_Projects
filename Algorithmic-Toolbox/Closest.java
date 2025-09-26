import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point implements Comparable<Point> {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return Long.compare(this.x, o.x);
        }
    }

    static double minimalDistance(int[] x, int[] y) {
        int n = x.length;
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) points[i] = new Point(x[i], y[i]);
        Arrays.sort(points);

        Point[] tmp = new Point[n];
        return Math.sqrt(closestPair(points, tmp, 0, n - 1));
    }

    private static long closestPair(Point[] points, Point[] tmp, int left, int right) {
        if (right - left <= 3) {
            long minDist = Long.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    minDist = Math.min(minDist, dist2(points[i], points[j]));
                }
            }
            Arrays.sort(points, left, right + 1, Comparator.comparingLong(p -> p.y));
            return minDist;
        }

        int mid = (left + right) / 2;
        long midX = points[mid].x;
        long d = Math.min(closestPair(points, tmp, left, mid), closestPair(points, tmp, mid + 1, right));

        mergeByY(points, tmp, left, mid, right);

        List<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (abs(points[i].x - midX) * abs(points[i].x - midX) < d) {
                strip.add(points[i]);
            }
        }

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) * (strip.get(j).y - strip.get(i).y) < d; j++) {
                d = Math.min(d, dist2(strip.get(i), strip.get(j)));
            }
        }

        return d;
    }

    private static long dist2(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    private static void mergeByY(Point[] points, Point[] tmp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (points[i].y <= points[j].y) tmp[k++] = points[i++];
            else tmp[k++] = points[j++];
        }
        while (i <= mid) tmp[k++] = points[i++];
        while (j <= right) tmp[k++] = points[j++];
        for (i = left; i <= right; i++) points[i] = tmp[i];
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.printf("%.6f%n", minimalDistance(x, y));
    }

    static BufferedReader reader;
    static StringTokenizer tok = new StringTokenizer("");

    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null) return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
