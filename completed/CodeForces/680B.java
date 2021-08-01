import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(f.readLine());
        int[] t = new int[n];
        for(int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }
        int ans = t[a];
        for(int i = 1; i < n; i++) {
            if(a-i < 0 && a+i >= n) {
                break;
            }
            if(a-i < 0) {
                ans += t[a+i];
            } else if(a+i >= n) {
                ans += t[a-i];
            } else {
                ans += t[a+i] == 1 && t[a-i] == 1 ? 2 : 0;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}