import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int a = 0;
        int ans = 0;
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            int next = Integer.parseInt(st.nextToken());
            if(next >= 0) {
                a += next;
            } else {
                if(a == 0) {
                    ans++;
                } else {
                    a--;
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}