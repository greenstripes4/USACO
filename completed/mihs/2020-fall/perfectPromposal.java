import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class perfectPromposal {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int M = f.nextInt();
        int count = 0;
        for(int i = 0; i < 7; i++) {
            int Qi = f.nextInt();
            if(Qi*(7-i) >= M) {
                count++;
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
