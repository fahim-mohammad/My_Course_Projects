import java.util.*;
import java.io.*;

public class CarFueling {

    static int computeMinRefills(int dist, int tank, int[] stops) {
        int n = stops.length;
        int[] allStops = new int[n + 2];
        allStops[0] = 0;
        for (int i = 0; i < n; i++) {
            allStops[i + 1] = stops[i];
        }
        allStops[n + 1] = dist;

        int numRefills = 0;
        int currentPos = 0;

        for (int i = 0; i < allStops.length - 1; i++) {
            int lastRefill = i;
            while (i < allStops.length - 1 && allStops[i + 1] - allStops[lastRefill] <= tank) {
                i++;
            }
            if (i == lastRefill) {
                return -1;
            }
            if (i < allStops.length - 1) {
                numRefills++;
            }
            i--; // adjust for outer loop increment
        }

        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
        scanner.close();
    }
}
