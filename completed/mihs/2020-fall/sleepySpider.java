import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class sleepySpider {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        int[] k = new int[6];
        for(int i = 0; i < 6; i++) {
            k[i] = f.nextInt();
        }
        for(int i = 0; i < N; i++) {
            int[] nextState = k.clone();
            for(int j = 0; j < 6; j++) {
                if(k[(j+1)%6] < k[j]) {
                    nextState[j] -= k[j]/2;
                    nextState[(j+1)%6] += k[j]/2;
                }
            }
            k = nextState;
        }
        for(int i: k) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}
