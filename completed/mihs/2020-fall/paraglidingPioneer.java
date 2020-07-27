import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class paraglidingPioneer {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        int[] L = new int[N];
        int[] U = new int[N];
        int min = 1000000;
        int max = 0;
        for(int i = 0; i < N; i++) {
            L[i] = f.nextInt();
            U[i] = f.nextInt();
            min = Math.min(min,L[i]);
            max = Math.max(max,U[i]);
        }
        int best = -1;
        int maxAppearances = 0;
        for(int i = min; i <= max; i++) {
            int appearances = 0;
            for(int j = 0; j < N; j++) {
                if(L[j] <= i && U[j] >= i) {
                    appearances++;
                }
            }
            if(appearances > maxAppearances) {
                best = i;
                maxAppearances = appearances;
            }
        }
        out.println(best);
        f.close();
        out.close();
    }
}
