import java.io.*;
import java.util.*;

public class Main{
    private static int getOriginalCoconuts(int remainingCoconuts, int S, int M) {
        if(remainingCoconuts%S != 0) {
            return -1;
        }
        for(int i = 0; i < S; i++) {
            if(remainingCoconuts%(S-1) > 0) {
                return -1;
            }
            remainingCoconuts = remainingCoconuts/(S-1)*S+M;
        }
        return remainingCoconuts;
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
            int S = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            int count = 0;
            int remainingCoconuts = 0;
            while(true) {
                int originalCoconuts = getOriginalCoconuts(remainingCoconuts, S, M);
                if(originalCoconuts >= low && originalCoconuts <= high) {
                    count++;
                } else if(originalCoconuts > high) {
                    break;
                }
                remainingCoconuts++;
            }
            out.println("Case " + t + ": " + count);
        }
        f.close();
        out.close();
    }
}
