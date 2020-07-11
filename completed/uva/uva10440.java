import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int c = Integer.parseInt(f.readLine());
        for(int T = 0; T < c; T++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arrivalTimes = new int[m];
            for(int i = 0; i < m; i++) {
                arrivalTimes[i] = Integer.parseInt(f.readLine());
            }
            Arrays.sort(arrivalTimes);
            int ans;
            int pos;
            if(m%n == 0) {
                ans = arrivalTimes[n-1]+2*t;
                pos = n;
            } else {
                ans = arrivalTimes[m%n-1]+2*t;
                pos = m%n;
            }
            while(pos < m) {
                if(ans >= arrivalTimes[pos+n-1]) {
                    ans += 2*t;
                } else {
                    ans = arrivalTimes[pos+n-1]+2*t;
                }
                pos += n;
            }
            ans -= t;
            out.println(ans + " " + (m+n-1)/n);
        }
        f.close();
        out.close();
    }
}
