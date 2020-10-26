import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int N = f.nextInt();
            int M = f.nextInt();
            if(N == 0 && M == 0) {
                break;
            }
            int[][] calls = new int[N][2];
            for(int i = 0; i < N; i++) {
                f.nextInt();
                f.nextInt();
                calls[i][0] = f.nextInt();
                calls[i][1] = calls[i][0]+f.nextInt();
            }
            for(int i = 0; i < M; i++) {
                int start = f.nextInt();
                int end = start+f.nextInt();
                int count = 0;
                for(int[] j: calls) {
                    if(start < j[1] && end > j[0]) {
                        count++;
                    }
                }
                out.println(count);
            }
        }
        f.close();
        out.close();
    }
}
