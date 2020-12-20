import java.io.*;
import java.util.*;

public class Main{
    private static int solve(int n, int k) {
        if(n == 0) {
            return 0;
        }
        return (solve(n-1, k)+k)%n;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 1; t <= testcases; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            out.println("Case " + t + ": " + (solve(n, k)+1));
        }
        f.close();
        out.close();
    }
}
