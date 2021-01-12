import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            boolean[] seen = new boolean[n];
            boolean valid = true;
            for(int j = 0; j < n; j++) {
                int temp = ((j+Integer.parseInt(st.nextToken()))%n+n)%n;
                if(seen[temp]) {
                    valid = false;
                    out.println("NO");
                    break;
                }
                seen[temp] = true;
            }
            if(valid) {
                out.println("YES");
            }
        }
        f.close();
        out.close();
    }
}