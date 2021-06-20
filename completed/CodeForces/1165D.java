import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            long[] d = new long[n];
            for(int i = 0; i < n; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(d);
            long ans = d[0]*d[n-1];
            for(int i = 0; i < n; i++) {
                if(d[i]*d[n-i-1] != ans) {
                    ans = -1;
                    break;
                }
            }
            long[] dd = new long[n];
            int idx = 0;
            for(long i = 2; i*i <= ans; i++) {
                if(ans%i == 0) {
                    if(idx+1 > n) {
                        ans = -1;
                        break;
                    }
                    dd[idx++] = i;
                    if(ans/i != i) {
                        if(idx+1 > n) {
                            ans = -1;
                            break;
                        }
                        dd[idx++] = ans/i;
                    }
                }
            }
            Arrays.sort(dd);
            if(!Arrays.equals(d, dd)) {
                ans = -1;
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}