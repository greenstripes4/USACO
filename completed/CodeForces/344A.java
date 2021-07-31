import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int ans = 0;
        int prev = -1;
        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(f.readLine());
            if(cur != prev) {
                ans++;
                prev = cur;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}