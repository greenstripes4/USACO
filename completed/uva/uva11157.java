import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            ArrayList<Integer> stones = new ArrayList<>();
            st = new StringTokenizer(f.readLine());
            stones.add(0);
            stones.add(0);
            for(int i = 0; i < N; i++) {
                String stone = st.nextToken();
                char S = stone.charAt(0);
                int M = Integer.parseInt(stone.substring(2));
                stones.add(M);
                if(S == 'B') {
                    stones.add(M);
                }
            }
            stones.add(D);
            stones.add(D);
            int maximumLeap = 0;
            for(int i = 0; i < stones.size()-2; i++) {
                maximumLeap = Math.max(maximumLeap,stones.get(i+2)-stones.get(i));
            }
            out.println("Case " + t + ": " + maximumLeap);
        }
        f.close();
        out.close();
    }
}
