import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int C = Integer.parseInt(f.readLine());
        for(int t = 0; t < C; t++) {
            int N = Integer.parseInt(f.readLine());
            int minimumSurfaceArea = Integer.MAX_VALUE;
            for(int i = 1; i <= N; i++) {
                if(N%i == 0) {
                    int twoDimensionalArea = N/i;
                    for(int j = i; j <= N; j++) {
                        if(twoDimensionalArea%j == 0) {
                            int k = twoDimensionalArea/j;
                            minimumSurfaceArea = Math.min(minimumSurfaceArea,2*(i*j+i*k+j*k));
                        }
                    }
                }
            }
            out.println(minimumSurfaceArea);
        }
        f.close();
        out.close();
    }
}
