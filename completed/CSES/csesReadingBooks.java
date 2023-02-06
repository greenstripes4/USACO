import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        long sum = 0;
        long max = 0;
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            sum += t;
            max = Math.max(max, t);
        }
        out.println(Math.max(sum, max*2));
        f.close();
        out.close();
    }
}