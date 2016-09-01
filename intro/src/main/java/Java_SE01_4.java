import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_SE01_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input size of array(integer) and numbers(double)");
        int n = Integer.parseInt(reader.readLine());
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = Double.parseDouble(reader.readLine());
        }

        System.out.println(getMax(a));
    }

    private static double getMax(double[] a) {
        double max = a[0] + a[a.length - 1];
        for (int i = 1; i < a.length / 2; i++) {
            double val = a[i] + a[a.length - 1 - i];
            if (max < val)
                max = val;
        }
        return max;
    }
}
