import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int ans = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int sum = 0;
            sum += Integer.parseInt(st.nextToken());
            sum += Integer.parseInt(st.nextToken());
            sum += Integer.parseInt(st.nextToken());
            if(sum > 1) {
                ans++;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}