import java.io.*;
import java.util.*;

public class Main{
    private static int[] pegs;
    private static int curBall;
    private static void placeBalls(int curPeg) {
        if(curPeg == pegs.length) {
            return;
        }
        for(int i = 0; i <= curPeg; i++) {
            int integerRoot = (int) Math.sqrt(pegs[i]+curBall);
            if(pegs[i] == 0 || integerRoot*integerRoot == pegs[i]+curBall) {
                int original = pegs[i];
                pegs[i] = curBall;
                curBall++;
                placeBalls(curPeg);
                pegs[i] = original;
                return;
            }
        }
        placeBalls(curPeg+1);
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
            pegs = new int[N];
            curBall = 1;
            placeBalls(0);
            out.println(curBall-1);
        }
        f.close();
        out.close();
    }
}
