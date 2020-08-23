import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int M = f.nextInt();
            int N = f.nextInt();
            if(M == 0 && N == 0) {
                break;
            }
            int ans;
            if(M == 1 || N == 1) {
                ans = Math.max(M,N);
            } else if(M == 2 || N == 2) {
                int fullTwoByTwoSectionArea = (Math.max(M,N)/4)*4;
                if(Math.max(M,N)%4 == 1) {
                    fullTwoByTwoSectionArea += 2;
                } else if(Math.max(M,N)%4 > 1) {
                    fullTwoByTwoSectionArea += 4;
                }
                ans = fullTwoByTwoSectionArea;
            } else {
                ans = (M*N+1)/2;
            }
            out.println(ans + " knights may be placed on a " + M + " row " + N + " column board.");
        }
        f.close();
        out.close();
    }
}
