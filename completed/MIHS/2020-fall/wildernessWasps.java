import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class wildernessWasps {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int V = f.nextInt();
        int N = f.nextInt();
        int[] k = new int[N];
        for(int i = 0; i < N; i++) {
            k[i] = f.nextInt();
        }
        Arrays.sort(k);
        for(int i = 0; i <= N; i++) {
            int sum = 0;
            for(int j = 0; j < i; j++) {
                sum += k[j]*i;
            }
            if(sum > V) {
                out.println(i-1);
                break;
            }
        }
        f.close();
        out.close();
    }
}
