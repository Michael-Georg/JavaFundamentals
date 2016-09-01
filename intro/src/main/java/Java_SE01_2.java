import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_SE01_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input epsilon");
        double e = Double.parseDouble(reader.readLine());
        double a;
        int i = 1;
        do {
            a = fun(i);
            i++;
            System.out.println(a);
        } while (a > e);
        System.out.println(i - 1);
    }

    private static Double fun(int num) {
        return 1 / Math.pow(num + 1, 2);
    }
}
