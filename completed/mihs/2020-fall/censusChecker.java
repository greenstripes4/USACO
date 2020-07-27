import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class censusChecker {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = 0; j < 5; j++) {
                sum += f.nextInt();
            }
            int average = f.nextInt();
            out.println(average*6-sum);
        }
        f.close();
        out.close();
    }
}
