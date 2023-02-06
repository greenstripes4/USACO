import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class quarantineQualms {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t1 = f.nextInt();
        int t2 = f.nextInt();
        int N = f.nextInt();
        int power = 0;
        for(int i = 0; i < N; i++) {
            int ti1 = f.nextInt();
            int ti2 = f.nextInt();
            power += Math.max(0,Math.min(t2,ti2)-Math.max(t1,ti1));
        }
        double safe = Math.pow(0.98,power);
        double infected = (1-safe)*100;
        out.println((int)(infected+0.5));
        f.close();
        out.close();
    }
}
