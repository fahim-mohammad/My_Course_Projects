import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        Arrays.sort(segments, Comparator.comparingInt(s -> s.end));
        List<Integer> points = new ArrayList<>();
        int i = 0;
        while (i < segments.length) {
            int point = segments[i].end;
            points.add(point);
            i++;
            while (i < segments.length && segments[i].start <= point) {
                i++;
            }
        }
        return points.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
        scanner.close();
    }
}
