import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_SE01_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input left, right values of segment(double) and step value(double)");
        double a = Double.parseDouble(reader.readLine());
        double b = Double.parseDouble(reader.readLine());
        double h = Double.parseDouble(reader.readLine());
        for (; a <= b; a += h)
            System.out.printf("x = %.3f  F(x) = %.3f \n", a, (Math.tan(2 * a) - 3));

    }
}
