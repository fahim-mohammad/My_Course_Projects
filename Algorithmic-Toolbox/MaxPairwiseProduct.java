import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct(int[] numbers) {
        int n = numbers.length;
        int maxIndex1 = 0;
        for (int i = 1; i < n; i++) {
            if (numbers[i] > numbers[maxIndex1]) {
                maxIndex1 = i;
            }
        }

        int maxIndex2 = (maxIndex1 == 0) ? 1 : 0;
        for (int i = 0; i < n; i++) {
            if (i != maxIndex1 && numbers[i] > numbers[maxIndex2]) {
                maxIndex2 = i;
            }
        }

        return (long) numbers[maxIndex1] * numbers[maxIndex2];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
