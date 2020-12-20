import java.io.*;
import java.util.*;

public class Main{
    private static long greatestCommonDivisor(long a, long b) {
        if(b == 0) {
            return a;
        }
        return greatestCommonDivisor(b, a%b);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long N = Integer.parseInt(st.nextToken());
            long S1 = Integer.parseInt(st.nextToken());
            long V1 = Integer.parseInt(st.nextToken());
            long S2 = Integer.parseInt(st.nextToken());
            long V2 = Integer.parseInt(st.nextToken());
            long leastCommonMultiple = S1*S2/greatestCommonDivisor(S1, S2);
            long score1 = V1*S2;
            long score2 = V2*S1;
            long firstPart;
            if(score1 > score2) {
                firstPart = (N/leastCommonMultiple-1)*(leastCommonMultiple/S1*V1);
            } else {
                firstPart = (N/leastCommonMultiple-1)*(leastCommonMultiple/S2*V2);
            }
            long secondPart = 0;
            for(long i = 0; i <= (N%leastCommonMultiple+leastCommonMultiple)/Math.max(S1, S2); i++) {
                if(S1 > S2) {
                    long numV2 = ((N%leastCommonMultiple+leastCommonMultiple)-i*S1)/S2;
                    secondPart = Math.max(secondPart, i*V1+numV2*V2);
                } else {
                    long numV1 = ((N%leastCommonMultiple+leastCommonMultiple)-i*S2)/S1;
                    secondPart = Math.max(secondPart, i*V2+numV1*V1);
                }
            }
            out.println("Case #" + t + ": " + (firstPart+secondPart));
        }
        f.close();
        out.close();
    }
}
