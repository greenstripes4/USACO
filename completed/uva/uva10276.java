import java.io.*;
import java.util.*;

public class Main{
    private static int total;
    private static void placeBalls(int[] pegs, int curPeg, int curBall) {
        if(curPeg == pegs.length) {
            return;
        }
        if(pegs[curPeg] == 0) {
            pegs[curPeg] = curBall;
            total++;
            placeBalls(pegs,curPeg,curBall+1);
            pegs[curPeg] = 0;
            return;
        }
        for(int i = 0; i <= curPeg; i++) {
            int integerRoot = (int) Math.sqrt(pegs[i]+curBall);
            if(integerRoot*integerRoot == pegs[i]+curBall) {
                int original = pegs[i];
                pegs[i] = curBall;
                total++;
                placeBalls(pegs,curPeg,curBall+1);
                pegs[i] = original;
                return;
            }
        }
        placeBalls(pegs,curPeg+1,curBall);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = f.nextInt();
        for(int t = 0; t < T; t++) {
            int N = f.nextInt();
            total = 0;
            placeBalls(new int[N], 0, 1);
            out.println(total);
        }
        f.close();
        out.close();
    }
}
