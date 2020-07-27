import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class antivirusAlgorithm {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        for(int i = 0; i < N; i++) {
            int Ni = f.nextInt();
            int progressBars = Ni/2;
            out.print("|");
            for(int j = 0; j < progressBars; j++) {
                out.print("|");
            }
            for(int j = progressBars; j < 50; j++) {
                out.print(" ");
            }
            out.println("|");
        }
        f.close();
        out.close();
    }
}
