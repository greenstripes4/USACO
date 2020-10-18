import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(f.readLine());
            int max = 0;
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int i = 0; i < N; i++) {
                max = Math.max(max, Integer.parseInt(st.nextToken()));
            }
            out.println("Case " + t + ": " + max);
        }
        f.close();
        out.close();
    }
}
