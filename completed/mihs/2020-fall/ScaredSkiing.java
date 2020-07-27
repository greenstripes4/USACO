import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScaredSkiing {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int x1 = f.nextInt();
        int y1 = f.nextInt();
        int x2 = f.nextInt();
        int y2 = f.nextInt();
        out.println((y2-y1)/(x2-x1));
        f.close();
        out.close();
    }
}
