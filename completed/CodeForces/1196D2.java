import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int q = Integer.parseInt(f.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            char[] s = f.readLine().toCharArray();
            char[] rgb = {'R', 'G', 'B'};
            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < 3; i++) {
                int cur = 0;
                for(int j = 0; j < k; j++) {
                    cur += s[j] == rgb[(i+j)%3] ? 0 : 1;
                }
                ans = Math.min(ans, cur);
                for(int j = k; j < n; j++) {
                    cur += s[j] == rgb[(i+j)%3] ? 0 : 1;
                    cur -= s[j-k] == rgb[(i+j-k)%3] ? 0 : 1;
                    ans = Math.min(ans, cur);
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}