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
            int B = f.nextInt();
            if(N == -1 && B == -1) {
                break;
            }
            int[] a = new int[N];
            int upperBound = 0;
            for(int i = 0; i < N; i++) {
                a[i] = f.nextInt();
                upperBound = Math.max(upperBound, a[i]);
            }
            int lowerBound = 1;
            int best = -1;
            while(lowerBound <= upperBound) {
                int middle = (lowerBound+upperBound)/2;
                int tempB = B;
                for(int i: a) {
                    tempB -= i/middle + (i%middle == 0 ? 0 : 1);
                    if(tempB < 0) {
                        break;
                    }
                }
                if(tempB < 0) {
                    lowerBound = middle+1;
                } else {
                    upperBound = middle-1;
                    best = middle;
                }
            }
            out.println(best);
        }
        f.close();
        out.close();
    }
}
