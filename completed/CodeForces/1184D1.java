import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        while(t-- > 0) {
            st = new StringTokenizer(f.readLine());
            int type = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            if(type == 1) {
                n++;
                if(i <= k) {
                    k++;
                }
            } else {
                if(i < k) {
                    n -= i;
                    k -= i;
                } else {
                    n -= n-i;
                }
            }
            out.println(n + " " + k);
        }
        f.close();
        out.close();
    }
}