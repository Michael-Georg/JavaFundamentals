/**
 * Created by Misha on 30.08.2016.
 */
public class Java_SE01_5 {
    public static void main(String[] args) {
        int size = 11;
        byte[][] a = new byte[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i == j) || (i == size - 1 - j))
                    a[i][j] = 1;
                else a[i][j]=0;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
}
